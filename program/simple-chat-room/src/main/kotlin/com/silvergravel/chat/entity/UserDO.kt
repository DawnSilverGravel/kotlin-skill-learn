package com.silvergravel.chat.entity

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class UserDO(
    val name: String, val password: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createTime: LocalDateTime
)
