package com.silvergravel.basic.practice

import java.util.*
import kotlin.math.sqrt

/**
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数
 * @author DawnStar
 * @since 2024/04/11
 */
class PerfectNumber {
    fun isPerfectNumber(number: Int): Pair<Boolean, List<Int>> {
        val sqrt = sqrt(number.toDouble()).toInt()
        val factors = mutableListOf(1).apply {
            for (i in 2..sqrt) {
                if (number.rem(i) == 0) {
                    add(i)
                    add(number.div(i))
                }
            }
        }.sorted()

        if (factors.sum() == number) {
            return Pair(true, factors)
        }
        // 非完数返回空避免占用内存
        return Pair(false, listOf())
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入上界正整数：")
    val upperNumber = scanner.nextInt()

    val perfectNumber = PerfectNumber()
    for (number in 0..upperNumber) {
        val (condition, factors) = perfectNumber.isPerfectNumber(number)
        if (condition) {
            println("$number 是一个完数：$number = ${factors.joinToString("+")}")
        }
    }
}