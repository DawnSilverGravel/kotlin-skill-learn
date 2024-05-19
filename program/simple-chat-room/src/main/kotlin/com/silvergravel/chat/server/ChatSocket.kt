package com.silvergravel.chat.server

import com.silvergravel.chat.protocol.NetworkData
import com.silvergravel.chat.protocol.ProtocolTypeEnum
import com.silvergravel.chat.util.NetworkUtil
import java.net.Socket
import java.util.logging.Logger

/**
 *
 * @author DawnStar
 * @since : 2024/5/9
 */
class ChatSocket(private val socket: Socket, private val chatSocketService: ChatSocketService) : Runnable {
    private val logger = Logger.getLogger("ChatSocket")
    override fun run() {
        try {
//
            while (true) {
                val receive = NetworkUtil.receive(socket)
                parseData(receive)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            logger.warning("$e")
        }
    }

    private fun parseData(networkData: NetworkData) {
//        val networkData = Json.decodeFromString<NetworkData>(data.decodeToString())
        when (networkData.type) {
            ProtocolTypeEnum.LOGIN -> chatSocketService.login(networkData.data, socket)
            ProtocolTypeEnum.REGISTER -> chatSocketService.register(networkData.data, socket)
            ProtocolTypeEnum.MESSAGE -> chatSocketService.message(networkData.data, socket)
            ProtocolTypeEnum.CHAT_ROOM_CREATE -> chatSocketService.createChatRoom(networkData.data, socket)
            ProtocolTypeEnum.CHAT_ROOM_REMOVE -> chatSocketService.removeChatRoom(networkData.data, socket)
            ProtocolTypeEnum.EXIT_CHAT_ROOM -> chatSocketService.exitChatRoom(networkData.data, socket)
            ProtocolTypeEnum.JOIN_CHAT_ROOM -> chatSocketService.joinChatRoom(networkData.data, socket)
            ProtocolTypeEnum.CHAT_ROOM_LIST -> chatSocketService.listChatRoom(socket)
            ProtocolTypeEnum.LOGOUT -> chatSocketService.logout(socket)
            else -> {} // 解散聊天室不处理，属于服务端
        }
    }


}