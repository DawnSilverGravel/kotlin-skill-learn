package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：求0—7所能组成的奇数个数
 * @author DawnStar
 * @since : 2024/4/21
 */
class OddCounter {
    fun count(number: Int): Int {
        if (number < 0 || number > 7) {
            throw IllegalArgumentException("非法参数")
        }
        if (number == 1) {
            return 1
        }
        val tail = (number + 1) / 2
        val counter = (tail * number + tail)
        var temp = 0
        var step = number + 1
        for (i in 3..number) {
            temp += step * number
            step *= (number + 1)
        }
        return counter + temp * tail
    }

    fun print(number: Int) {
        if (number < 0 || number > 7) {
            throw IllegalArgumentException("非法参数")
        }

    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入最高位数：")
    val number = scanner.nextInt()
    println("0—${number}所能组成的奇数个数${OddCounter().count(number)}")

}