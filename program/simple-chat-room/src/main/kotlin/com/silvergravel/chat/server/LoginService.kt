package com.silvergravel.chat.server

import com.silvergravel.chat.entity.UserDO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.time.LocalDateTime

class LoginService {

    companion object {
        private val users = ArrayList<UserDO>()

        private val DATABASE_FILE = System.getProperty("user.dir") + File.separator +
                "program" + File.separator +
                "simple-chat-room" + File.separator +
                "src" + File.separator + "main" + File.separator +
                "resources" + File.separator +
                "database/user.json"
        private fun writeData() {
            val fileOutputStream = FileOutputStream(DATABASE_FILE)
            fileOutputStream.use {
                it.write(Json.encodeToString(users).encodeToByteArray())
            }
        }

        init {
            // 读取存储数据
            val inputStream = FileInputStream(DATABASE_FILE)

            inputStream.use {
                val readBytes = it.readBytes()
                if (readBytes.size > 1) {
                    val userList = Json.decodeFromString<List<UserDO>>(readBytes.decodeToString())
                    users.addAll(userList)
                }
            }
            println(users)
        }
    }

    fun login(name: String, password: String): Boolean {
        return users.any { it.name == name && it.password == password }
    }

    fun register(name: String, password: String): Boolean {
        val any = users.any { it.name == name }
        if (any) {
            return false
        }
        users.add(UserDO(name, password, LocalDateTime.now()))
        writeData()
        return true
    }

}
