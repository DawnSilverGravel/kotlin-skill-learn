package com.silvergravel.chat.protocol

import kotlinx.serialization.Serializable

/**
 * @author DawnStar
 * @see 2024/5/8
 */
@Serializable
data class NetworkData(val type: ProtocolTypeEnum, val data: String)