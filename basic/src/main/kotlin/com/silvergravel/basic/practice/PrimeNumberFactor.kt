package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：将一个正整数分解质因数。例如：输入90,打印出 90 = 2 * 3 * 3 *5
 *
 * @author DawnStar
 * @since : 2024/4/9
 */
class PrimeNumberFactor {
    fun getPrimeNumberFactorList(number: Int): List<Int> {
        var num = number
        return mutableListOf(1).apply {
            for (i in 2..number) {
                while (num.rem(i) == 0 && num != i) {
                    // Kotlin 1.9.23版本 有 number.divAssign(i)
                    num /= i
                    add(i)
                }
                if (num == i) {
                    add(i)
                }
            }
        }
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入数字：")
    val number = scanner.nextInt()
    val factorList = PrimeNumberFactor().getPrimeNumberFactorList(number)
    val joinToString = factorList.joinToString(" * ")
    println("$number = $joinToString")
}