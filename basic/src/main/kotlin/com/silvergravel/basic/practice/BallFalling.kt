package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：一个球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高
 * @author DawnStar
 * @since : 2024/4/11
 */
class BallFalling {
    /**
     * Calc path distance
     *
     * @param height 当前高度
     * @param frequency 落地次数
     * @return  Pair<Double,Double>
     */
    fun calcPathDistance(height: Int, frequency: Int): Pair<Double, Double> {
        if (height <= 0 || frequency <= 0) {
            throw IllegalArgumentException("高度和落地次数都必须为正整数！")
        }
        val fold = 0.5
        var currentHeight = height.toDouble()
        var pathDistance = 0.0
        for (i in 1..frequency) {
            currentHeight *= fold
            pathDistance += currentHeight.times(3)
        }
        return Pair(currentHeight, pathDistance)
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入高度：")
    val height = scanner.nextInt()
    print("数入次数：")
    val frequency = scanner.nextInt()
    val (currentHeight, distance) = BallFalling().calcPathDistance(height, frequency)
    print(
        "经过第 $frequency 落地弹起，" +
                "小球一共经过 $distance 米（包括反弹高度），" +
                "第 $frequency 次反弹高度为：$currentHeight 米"
    )

}