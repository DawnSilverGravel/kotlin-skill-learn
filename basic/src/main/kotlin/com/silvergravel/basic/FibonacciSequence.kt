package com.silvergravel.basic

import java.util.Scanner

/**
 * 输出输出斐波那契数列
 *
 * @author DawnStar
 * @since : 2024/4/8
 */
class FibonacciSequence {
    /**
     * 生成斐波那契数列
     *
     * @param rows 行数
     * @return 返回字符串
     */
    fun generateFibonacciSequence(rows: Int): String {
        if (rows < 0) {
            return ""
        }
        val arrays = Array(rows) { arrayOfNulls<Int>(rows) }
        // 当前Kotlin版本为1.8.21 没有 `0..<month`
        arrays[0][0] = 1
        arrays[1][0] = 1;arrays[1][1] = 1
        for (row in 2 until rows) {
            arrays[row][0] = 1
            arrays[row][row] = 1
            val previewRow = row - 1
            for (col in 1 until row) {
                // 如果不为空执行加法
                arrays[row][col] = arrays[previewRow][col - 1]?.let { arrays[previewRow][col]?.plus(it) }
            }
        }
        var text = ""
        for (row in 0 until rows) {
            for (index in 0..(rows - row)) {
                text += " "
            }
            for (i in 0..row) {
                text += "${arrays[row][i]} "
            }
            text += "\n"

        }
        return text
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入行数：")
    val row = scanner.nextInt()
    println("斐波那契数列如下：\n${FibonacciSequence().generateFibonacciSequence(row)}")
}

