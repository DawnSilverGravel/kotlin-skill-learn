package com.silvergravel.basic

import java.util.Scanner

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 * 问每个月的兔子对数为多少
 * @author DawnStar
 * @since : 2024/4/8
 */
class RabbitReproduction {
    /**
     * 计算繁衍数量
     *
     * @param month
     * @return 返回数量
     */
    fun calc(month: Int): Int {
        if (month < 0) {
            return 0
        }
        if (month == 1 || month == 2) {
            return 1
        }
        return calc(month - 1) + calc(month - 2)
    }


}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入月份：")
    val month = scanner.nextInt()
    val rabbitReproduction = RabbitReproduction()
    println("第${month}月一共有：${rabbitReproduction.calc(month)} 对兔子")

}