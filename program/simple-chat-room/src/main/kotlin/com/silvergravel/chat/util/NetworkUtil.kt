package com.silvergravel.chat.util

import com.silvergravel.chat.protocol.NetworkData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.Socket

object NetworkUtil {
    fun transform(socket: Socket, networkData: NetworkData) {

        val byteArray = Json.encodeToString(networkData).encodeToByteArray()
        socket.getOutputStream().write(intToByteArray(byteArray.size))
        socket.getOutputStream().flush()
        socket.getOutputStream().write(byteArray)
        socket.getOutputStream().flush()
    }

    fun receive(socket: Socket): NetworkData {
        val lengthBytes = ByteArray(4)
        socket.getInputStream().read(lengthBytes)
        val byteArrayToInt = byteArrayToInt(lengthBytes)
        val bytes = ByteArray(byteArrayToInt)
        socket.getInputStream().read(bytes)


        return Json.decodeFromString(bytes.decodeToString())
    }

    private fun intToByteArray(value: Int): ByteArray {
        return byteArrayOf(
            (value ushr 24).toByte(), // 最高位字节
            (value ushr 16 and 0xFF).toByte(),
            (value ushr 8 and 0xFF).toByte(),
            (value and 0xFF).toByte() // 最低位字节
        )
    }

    private fun byteArrayToInt(byteArray: ByteArray, offset: Int = 0): Int {
        return (byteArray[offset].toInt() and 0xFF shl 24) or
                ((byteArray[offset + 1].toInt() and 0xFF) shl 16) or
                ((byteArray[offset + 2].toInt() and 0xFF) shl 8) or
                (byteArray[offset + 3].toInt() and 0xFF)
    }

}
