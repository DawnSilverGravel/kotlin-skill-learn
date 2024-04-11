package com.silvergravel.basic

/**
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * @author DawnStar
 * @since : 2024/4/11
 */
class DifferentNotRepeatNumber {
    fun printCompose() {
        val mutableList = mutableListOf<String>()
        for (i in 1..4) {
            for (j in 1..4) {
                if (i == j) {
                    continue
                }
                for (k in 1..4) {
                    if (i == k || j == k) {
                        continue
                    }
                    mutableList.add("$i$j$k")
                }
            }
        }
        println("符合条件一共：${mutableList.size} 个")
        println(mutableList.toString())
    }
}

fun main() {
    DifferentNotRepeatNumber().printCompose()
}