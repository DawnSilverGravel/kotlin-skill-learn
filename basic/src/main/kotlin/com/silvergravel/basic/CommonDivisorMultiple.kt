package com.silvergravel.basic

import java.util.*

/**
 * 最大公约数 最小公倍数
 * @author DawnStar
 * @since : 2024/4/10
 */
class CommonDivisorMultiple {
    fun maxMultiple(number1: Int, number2: Int): Int {
        check(number1, number2)
        if (number1 > number2) {
            return gcd(number2, number1.rem(number2))
        }
        return gcd(number1, number2.rem(number1))
    }

    private fun gcd(dividend: Int, remainder: Int): Int {
        if (remainder == 0) {
            return dividend
        }
        return gcd(remainder, dividend.rem(remainder))
    }

    private fun check(number1: Int, number2: Int) {
        if (number1 < 0 || number2 < 0) {
            throw IllegalArgumentException("两个整数都必须为正整数！")
        }
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("第一个正整数：")
    val first = scanner.nextInt()
    print("第二个正整数：")
    val second = scanner.nextInt()
    val maxMultiple = CommonDivisorMultiple().maxMultiple(first, second)
    println("$first 与 $second 的最大公约数为：$maxMultiple，最小公倍数为：${first.times(second).div(maxMultiple)}")


}