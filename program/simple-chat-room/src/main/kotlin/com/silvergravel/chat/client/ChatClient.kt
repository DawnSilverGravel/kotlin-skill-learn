package com.silvergravel.chat.client

import com.silvergravel.chat.protocol.*
import com.silvergravel.chat.util.NetworkUtil
import com.silvergravel.chat.util.StdColorEnum
import com.silvergravel.chat.util.StdUtil
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.Socket
import java.util.*
import java.util.concurrent.TimeUnit


class ChatClient(address: String, serverPort: Int) {

    private val socket: Socket = Socket(address, serverPort)
    private var username = ""

    private var chatRoomName = ""

    private val contentBuilder = StringBuilder()

    private var chatStatus = false


    private val backgroundListenerHandler = BackgroundListenerHandler(this)


    private val scanner = Scanner(System.`in`)

    init {
        setup()
    }

    private fun setup() {
        Thread(backgroundListenerHandler).start()
        while (true) {
            login()
            chatRoom()
            communication()
        }
    }

    private fun communication() {
        if (username.isBlank() || chatRoomName.isBlank()) {
            return
        }
        // 线程 读取信息
        chatStatus = true
        backgroundListenerHandler.startListener()
        contentBuilder.clear()
        var repeat = (100 - chatRoomName.length - 6).div(2)
        contentBuilder.append("-".repeat(repeat))
            .append(chatRoomName).append("聊天室频道")
            .append("-".repeat(repeat))
            .append("\n")
        StdUtil.cls()
        StdUtil.println(contentBuilder, StdColorEnum.ANSI_PURPLE)
        while (true) {
            TimeUnit.MILLISECONDS.sleep(20)
            if (chatRoomName.isBlank()) {
                return
            }
            if (!chatStatus) {
                continue
            }
            val networkData = receive()
            if (ProtocolTypeEnum.MESSAGE == networkData.type) {
                val message = Json.decodeFromString<Message>(networkData.data)
                if (contentBuilder.isNotEmpty()) {
                    contentBuilder.append("\n")
                }
                if (Message.Type.COMMON == message.type) {
                    val targetMessage = message.fromUsername + "：" + message.content
                    targetMessage.chunked(30).also {

                        it.forEachIndexed { index, subContent ->
                            contentBuilder.append(subContent)
                            if (index != it.size - 1) {
                                contentBuilder.append("\n")
                            }
                        }
                    }
                    StdUtil.cls()
                    StdUtil.println(contentBuilder, StdColorEnum.ANSI_PURPLE)
                    continue
                }
                val div = (100 - message.content.length).div(2)
                contentBuilder.append("-".repeat(div))
                    .append(message.content)
                    .append("-".repeat(div))
                StdUtil.cls()
                StdUtil.println(contentBuilder, StdColorEnum.ANSI_PURPLE)
                continue
            }
            if (ProtocolTypeEnum.EXIT_CHAT_ROOM == networkData.type) {
                val response = Json.decodeFromString<NetworkResponse>(networkData.data)
                if (response.code == 200) {
                    contentBuilder.clear()
                    StdUtil.cls()
                    StdUtil.println(response.message, StdColorEnum.ANSI_GREEN)
                    chatRoomName = ""
                    backgroundListenerHandler.stopListener()
                    return
                }
                backgroundListenerHandler.startListener()
                StdUtil.printlnErr(response.message)
            }
            if (ProtocolTypeEnum.Dissolve_Chat_Room == networkData.type) {
                val dissolveChatRoom = Json.decodeFromString<String>(networkData.data)
                repeat = (100 - dissolveChatRoom.length - 6).div(2)
                contentBuilder.append("\n")
                    .append("-".repeat(repeat))
                    .append(dissolveChatRoom).append("聊天频道解散")
                    .append("-".repeat(repeat))
                    .append("\n")
                StdUtil.println(contentBuilder.toString(), StdColorEnum.ANSI_CYAN)
                StdUtil.println("请输入任意键结束", StdColorEnum.ANSI_YELLOW)
                chatStatus = false
                backgroundListenerHandler.stopListener()
            }
        }


    }

    private fun receive(): NetworkData {
        return NetworkUtil.receive(socket)
    }

    private fun send(networkData: NetworkData) {
        NetworkUtil.transform(this.socket, networkData)
    }

