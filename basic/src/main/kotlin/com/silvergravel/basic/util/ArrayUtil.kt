package com.silvergravel.basic.util

import java.util.concurrent.ThreadLocalRandom

/**
 *
 * @author DawnStar
 * @since : 2024/4/19
 */
object ArrayUtil {
    private val current: ThreadLocalRandom = ThreadLocalRandom.current()

    fun generateArray(): Array<Int?> {
        val num = current.nextInt(8, 20)
        return generateArrayNumber(num)
    }

    fun generateArrayNumber(number: Int): Array<Int?> {
        if (number <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        val sourceArray = arrayOfNulls<Int>(number).apply {
            for (i in 0 until number) {
                this[i] = current.nextInt(20, 300)
            }
        }
        return sourceArray
    }

    fun generateArrayNatureSort(number: Int): Array<Int?> {
        if (number <= 0) {
            throw IllegalArgumentException("非法参数")
        }
        return arrayOfNulls<Int>(number).apply {
            for (i in 0 until number) {
                this[i] = i+1
            }
        }
    }

}