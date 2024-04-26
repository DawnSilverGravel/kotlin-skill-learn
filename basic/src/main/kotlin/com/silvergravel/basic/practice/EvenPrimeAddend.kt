package com.silvergravel.basic.practice

import java.util.*

/**
 * 题目：一个偶数总能表示为两个素数之和
 * @author DawnStar
 * @since : 2024/4/21
 */
class EvenPrimeAddend {
    private val primeNumber = PrimeNumber()
    fun twoPrimeFist(number: Int): Triple<Boolean, Int?, Int?> {
        if (number <= 0 || number.rem(2) != 0) {
            throw IllegalArgumentException("非法参数")
        }
        for (left in 2..number / 2) {
            val right = number.minus(left)
            val primeLeft = primeNumber.isPrime(left)
            val primeRight = primeNumber.isPrime(right)
            if (primeLeft && primeRight) {
                return Triple(true, left, right)
            }
        }
        return Triple(false, null, null)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入偶数：")
    val number = scanner.nextInt()
    val (b, addend1, addend2) = EvenPrimeAddend().twoPrimeFist(number)
    if (b) {
        println("$number 能表示为两个素数之和：$number = $addend1 + $addend2")
        return
    }
    println("$number 不能表示为两个素数之和")
}