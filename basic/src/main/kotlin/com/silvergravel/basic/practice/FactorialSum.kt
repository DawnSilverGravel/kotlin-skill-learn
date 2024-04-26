package com.silvergravel.basic.practice

import java.lang.StringBuilder
import java.util.*

/**
 * 题目：求1+2!+3!+...+20!的和
 * @author DawnStar
 * @since : 2024/4/15
 */
class FactorialSum {
    fun factorialSum(item: Int): Pair<Int, String> {
        if (item <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        var sum = 0
        val builder = StringBuilder()
        for (i in 1..item) {
            var value = 1
            builder.append(i).append("!")
            if (i != item) {
                builder.append(" + ")
            }
            for (j in 1..i) {
                value = value.times(j)
            }
            sum += value
        }
        return Pair(sum, builder.toString())
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入项数：")
    val item = scanner.nextInt()
    val (sum, itemString) = FactorialSum().factorialSum(item)
    println("$itemString = $sum")
}