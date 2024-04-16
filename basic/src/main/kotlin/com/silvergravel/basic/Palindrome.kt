package com.silvergravel.basic

import java.util.*

/**
 *题目：一个5位数，判断它是不是回文数。即12321是回文数，
 * @author DawnStar
 * @since : 2024/4/16
 */
class Palindrome {
    fun judgePalindromeByMethod(num: Int): Boolean {
        check(num)
        num.toString().let {
            return it == it.reversed()
        }
    }


    fun judgePalindrome(num: Int): Boolean {
        check(num)
        val numString = num.toString()
        for (i in 0 until numString.length / 2) {
            if (numString[i] != numString[numString.length-i-1]) {
                return false
            }
        }
        return true

    }

    private fun check(num: Int) {
        if (num < 100) {
            throw IllegalArgumentException("请输入不小于100的数")
        }
    }

}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入正整数：")
    val num = scanner.nextInt()
    println("$num 是回文数： ${Palindrome().judgePalindrome(num)}")
    println("$num 是回文数： ${Palindrome().judgePalindromeByMethod(num)}")

}