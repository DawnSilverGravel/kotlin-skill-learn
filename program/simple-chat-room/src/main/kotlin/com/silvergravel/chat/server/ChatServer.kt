package com.silvergravel.chat.server

import java.net.ServerSocket
import java.util.logging.Logger

class ChatServer(private val port: Int) {


    private val logger = Logger.getLogger("chatServer")

    private val loginService = LoginService()
    private val chatRoomService = ChatRoomService()

    private fun setup() {
        val serverSocket = ServerSocket(this.port)
        logger.info("聊天室启动...")
        logger.info("端口号$port")
        serverSocket.use {
            while (true) {
                val accept = it.accept()
                // 将socket加入线程组
                Thread(ChatSocket(accept, ChatSocketService(loginService, chatRoomService))).start()
            }
        }
    }

    init {
        setup()
    }


}