package com.silvergravel.basic

import java.util.*

/**
 * 题目：计算字符串中子串出现的次数
 * @author DawnStar
 * @since : 2024/4/22
 */
class SubstringCount {
    fun count(text: String): Int {
        return text.trim().count { it == ' ' }.plus(1)
    }

}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入分子的值：")
    val text = scanner.nextLine()
    println("一共有：${SubstringCount().count(text)}个子串")
}