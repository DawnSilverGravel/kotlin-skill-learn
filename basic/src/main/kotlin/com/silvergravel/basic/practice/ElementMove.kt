package com.silvergravel.basic.practice

import com.silvergravel.basic.practice.util.ArrayUtil
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

/**
 * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 * @author DawnStar
 * @since : 2024/4/19
 */
class ElementMove {
    fun moveBySpace(array: Array<Int?>, m: Int): Array<Int?> {
        if (array.size < m) {
            throw IllegalArgumentException("非法参数")
        }
        if (array.size == m) {
            return array.copyOf()
        }

        if (array.size - 1 == m) {
            for (i in 0 until array.size - 1) {
                array[i + 1] = array[i].also {
                    array[i] = array[i + 1]
                }
            }
            return array.copyOf()
        }
        val copyOf = array.copyOf()
        val apply = arrayOfNulls<Int>(m).apply {
            for (index in 0 until m) {
                this[index] = copyOf[copyOf.size - m + index]
            }
        }

        for (i in array.size - 1 downTo m) {
            copyOf[i - m] = copyOf[i].also {
                copyOf[i] = copyOf[i - m]
            }
        }

        for (index in apply.indices) {
            copyOf[index] = apply[index]
        }
        return copyOf
    }


    fun move(array: Array<Int?>, m: Int, selectHigher: Boolean) {

        if (array.size < m) {
            throw IllegalArgumentException("非法参数")
        }
        if (array.size == m) {
            return
        }
        if (selectHigher)
            moveRecurveHigher(array, array.size, m)
        else {
            moveRecurve(array, array.size, m)
        }
    }

    /**
     * 循环移动数字
     * @param array 目标数组
     * @param currentSize 数组长度
     * @param m 移动次数
     */
    private fun moveRecurve(array: Array<Int?>, currentSize: Int, m: Int) {
        if (currentSize <= 0 || m == 0) {
            return
        }
        if (currentSize - 1 == m) {
            for (i in 0 until currentSize - 1) {
                array[i + 1] = array[i].also {
                    array[i] = array[i + 1]
                }
            }
            return
        }
        for (i in currentSize - 1 downTo 1) {
            array[i - 1] = array[i].also {
                array[i] = array[i - 1]
            }
        }
        moveRecurve(array, currentSize, m - 1)
    }

    private fun moveRecurveHigher(array: Array<Int?>, currentSize: Int, m: Int) {
        if (currentSize <= 0 || m <= 0) {
            return
        }
        // 这里避免 rem=1
        if (currentSize - 1 == m) {
            for (i in 0 until currentSize - 1) {
                array[i + 1] = array[i].also {
                    array[i] = array[i + 1]
                }
            }
            return
        }

        // 第二种方式先一次性排好除m个数的其他数字
        for (i in currentSize - 1 downTo m) {
            array[i - m] = array[i].also {
                array[i] = array[i - m]
            }
        }
//        array.forEach { print("$it ") }
//        println()
        // 弊端：如果rem=1，那么栈深度会非常之高，1万数量级就会出现问题
        val rem = currentSize.rem(m)
        if (rem == 0) {
            return
        }

        val nextRem = if (rem > m)
            rem
        else
            m - rem

        moveRecurveHigher(array, m, nextRem)
    }


}

fun main() {
    // 注意：递归的栈深度不能过高，默认栈大小为1024MB，1万量级基本出现问题
    val sourceArray = ArrayUtil.generateArrayNumber(100 * 200)
    sourceArray.forEach { print("$it ") }
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)

    print("\n数组总长：${sourceArray.size} 输入需要数组移动个数：")
    val number = scanner.nextInt()
    val elementMove = ElementMove()
    val array1 = sourceArray.copyOf()
    val array2 = sourceArray.copyOf()

    val space = Instant.now()
    val moveBySpace = elementMove.moveBySpace(sourceArray, number)
    val spaceTimeConsuming = ChronoUnit.NANOS.between(space, Instant.now())
    println("数组型：${spaceTimeConsuming}ns")

    val higher = Instant.now()
    elementMove.move(array2, number, true)
    val highTimeConsuming = ChronoUnit.NANOS.between(higher, Instant.now())
    println("高性能：${highTimeConsuming}ns")

    val notHigher = Instant.now()
    elementMove.move(array1, number, false)
    val notHighConsuming = ChronoUnit.NANOS.between(notHigher, Instant.now())
    println("低性能：${notHighConsuming}ns")

    println("moveBySpace 与 sourceArray 顺序相同：${moveBySpace.toList() == sourceArray.toList()}")
    println("moveBySpace 与 array1 顺序相同：${moveBySpace.toList() == array1.toList()}")
    println("moveBySpace 与 array2 顺序相同：${moveBySpace.toList() == array2.toList()}")
//    for (i in moveBySpace.indices) {
//        if (i == number) {
//            break
//        }
//        print("${moveBySpace[i]} ")
//    }
//    println()
//    moveBySpace.forEach { print("$it ") }
//    println()
//    array1.forEach { print("$it ") }
//    println()
//    array2.forEach { print("$it ") }
}