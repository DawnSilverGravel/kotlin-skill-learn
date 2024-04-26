package com.silvergravel.basic.practice

import java.lang.StringBuilder
import java.util.*

/**
 * 题目：编写一个函数，
 * 输入n为偶数时，调用函数求1/2+1/4+...+1/n,
 * 当输入n为奇数时，调用函数1/1+1/3+...+1/n
 * @author DawnStar
 * @since : 2024/4/20
 */
class OddEvenMethod {
    fun sumFraction(number: Int): Pair<Double, String> {
        val startDenominator = 2 - number.rem(2)
        var sum = 0.0
        val builder = StringBuilder()
        for (i in startDenominator..number step 2) {
            builder.append("1/$i")
            sum += 1.0 / i
            if (i != number) {
                builder.append(" + ")
            }
        }
        return Pair(sum, builder.toString())
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入整数：")
    val number = scanner.nextInt()
    val (sum, string) = OddEvenMethod().sumFraction(number)
    println("$string = $sum")
}