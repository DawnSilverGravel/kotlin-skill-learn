package com.silvergravel.chat.protocol

import kotlinx.serialization.Serializable

/**
 *
 * @author DawnStar
 * @since : 2024/5/8
 */
@Serializable
data class ChatRoomRequest(val name: String)