package com.silvergravel.basic

import java.lang.StringBuilder
import java.util.*

/**
 * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字
 * @author DawnStar
 * @since : 2024/4/16
 */
class DigitJudge {
    fun judgeDigit(num: Int): Pair<Int, String> {
        if (num < 100) {
            throw IllegalArgumentException("非法参数")
        }
        num.toString().let {
            val builder = StringBuilder()
            for (i in it.length.minus(1).downTo(0)) {
                builder.append(it[i])
                if (i != 0) {
                    builder.append(",")
                }
            }
            return Pair(it.length, builder.toString())
        }

    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入正整数：")
    val num = scanner.nextInt()
    val (digit, value) = DigitJudge().judgeDigit(num)
    print("$num 是 $digit 位数：$value")
}