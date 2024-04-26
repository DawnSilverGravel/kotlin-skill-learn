package com.silvergravel.basic.practice

import kotlin.random.Random

/**
 * 题目：对10个数进行排序
 * @author DawnStar
 * @since : 2024/4/17
 */
class NumberSort {
    fun sortByMethod(list: List<Int>): List<Int> {
        return list.sortedByDescending { it }.toList()
    }

    fun sortByBubble(list: List<Int>): List<Int> {
        val array = list.toIntArray()
        val size = array.size
        for (i in 0 until size) {
            for (j in 0 until size - i - 1) {
                if (array[j + 1] > array[j]) {
                    array[j + 1] = array[j].also {
                        array[j] = array[j + 1]
                    }
                }
            }
        }
        return array.toList()
    }
}

fun main() {
    val random = Random(3000)
    val count = random.nextInt(5, 20)
    val list = arrayListOf<Int>().apply {
        for (i in 0..count) {
            add(random.nextInt(1, 200))
        }
    }

    println("原数组：$list")
    val numberSort = NumberSort()

    println("排序后数组：${numberSort.sortByMethod(list)}")
    println("排序后数组：${numberSort.sortByBubble(list)}")
}