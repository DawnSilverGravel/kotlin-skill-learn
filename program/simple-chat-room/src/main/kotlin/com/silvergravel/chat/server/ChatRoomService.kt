package com.silvergravel.chat.server

import com.silvergravel.chat.entity.ChatRoomDO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.time.LocalDateTime

/**
 *
 * @author DawnStar
 * @since : 2024/5/8
 */
class ChatRoomService {
    companion object {
        private val chatRooms = ArrayList<ChatRoomDO>()

        private val DATABASE_FILE = System.getProperty("user.dir") + File.separator +
                "program" + File.separator +
                "simple-chat-room" + File.separator +
                "src" + File.separator + "main" + File.separator +
                "resources" + File.separator +
                "database/chat_room.json"

        private fun writeData() {
            val fileOutputStream = FileOutputStream(DATABASE_FILE)
            fileOutputStream.use {
                it.write(Json.encodeToString(chatRooms).encodeToByteArray())
            }
        }


        init {
            // 读取存储数据
            val inputStream = FileInputStream(DATABASE_FILE)

            inputStream.use {
                val readBytes = it.readBytes()
                if (readBytes.size > 1) {
                    val chatRoomList = Json.decodeFromString<List<ChatRoomDO>>(readBytes.decodeToString())
                    chatRooms.addAll(chatRoomList)
                }
            }
            chatRooms.forEach {
                CommunicationManager.createRoomPoint(it.name)
            }
        }


    }

    fun createRoom(name: String, creator: String): Boolean {
        // 读取数据
        val exists = chatRooms.any { it.name == name }
        if (exists) {
            return false
        }
        val chatRoomDO = ChatRoomDO(name, creator, LocalDateTime.now())
        chatRooms.add(chatRoomDO)
        writeData()
        return true
    }

    fun removeRoom(name: String, creator: String): Boolean {
        val match = chatRooms.any { it.name == name && it.creator == creator }
        if (match) {
            chatRooms.removeIf { it.name == name }
            writeData()
            return true
        }
        return false
    }

    fun listChatRoom(): List<String> {
        return chatRooms.map { it.name }.toList()
    }
}