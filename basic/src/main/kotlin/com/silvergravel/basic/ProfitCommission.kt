package com.silvergravel.basic

import java.util.*

/**
 * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
 * 20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，
 * 高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
 * @author DawnStar
 * @since : 2024/4/22
 */
class ProfitCommission {
    fun calcCommission(profit: Int): Double {
        var range = profit * 1.0
        var commission = 0.0
        val base = 1
        if (range > base * 100) {
            range.minus(base * 100).also {
                commission += it.times(0.01)
                range = range.minus(it)
            }
        }

        if (range > base.times(60)) {
            range.minus(base.times(60)).also {
                commission += it.times(0.015)
                range = range.minus(it)
            }
        }

        if (range > base.times(40)) {
            range.minus(base * 40).also {
                commission += it.times(0.03)
                range = range.minus(it)
            }
        }

        if (range > base.times(20)) {
            range.minus(base * 20).also {
                commission += it.times(0.05)
                range = range.minus(it)
            }
        }

        if (range > base.times(10)) {
            range.minus(base * 10).also {
                commission += it.times(0.075)
                range = range.minus(it)
            }
        }


        return commission.plus(range.times(0.1))


    }

}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入利润(万元)：")
    val profit = scanner.nextInt()
    println("可获得提成：${ProfitCommission().calcCommission(profit)}万元")
}