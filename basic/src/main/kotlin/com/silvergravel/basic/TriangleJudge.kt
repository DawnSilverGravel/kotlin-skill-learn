package com.silvergravel.basic

import java.util.*

/**
 * 判断三角形
 * @author DawnStar
 * @since : 2024/4/23
 */
class TriangleJudge {
    fun isTriangle(first: Int, second: Int, third: Int): Boolean {
        if (first <= 0 || second <= 0 || third <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        return when {
            first.plus(second) <= third -> false
            first.plus(third) <= second -> false
            second.plus(third) <= first -> false
            else -> true
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入第一条边长：")
    val first = scanner.nextInt()
    print("输入第二条边长：")
    val second = scanner.nextInt()
    print("输入第三条边长：")
    val third = scanner.nextInt()

    println("边长为：${first},${second},${third}构成的图形是否为三角形：" +
            "${TriangleJudge().isTriangle(first,second,third)}")
}