    private fun chatRoom() {
        while (chatRoomName.isBlank()) {

            send(NetworkData(ProtocolTypeEnum.CHAT_ROOM_LIST, ""))
            val receive = receive()
            val data = Json.decodeFromString<List<String>>(receive.data)
            val chatRooms = data.toMutableList().apply {
                this.add("创建聊天室")
                this.add("删除聊天室")
                this.add("退出登录")
            }
            val spaceLength = chatRooms.maxBy { it.length }.length

            val builder = StringBuilder()
            builder.append("\t\t-------------------------------------\n")
            chatRooms.forEachIndexed { index, chatRoomName ->
                run {
                    builder.append("\t".repeat(2))
                        .append("|")
                        .append("\t".repeat(3))
                        .append(index + 1).append(". ")
                        .append(chatRoomName)
                        .append("   ".repeat(spaceLength - chatRoomName.length))
                        .append("\t".repeat(3))
                        .append("|\n")
                }
            }
            builder.append("\t\t-------------------------------------\n")
            StdUtil.println(builder, StdColorEnum.ANSI_WHITE)
            StdUtil.print("请输入选项：", StdColorEnum.ANSI_WHITE)
            val option = scanner.nextInt()
            if (option > chatRooms.size || option < 0) {
                StdUtil.printlnErr("非法参数")
                continue
            }
            val optionName = chatRooms[option - 1]
            if (optionName == "创建聊天室" || optionName == "删除聊天室") {
                val (protocolType, message) = if (optionName == "创建聊天室") Pair(
                    ProtocolTypeEnum.CHAT_ROOM_CREATE,
                    "请输入创建聊天室名称："
                ) else Pair(ProtocolTypeEnum.CHAT_ROOM_REMOVE, "请输入删除聊天室名称：")
                StdUtil.print(message, StdColorEnum.ANSI_BLUE)
                val chatRoomName = scanner.next()
                send(NetworkData(protocolType, Json.encodeToString(ChatRoomRequest(chatRoomName))))
                val networkData = receive()
                val response = Json.decodeFromString<NetworkResponse>(networkData.data)
                if (response.code != 200) {
                    StdUtil.printlnErr(response.message)
                    continue
                }
                StdUtil.println(response.message, StdColorEnum.ANSI_GREEN)
                continue
            }
            if (optionName == "退出登录") {
                username = ""
                send(NetworkData(ProtocolTypeEnum.LOGOUT, ""))
                receive()
                return
            }
            chatRoomName = optionName
            send(NetworkData(ProtocolTypeEnum.JOIN_CHAT_ROOM, Json.encodeToString(ChatRoomRequest(chatRoomName))))
            val response = Json.decodeFromString<NetworkResponse>(receive().data)
            if (response.code != 200) {
                StdUtil.printlnErr(response.message)
                continue
            }
            StdUtil.println(response.message, StdColorEnum.ANSI_GREEN)
            return
        }
    }

    private fun login() {
        while (username.isBlank()) {
            val builder = StringBuilder()
            builder.append("\t\t-------------------------------------\n")
                .append("\t".repeat(2))
                .append("|")
                .append("\t".repeat(3))
                .append("1. 登录")
                .append("\t".repeat(5))
                .append("|\n")
                .append("\t".repeat(2))
                .append("|")
                .append("\t".repeat(3))
                .append("2. 注册").append("\t".repeat(5))
                .append("|\n")
                .append("\t".repeat(2))
                .append("-------------------------------------\n")
            StdUtil.println(builder, StdColorEnum.ANSI_WHITE)
            StdUtil.print("请输入选项：", StdColorEnum.ANSI_WHITE)
            val option = scanner.nextInt()
            if (option < 1 || option > 2) {
                StdUtil.printlnErr("非法参数")
                continue
            }
            val type = if (option == 1) ProtocolTypeEnum.LOGIN else ProtocolTypeEnum.REGISTER
            print("请输入账号：")
            val username = scanner.next()
            print("请输入密码：")
            val password = scanner.next()
            val userRequest = UserRequest(username, password)
            send(NetworkData(type, Json.encodeToString(userRequest)))
            val networkData = receive()
            val networkResponse = Json.decodeFromString<NetworkResponse>(networkData.data)
            if (networkResponse.code != 200) {
                StdUtil.printlnErr(networkResponse.message)
                continue
            }
            StdUtil.println(networkResponse.message, StdColorEnum.ANSI_GREEN)
            if (ProtocolTypeEnum.LOGIN == networkData.type) {
                this.username = username
            }
        }
    }

    class BackgroundListenerHandler(private val chatClient: ChatClient) : Runnable {
        private var backgroundListener = false
        fun startListener() {
            backgroundListener = true
        }

        fun stopListener() {
            backgroundListener = false
        }

        private fun send() {
            val contentBuilder = chatClient.contentBuilder
            val socket = chatClient.socket
            val chatRoomName = chatClient.chatRoomName
            val username = chatClient.username
            val content = chatClient.scanner.next()
            if (!chatClient.chatStatus) {
                chatClient.chatRoomName = ""
                stopListener()
                return
            }
            if (content == "#${ProtocolTypeEnum.EXIT_CHAT_ROOM}") {
                NetworkUtil.transform(
                    socket,
                    NetworkData(
                        ProtocolTypeEnum.EXIT_CHAT_ROOM,
                        Json.encodeToString(ChatRoomRequest(chatRoomName))
                    )
                )
                stopListener()
                return
            }
            val chunked = content.chunked(30)
            chunked.forEachIndexed { index, subContent ->
                val size = subContent.encodeToByteArray().size
                val chineseWords =
                    if ((size - subContent.length).rem(3) == 0) (size - subContent.length).div(3) else (size - subContent.length).div(
                        3
                    ) + 1
                contentBuilder
                    .append("\t".repeat(10))
                    .append(" ".repeat(60 - chineseWords - subContent.length))
                    .append(subContent)


                if (index == 0) {
                    contentBuilder.append(" :")
                        .append(username)
                }
                contentBuilder.append("\n")
            }
            StdUtil.cls()
            StdUtil.print(contentBuilder, StdColorEnum.ANSI_PURPLE)
            NetworkUtil.transform(
                socket,
                NetworkData(
                    ProtocolTypeEnum.MESSAGE,
                    Json.encodeToString(
                        Message(
                            chatRoomName,
                            username,
                            content,
                            Message.Type.COMMON
                        )
                    )
                )
            )
        }

        override fun run() {
            StdUtil.println("后台线程启动...", StdColorEnum.ANSI_YELLOW)
            while (true) {
                TimeUnit.MILLISECONDS.sleep(10)
                if (backgroundListener) {
                    send()
                }
            }
        }

    }
}

fun main() {
    ChatClient("localhost", 9000)

}
