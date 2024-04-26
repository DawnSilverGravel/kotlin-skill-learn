package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：利用递归方法求5!。
 * @author DawnStar
 * @since : 2024/4/15
 */
class FactorialRecursive {
    fun calcFactorial(value: Int): Int {
        if (value <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        return recursive(value)
    }

    private fun recursive(num: Int): Int {
        if (num == 1) {
            return 1
        }
        return recursive(num - 1) * num
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入阶乘：")
    val value = scanner.nextInt()
    print("$value! = ${FactorialRecursive().calcFactorial(value)}")
}