package com.silvergravel.basic

import java.util.*

/**
 * 题目：输入乘法口诀
 * @author DawnStar
 * @since : 2024/4/14
 */
class MultiplicationMnemonic {
    fun printMultiplicationMnemonic() {
        for (i in 1..9) {
            for (j in 1..i) {
                print("$j * $i = ${j.times(i)}\t")
            }
            println()
        }
    }
}

fun main() {
    MultiplicationMnemonic().printMultiplicationMnemonic()

}