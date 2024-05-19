package com.silvergravel.chat.protocol

import kotlinx.serialization.Serializable

/**
 *
 * @author DawnStar
 * @since : 2024/5/15
 */
@Serializable
data class NetworkResponse(val code: Int, val message: String)