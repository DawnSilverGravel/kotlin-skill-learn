package com.silvergravel.basic.practice

import com.silvergravel.basic.practice.util.ArrayUtil


/**
 * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组
 * @author DawnStar
 * @since : 2024/4/19
 */
class MaxMinElementChange {
    fun changeMaxMinElement(sourceArray: Array<Int?>) {
        var minIndex = 0
        var maxIndex = 0
        for ((index, item) in sourceArray.withIndex()) {
            if (sourceArray[minIndex]!! < item!!) {
                minIndex = index
                continue
            }
            if (sourceArray[maxIndex]!! > item) {
                maxIndex = index
                continue
            }
        }
        sourceArray[maxIndex] = sourceArray[0].also {
            sourceArray[0] = sourceArray[maxIndex]
        }
        sourceArray[minIndex] = sourceArray[sourceArray.size - 1].also {
            sourceArray[sourceArray.size - 1] = sourceArray[minIndex]
        }
    }
}

fun main() {
    val sourceArray = ArrayUtil.generateArray()
    sourceArray.forEach { print("$it ") }
    println()
    MaxMinElementChange().changeMaxMinElement(sourceArray)
    sourceArray.forEach { print("$it ") }
}