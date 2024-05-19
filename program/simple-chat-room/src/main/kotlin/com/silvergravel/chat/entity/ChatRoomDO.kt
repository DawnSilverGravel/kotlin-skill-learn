package com.silvergravel.chat.entity

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class ChatRoomDO(
    val name: String,
    val creator: String,
    @Serializable(with = LocalDateTimeSerializer::class) val createTime: LocalDateTime
)