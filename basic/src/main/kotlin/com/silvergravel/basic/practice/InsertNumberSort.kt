package com.silvergravel.basic.practice

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中
 * @author DawnStar
 * @since : 2024/4/18
 */
class InsertNumberSort {
    fun insertNumberAndReturnArray(sourceArray: Array<Int?>, number: Int): Array<Int?> {
        val newLength = sourceArray.size + 1
        val targetArray = sourceArray.copyOf(newLength)

        val binarySearch = binarySearch(sourceArray, number)

        for (i in newLength - 1 downTo binarySearch + 1) {
            targetArray[i] = targetArray[i - 1]
        }
        targetArray[binarySearch] = number


        return targetArray
    }

    private fun binarySearch(array: Array<Int?>, number: Int): Int {
        var left = 0
        var right = array.size - 1
        // 如果是最右边的数小于这个数，直接填充最后一位返回
        if (array[array.size - 1]!! < number) {
            return array.size
        }
        while (left != right) {
            val mid = left + (right - left) / 2
            if (array[mid]!! < number && array[mid + 1]!! >= number) {
                return mid + 1
            }
            if (array[mid]!! < number) {
                left = mid
                continue
            }
            right = mid
        }
        return 0
    }
}

fun main() {
    val current = ThreadLocalRandom.current()
    val num = current.nextInt(8, 20)
    val sourceArray = arrayOfNulls<Int>(num).apply {
        for (i in 0 until num) {
            this[i] = current.nextInt(20, 300)
        }
    }
    sourceArray.sort()
    sourceArray.forEach { print("$it ") }
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("\n输入整数：")
    val number = scanner.nextInt()
    val array = InsertNumberSort().insertNumberAndReturnArray(sourceArray, number)
    array.forEach { print("$it ") }

}