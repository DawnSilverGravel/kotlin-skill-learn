package com.silvergravel.basic

import java.util.*

/**
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出
 * @author DawnStar
 * @since : 2024/4/13
 */
class ThreeNumberSort {
    fun sortNumberByArray(num1: Int, num2: Int, num3: Int): List<Int> {
        return arrayOf(num1, num2, num3).sorted()
    }

    fun sortNumberByTriple(num1: Int, num2: Int, num3: Int): Triple<Int, Int, Int> {
        var value1 = num1
        var value2 = num2
        var value3 = num3
        if (value1 > value2) {
            value2 = value1.also { value1 = value2 }
        }
        if (value1 > value3) {
            value3 = value1.also { value1 = value3 }
        }
        if (value2 > value3) {
            value3 = value2.also { value2 = value3 }
        }

        return Triple(value1, value2, value3)
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入第一个数：")
    val firstNumber = scanner.nextInt()
    print("输入第二个数：")
    val secondNumber = scanner.nextInt()
    print("输入第三个数：")
    val thirdNumber = scanner.nextInt()
    val sort = ThreeNumberSort()
    println(
        "${firstNumber},${secondNumber},${thirdNumber} 的排序结果为：${
            sort.sortNumberByArray(
                firstNumber,
                secondNumber,
                thirdNumber
            ).joinToString(",")
        }"
    )
    val (first, second, third) = sort.sortNumberByTriple(
        firstNumber,
        secondNumber,
        thirdNumber
    )
    println(
        "${firstNumber},${secondNumber},${thirdNumber} 的排序结果为：${first},${second},$third"
    )
}
