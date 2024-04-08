package com.silvergravel.basic

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.math.sqrt

/**
 * 判断素数/质数(只能被1和其自身整除)
 * @author DawnStar
 * @since : 2024/4/8
 */
class PrimeNumber {
    fun filterPrimeNumberLet(left: Int, right: Int): List<Int> {
        val list = checkAndGenerateList(left, right)
        return list.filter {
            // let 写法
            it.let {
                val sqrt = sqrt(it.toDouble()).toInt()
                var flag = false
                for (i in 2..sqrt) {
                    if (it == 2) {
                        continue
                    }
                    if (it.rem(i) == 0) {
                        flag = true
                        break
                    }
                }
                flag
            }
        }
    }


    fun filterPrimeNumberRun(left: Int, right: Int): List<Int> {
        val list = checkAndGenerateList(left, right)
        return list.filter {
            // run 写法
            it.run {
                val sqrt = sqrt(this.toDouble()).toInt()
                var flag = false
                for (i in 2..sqrt) {
                    if (this == 2) {
                        continue
                    }
                    if (this.rem(i) == 0) {
                        flag = true
                        break
                    }
                }
                flag
            }
        }
    }

    /**
     * 检查参数并生成自然数据列表
     *
     * @param left 左边界
     * @param right 右边界
     * @return
     */
    private fun checkAndGenerateList(left: Int, right: Int): List<Int> {
        if (left <= 1) {
            throw IllegalArgumentException("参数不合法,左边界应为大于1的自然数")
        }
        if (right <= 1) {
            throw IllegalArgumentException("参数不合法,右边界应为大于1的自然数")
        }
        if (right < left) {
            throw IllegalArgumentException("参数不合法，右边界应为大于1的自然数")
        }
        return mutableListOf<Int>().apply {
            for (element in left..right) {
                add(element)
            }
        }
    }
}


fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入左边界；")
    val left = scanner.nextInt()

    print("输入右边界：")
    val right = scanner.nextInt()
    val primeNumber = PrimeNumber()
    println("let写法")
    val primeNumbers = primeNumber.filterPrimeNumberLet(left, right)
    println(primeNumbers.toString())

    println("run写法")
    val primeNumbersRun = primeNumber.filterPrimeNumberRun(left, right)
    println(primeNumbersRun.toString())
}