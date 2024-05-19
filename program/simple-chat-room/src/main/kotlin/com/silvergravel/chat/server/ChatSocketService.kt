package com.silvergravel.chat.server

import com.silvergravel.chat.protocol.*
import com.silvergravel.chat.util.NetworkUtil
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.Socket

class ChatSocketService(private val loginService: LoginService, private val chatRoomService: ChatRoomService) {

    private val communication = CommunicationManager


    fun login(data: String, socket: Socket) {
        val useRequest = Json.decodeFromString<UserRequest>(data)
        val login = loginService.login(useRequest.username, useRequest.password)
        if (login) {
            communication.bindSocketUsername(socket, useRequest.username)
            val networkData = NetworkData(
                ProtocolTypeEnum.LOGIN,
                Json.encodeToString(NetworkResponse(200, "${useRequest.username} 登陆成功"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val networkData =
            NetworkData(ProtocolTypeEnum.LOGIN, Json.encodeToString(NetworkResponse(1000, "用户名或者密码错误")))
        NetworkUtil.transform(socket, networkData)

    }

    fun register(data: String, socket: Socket) {
        val useRequest = Json.decodeFromString<UserRequest>(data)
        val register = loginService.register(useRequest.username, useRequest.password)
        if (register) {
            val networkData = NetworkData(
                ProtocolTypeEnum.REGISTER,
                Json.encodeToString(NetworkResponse(200, "${useRequest.username} 注册成功"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val networkData = NetworkData(
            ProtocolTypeEnum.REGISTER,
            Json.encodeToString(NetworkResponse(1001, "${useRequest.username} 账号已存在，注册失败"))
        )
        NetworkUtil.transform(socket, networkData)
    }

    fun message(data: String, socket: Socket) {
        val message = Json.decodeFromString<Message>(data)
        communication.notifyChatRoomMember(message, socket)

    }

    fun createChatRoom(data: String, socket: Socket) {
        val chatRoomRequest = Json.decodeFromString<ChatRoomRequest>(data)
        val username = communication.getUsernameBySocket(socket)
        if (username == null) {
            val networkData = NetworkData(
                ProtocolTypeEnum.CHAT_ROOM_CREATE,
                Json.encodeToString(NetworkResponse(1001, "当前连接用户不存在，注册聊天室失败"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val createRoom = chatRoomService.createRoom(chatRoomRequest.name, username)
        if (createRoom) {
            val networkData = NetworkData(
                ProtocolTypeEnum.CHAT_ROOM_CREATE,
                Json.encodeToString(NetworkResponse(200, "${chatRoomRequest.name} 创建成功"))
            )
            // 建立监听点
            communication.createRoomPoint(chatRoomRequest.name)
            NetworkUtil.transform(socket, networkData)
            return
        }
        val networkData = NetworkData(
            ProtocolTypeEnum.CHAT_ROOM_CREATE,
            Json.encodeToString(NetworkResponse(1002, "${chatRoomRequest.name} 聊天室已存在"))
        )
        NetworkUtil.transform(socket, networkData)
    }

    fun removeChatRoom(data: String, socket: Socket) {
        val chatRoomRequest = Json.decodeFromString<ChatRoomRequest>(data)
        val username = communication.getUsernameBySocket(socket)
        if (username == null) {
            val networkData = NetworkData(
                ProtocolTypeEnum.CHAT_ROOM_REMOVE,
                Json.encodeToString(NetworkResponse(1001, "当前连接未登录，删除聊天室失败"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val removeRoom = chatRoomService.removeRoom(chatRoomRequest.name, username)
        if (removeRoom) {
            val networkData = NetworkData(
                ProtocolTypeEnum.CHAT_ROOM_CREATE,
                Json.encodeToString(NetworkResponse(200, "${chatRoomRequest.name} 删除成功"))
            )
            NetworkUtil.transform(socket, networkData)
            // 删除聊天室断点
            communication.removeRoomPoint(chatRoomRequest.name)

            return
        }
        val networkData = NetworkData(
            ProtocolTypeEnum.CHAT_ROOM_CREATE,
            Json.encodeToString(NetworkResponse(1003, "${chatRoomRequest.name} 删除失败"))
        )
        NetworkUtil.transform(socket, networkData)
    }

    fun exitChatRoom(data: String, socket: Socket) {
        val chatRoomRequest = Json.decodeFromString<ChatRoomRequest>(data)
        communication.unsubscribeChatRoom(chatRoomRequest.name, socket)
        val username = communication.getUsernameBySocket(socket)
        communication.notifyChatRoomMember(
            Message(
                chatRoomRequest.name,
                "",
                "$username 退出聊天室",
                Message.Type.SYSTEM
            ), socket
        )
        NetworkUtil.transform(
            socket,
            NetworkData(ProtocolTypeEnum.EXIT_CHAT_ROOM, Json.encodeToString(NetworkResponse(200, "退出聊天室成功")))
        )
    }

    fun joinChatRoom(data: String, socket: Socket) {
        val chatRoomRequest = Json.decodeFromString<ChatRoomRequest>(data)
        val username = communication.getUsernameBySocket(socket)
        if (username == null) {
            val networkData = NetworkData(
                ProtocolTypeEnum.JOIN_CHAT_ROOM,
                Json.encodeToString(NetworkResponse(1001, "当前连接未登录，加入聊天室失败"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val subscribeChatRoom = communication.subscribeChatRoom(chatRoomRequest.name, socket)
        if (subscribeChatRoom) {
            communication.notifyChatRoomMember(
                Message(
                    chatRoomRequest.name,
                    "",
                    "$username 加入聊天室",
                    Message.Type.SYSTEM
                ), socket
            )
            val networkData = NetworkData(
                ProtocolTypeEnum.JOIN_CHAT_ROOM,
                Json.encodeToString(NetworkResponse(200, "加入 ${chatRoomRequest.name} 成功"))
            )
            NetworkUtil.transform(socket, networkData)
            return
        }
        val networkData = NetworkData(
            ProtocolTypeEnum.JOIN_CHAT_ROOM,
            Json.encodeToString(NetworkResponse(1004, "加入 ${chatRoomRequest.name} 失败，当前聊天室不存在"))
        )
        NetworkUtil.transform(socket, networkData)
    }


    fun listChatRoom(socket: Socket) {
        val chatRooms = chatRoomService.listChatRoom()
        communication.createRoomPoints(chatRooms)
        val networkData = NetworkData(ProtocolTypeEnum.CHAT_ROOM_LIST, Json.encodeToString(chatRooms))
        NetworkUtil.transform(socket, networkData)
    }

    fun logout(socket: Socket) {
        val username = communication.unbindSocketUsername(socket)

        val response = if (username == null)
            NetworkResponse(1003, "退出失败，服务未找到匹配用户名称")
        else NetworkResponse(200, "$username 退出成功")
        val networkData = NetworkData(
            ProtocolTypeEnum.LOGOUT,
            Json.encodeToString(response)
        )
        NetworkUtil.transform(socket, networkData)
    }
}
