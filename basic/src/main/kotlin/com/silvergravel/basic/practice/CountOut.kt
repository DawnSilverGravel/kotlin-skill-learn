package com.silvergravel.basic.practice

import com.silvergravel.basic.practice.util.ArrayUtil
import java.util.*

/**
 * 33.题目：有n个人围成一圈，顺序排号。
 * 从第一个人开始报数（从1到3报数），
 * 凡报到3的人退出圈子，问最后留下的是原来第几号的那位
 * @author DawnStar
 * @since : 2024/4/20
 */
class CountOut {
    fun survivor(array: Array<Int?>, outNumber: Int): Pair<Int, List<Int>> {
        var currentNumbers = array.size
        var counter = 0
        val arrayListOf = arrayListOf<Int>()

        while (currentNumbers > 1) {
            for (index in array.indices) {
                if (currentNumbers == 1) {
                    break
                }
                if (array[index] == null) {
                    continue
                }
                counter++
                if (counter == outNumber) {
                    array[index]?.let { arrayListOf.add(it) }
                    array[index] = null
                    currentNumbers--
                    counter = 0
                }
            }
        }
        val filter = array.filterNotNull().first()
        return Pair(filter, arrayListOf)
    }
}

fun main() {

    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("人数：")
    val members = scanner.nextInt()
    val natureSorts = ArrayUtil.generateArrayNatureSort(members)
    print("出局数：")
    val outNumber = scanner.nextInt()
    natureSorts.forEach { print("$it ") }
    println()
    val (survivor, outMember) = CountOut().survivor(natureSorts, outNumber)
    println("幸存者为：$survivor, 出局者顺序为：${outMember.joinToString(",")}")
}