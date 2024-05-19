package com.silvergravel.chat.server

import com.silvergravel.chat.protocol.Message
import com.silvergravel.chat.protocol.NetworkData
import com.silvergravel.chat.protocol.ProtocolTypeEnum
import com.silvergravel.chat.util.NetworkUtil
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.Socket
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Logger

object CommunicationManager {
    private val roomSocketMap = ConcurrentHashMap<String, MutableList<Socket>>()
    private val socketUsernameMap = ConcurrentHashMap<Socket, String>()
    private val logger = Logger.getLogger("CommunicationManager")
    private val existsRoomPoint = hashSetOf<String>()


    fun getUsernameBySocket(socket: Socket): String? {
        return socketUsernameMap[socket]
    }

    fun bindSocketUsername(socket: Socket, username: String) {
        socketUsernameMap[socket] = username
    }

    fun unbindSocketUsername(socket: Socket): String? {
        return socketUsernameMap.remove(socket)
    }

    fun subscribeChatRoom(chatroomName: String, socket: Socket): Boolean {
        val sockets = roomSocketMap[chatroomName] ?: return false
        sockets.add(socket)
        logger.info("$socket 加入 $chatroomName 聊天室")
        return true
    }

    fun unsubscribeChatRoom(chatroomName: String, socket: Socket) {
        val sockets = roomSocketMap[chatroomName] ?: return
        sockets.remove(socket)
    }

    fun notifyChatRoomMember(message: Message, socket: Socket) {
        val sockets = roomSocketMap[message.chatRoom]
        val socketArrayList = arrayListOf<Socket>()
        sockets?.forEach {
            if (it != socket) {
                try {
                    if (it.isClosed || !it.isConnected) {
                        socketArrayList.add(it)
                    } else {
                        val networkData = NetworkData(ProtocolTypeEnum.MESSAGE, Json.encodeToString(message))
                        logger.info(networkData.toString())
                        NetworkUtil.transform(it, networkData)
                    }
                } catch (e: Exception) {
                    socketArrayList.add(it)
                }
            }

        }
        sockets?.removeAll(socketArrayList)
        socketArrayList.forEach { socketUsernameMap.remove(it) }
    }

    fun createRoomPoint(roomName: String) {
        roomSocketMap.putIfAbsent(roomName, arrayListOf())
        existsRoomPoint.add(roomName)
    }

    fun removeRoomPoint(roomName: String) {
        val sockets = roomSocketMap.remove(roomName)
        sockets?.forEach {
            try {
                val networkData = NetworkData(ProtocolTypeEnum.Dissolve_Chat_Room,Json.encodeToString(roomName))
                logger.info("$roomName 解散")
                NetworkUtil.transform(it, networkData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        existsRoomPoint.remove(roomName)

    }

    fun createRoomPoints(chatRooms: List<String>) {
        chatRooms.filter { !existsRoomPoint.contains(it) }.toList().also { it ->
            if (it.isNotEmpty()) {
                it.forEach { createRoomPoint(it) }
            }
        }

    }


}