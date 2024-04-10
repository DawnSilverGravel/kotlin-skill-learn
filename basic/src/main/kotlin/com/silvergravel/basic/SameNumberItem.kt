package com.silvergravel.basic

import java.util.*

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * @author DawnStar
 * @since : 2024/4/10
 */
class SameNumberItem {
    fun calcSum(number: Int, item: Int): Pair<String, Int> {
        if (item <= 0) {
            throw IllegalArgumentException("项数不能0或着负数")
        }
        if (number !in 1..9) {
            throw IllegalArgumentException("不支持1-9之外的数字")
        }
        var sum = 0
        var subItemVale = 0
        val mutableListOf = mutableListOf<String>()
        for (subItem in 0 until item) {
            subItemVale = subItemVale.times(10) + number
            mutableListOf.add(subItemVale.toString())
            sum += subItemVale
        }
        val text = mutableListOf.joinToString("+")
        return Pair(text, sum)
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入数字：")
    val number = scanner.nextInt()
    print("输入项数：")
    val item = scanner.nextInt()
    val (text, calcSum) = SameNumberItem().calcSum(number, item)
    print("$text = $calcSum")
}