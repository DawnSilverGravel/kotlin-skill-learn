package com.silvergravel.basic.practice

import java.util.*

/**
 * 打印出如下图案（菱形）
 * @author DawnStar
 * @since : 2024/4/14
 */
class Diamond {
    fun printDiamondPattern(n: Int) {
        val builder = StringBuilder()
        for (i in 1..n) {
            builder.append(generate(n, i))
        }
        for (i in n.minus(1) downTo 1) {
            builder.append(generate(n, i))

        }
        println(builder)
    }

    private fun generate(repeat: Int, i: Int): String {
        val builder = StringBuilder()
        return builder.append(" ".repeat(repeat.minus(i)))
            .append("*".repeat(i.minus(1).times(2) + 1))
            .append("\n").toString()
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入菱形中间行数：")
    val num = scanner.nextInt()
    Diamond().printDiamondPattern(num)
}