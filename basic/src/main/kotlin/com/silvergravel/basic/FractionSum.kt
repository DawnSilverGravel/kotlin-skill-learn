package com.silvergravel.basic

import java.lang.StringBuilder
import java.util.*

/**
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
 * @author DawnStar
 * @since : 2024/4/15
 */
class FractionSum {
    fun itemSum(numerator: Int, items: Int): Pair<Double, String> {
        if (numerator <= 0 || items <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        var numeratorValue = numerator
        var sum = 0.0
        var denominator = 1.0
        val builder = StringBuilder()
        for (i in 0..items) {
            sum += numeratorValue.div(denominator)
            builder.append("${numeratorValue}/${denominator.toInt()}")
            if (i != items) {
                builder.append(" + ")
            }
            denominator = numeratorValue.also {
                numeratorValue += denominator.toInt()
            }.toDouble()
        }

        return Pair(sum, builder.toString())
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入分子的值：")
    val numerator = scanner.nextInt()
    print("输入项数：")
    val items = scanner.nextInt()
    val (itemSum, itemString) = FractionSum().itemSum(numerator, items)
    println("$itemString = $itemSum")
}