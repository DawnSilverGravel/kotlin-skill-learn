package com.silvergravel.chat.protocol

import kotlinx.serialization.Serializable

@Serializable
data class Message(val chatRoom: String, val fromUsername: String, val content: String, val type: Type) {
    enum class Type {
        COMMON,
        SYSTEM
    }
}