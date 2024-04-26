package com.silvergravel.basic.practice

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * 题目：求一个3*3矩阵对角线元素之和
 * @author DawnStar
 * @since : 2024/4/17
 */
class MatrixDiagonal {
    fun calcDiagonalSum(matrix: Array<Array<Int?>>): Int {
        var sum = 0
        for (i in matrix.indices) {
            sum += (matrix[i][i] ?: 0) + (matrix[i][matrix.size - 1 - i] ?: 0)
        }
        return sum
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入矩阵数组的大小：")
    val num = scanner.nextInt()
    val current = ThreadLocalRandom.current()
    val matrix = Array(num) {
        arrayOfNulls<Int>(num).apply {
            for (index in 0 until num) {
                set(index, current.nextInt(0, 10))
            }
        }
    }
    matrix.forEach { it ->
        it.forEach {
            print("$it\t")
        }
        println()
    }
    println("两个对角线之和为：${MatrixDiagonal().calcDiagonalSum(matrix)}")


}