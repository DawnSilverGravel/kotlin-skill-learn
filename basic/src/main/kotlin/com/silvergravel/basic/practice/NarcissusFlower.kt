package com.silvergravel.basic.practice

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
 * <br>如 153 = 1^3+5^3+3^3
 *
 * @author DawnStar
 * @since : 2024/4/9
 */
class NarcissusFlower {
    private fun isNarcissusFlower(number: Int): Boolean {
        if (number < 100 || number > 999) {
            return false
        }
        val unit = number.rem(100).rem(10)
        val decade = number.rem(100).div(10)
        val hundred: Int = number.div(100)
        val target = unit.times(unit).times(unit) +
                decade.times(decade).times(decade) +
                hundred.times(hundred).times(hundred)

        return target == number

    }

    fun getNarcissusFlowerList(sourceList: List<Int>): List<Int> {
        return sourceList.filter { isNarcissusFlower(it) }
            .toList()
    }
}

fun main() {
    val arrayList = arrayListOf<Int>().apply {
        for (i in 100..999) {
            add(i)
        }
    }
    val narcissusFlowerList = NarcissusFlower().getNarcissusFlowerList(arrayList)
    println(narcissusFlowerList.toString())

}