package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母
 * @author DawnStar
 * @since : 2024/4/17
 */
class WeekJudge {
    fun judgeWeek(prefixWord: String): WeeKEnum {
        for (value in WeeKEnum.values()) {
            if (value.name.startsWith(prefixWord.uppercase())) {
                return value
            }
        }
        throw IllegalArgumentException("非法参数")
    }
}

// 必须加`val`才可以访问
enum class WeeKEnum(val description: String) {

    MONDAY("周一"),
    TUESDAY("周二"),
    WEDNESDAY("周三"),
    THURSDAY("周四"),
    FRIDAY("周五"),
    SATURDAY("周六"),
    SUNDAY("周日");

}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入星期字母前缀，(顺序匹配)：")
    val dayOfWeek = scanner.nextLine()
    val judgeWeek = WeekJudge().judgeWeek(dayOfWeek)
    println(judgeWeek.description)
}

