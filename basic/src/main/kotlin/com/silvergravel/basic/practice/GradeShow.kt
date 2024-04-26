package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示<br>
 * @author DawnStar
 * @since : 2024/4/9
 */
class GradeShow {
    fun show(score: Int) {
        when (score) {
            in 90..100 -> print("$score is A")
            in 60..89 -> print("$score is B")
            in 0..69 -> print("$score is C")
            else -> print("what are you doing baby")
        }
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入分数：")
    val score = scanner.nextInt()
    GradeShow().show(score)
}