package com.silvergravel.chat.util

/**
 *
 * @author DawnStar
 * @since : 2024/5/18
 */
object StdUtil {

    fun print(message: Any?, stdColorEnum: StdColorEnum) {
        print("${stdColorEnum.color}${message}${stdColorEnum.color}")
    }

    fun println(message: Any?, stdColorEnum: StdColorEnum) {
        println("${stdColorEnum.color}${message}${stdColorEnum.color}")
    }

    fun printlnErr(message: Any?) {
        println("${StdColorEnum.ANSI_RED.color}${message}")
    }

    fun cls() {
        // 无法干扰 IDEA 控制台
        print("\u001B[2J")
        print("\u001B[0;0H")
        for (i in 0..30) {
            println()
        }
    }

}