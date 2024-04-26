package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：海滩上有一堆桃子，五只猴子来分。
 * 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，
 * 拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子
 * @author DawnStar
 * @since : 2024/4/20
 */
class MonkeyDividingPeach {
    fun totalPeach(number: Int): Int {
        if (number < 1) {
            throw IllegalArgumentException("非法参数")
        }
        return recurve(number, 5)
    }

    private fun recurve(remaining: Int, number: Int): Int {
        if (number == 1) {
            return remaining.times(5)+1
        }
        return recurve(remaining, number - 1).times(5)+1

    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("最后一只猴子拿走的桃子数量：")
    val number = scanner.nextInt()
    println("桃子总数为：${MonkeyDividingPeach().totalPeach(number)}")

}
