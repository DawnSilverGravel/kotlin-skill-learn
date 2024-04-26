package com.silvergravel.basic.practice

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * 题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的`＊`
 * @author DawnStar
 * @since : 2024/4/21
 */
class AsteriskPrint {
    fun print(column: Int) {
        if (column <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        val current = ThreadLocalRandom.current()
        for (i in 1..column) {
            val number = current.nextInt(1, 51)
            println("*".repeat(number))
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入打印列数：")
    val column = scanner.nextInt()
    AsteriskPrint().print(column)
}