package com.silvergravel.basic

import java.time.LocalDate
import java.util.*

/**
 * 题目：输入某年某月某日，判断这一天是这一年的第几天？
 * @author DawnStar
 * @since : 2024/4/13
 */
class DetermineNumberDay {
    private val monthArray = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    fun judgeDateOfYear(year: Int, month: Int, day: Int): Int {
        check(year, month, day)
        return LocalDate.of(year, month, day).dayOfYear
    }

    fun judgeDateInYear(year: Int, month: Int, day: Int): Int {
        check(year, month, day)

        var dayInYear = 0
        for (i in 0 until month) {
            dayInYear += monthArray[i]
        }
        return dayInYear + day
    }

    private fun check(year: Int, month: Int, day: Int) {
        val condition = year < 0 || month <= 0 || month > 12 || day < 0 || day > 31
        if (condition) {
            throw IllegalArgumentException("非法参数")
        }
        // 初始化为28
        monthArray[2] = 28
        if (year.rem(400) == 0 || (year.rem(4) == 0 && year.rem(100) != 0)) {
            // 该年是闰年
            monthArray[2] = 29
        }
        val days = monthArray[month]
        if (day !in 1..days) {
            throw IllegalArgumentException("非法参数")
        }

    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入年份：")
    val year = scanner.nextInt()
    print("输入月份：")
    val month = scanner.nextInt()
    print("输入天数：")
    val day = scanner.nextInt()
    val determineNumberDay = DetermineNumberDay()
    println("${year}-${month}-${day}是${year}年的第${determineNumberDay.judgeDateInYear(year, month, day)}天")
    println("${year}-${month}-${day}是${year}年的第${determineNumberDay.judgeDateOfYear(year, month, day)}天")
}