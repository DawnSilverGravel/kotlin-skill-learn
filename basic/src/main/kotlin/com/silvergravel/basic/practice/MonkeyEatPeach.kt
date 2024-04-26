package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 * @author DawnStar
 * @since : 2024/4/14
 */
class MonkeyEatPeach {
    fun calcTotalPeach(day: Int): Int {
        var total = 1
        for (i in 1 until day) {
            total = total.plus(1).times(2)
        }
        return total
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入只剩一个桃子的天数：")
    val day = scanner.nextInt()
    println("第一天的桃子总数为：${MonkeyEatPeach().calcTotalPeach(day)}")

}