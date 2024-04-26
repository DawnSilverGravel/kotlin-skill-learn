package com.silvergravel.basic.practice

/**
 * 题目：要求输出国际象棋棋盘
 * @author DawnStar
 * @since : 2024/4/23
 */
class Chess {
    fun print() {
        val repeat = "-".repeat(5.times(10).minus(1))
        println(repeat)
        for (i in 1..8) {
            print("|")
            for (j in 1..8) {
                val s = if (j.plus(i).rem(2) == 0) " " else "#"
                print(s.repeat(5) + "|")
            }
            println("\n"+repeat)
        }

    }
}

fun main() {
    Chess().print()
}