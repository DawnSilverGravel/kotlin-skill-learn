package com.silvergravel.basic.practice

import kotlin.math.sqrt

/**
 * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 * @author DawnStar
 * @since : 2024/4/13
 */
class PerfectSquare {
    fun multipleNumber(upper: Int): List<String> {
        if (upper <= 0) {
            throw IllegalArgumentException("参数不合法 ")
        }
        return arrayListOf<String>().apply {
            for (i in 1..upper) {
                val second = i.plus(100)
                val sqrt1 = sqrt(second.toDouble()).toInt()
                if (sqrt1.times(sqrt1) != second) {
                    continue
                }
                val third = second.plus(168)
                val sqrt2 = sqrt(third.toDouble()).toInt()
                if (sqrt2.times(sqrt2) != third) {
                    continue
                }
                // 存储这个数
                val show =
                    ("$i" +
                            "与100的和：$second 是完全平方数，平方根为：$sqrt1, " +
                            "再与168的和：$third 同样是完全平方数，平方根为：$sqrt2")
                add(show)
            }
        }
    }
}

fun main() {
    val multipleNumbers = PerfectSquare().multipleNumber(1000000)
    multipleNumbers.forEach {
        println(it)
    }

}