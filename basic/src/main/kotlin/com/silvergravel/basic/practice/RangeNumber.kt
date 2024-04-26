package com.silvergravel.basic.practice

import java.util.*


/**
 * 取一个整数a从右端开始的4～7位
 * @author DawnStar
 * @since : 2024/4/18
 */
class RangeNumber {
    fun cutOff(number: Long):Int {
        val numberString = number.toString()
        if (numberString.length<7) {
            throw IllegalArgumentException("数字不能小于7位")
        }
        return numberString.substring(3, 7).toInt()
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入数字：")
    val number = scanner.nextLong()
    print("截取的4~7位数字为：${RangeNumber().cutOff(number)}")
}