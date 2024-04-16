package com.silvergravel.basic

import java.util.*

/**
 * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
 * 问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。
 * 问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。
 * @author DawnStar
 * @since : 2024/4/16
 */
class AgeCalc {
    fun calcAge(count: Int, interval: Int, minAge: Int): Int {
        if (count <= 0 || interval <= 0 || minAge < 1) {
            throw IllegalArgumentException("参数不合法")
        }
        return count.minus(1).times(interval).plus(minAge)
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入人的数量：")
    val count = scanner.nextInt()
    print("输入岁数间隔：")
    val interval = scanner.nextInt()
    print("输入最小岁数：")
    val minAge = scanner.nextInt()
    print("第${count}个人的岁数为：${AgeCalc().calcAge(count, interval, minAge)}岁")


}