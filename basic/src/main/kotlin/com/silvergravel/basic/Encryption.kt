package com.silvergravel.basic

import java.util.*

/**
 * 题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
 * 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
 * 再将第一位和第四位交换，第二位和第三位交换
 * @author DawnStar
 * @since : 2024/4/22
 */
class Encryption {

    fun encrypt(number: Long): Long {
        val builder = number.toString()
        if (number < 100 || builder.length.rem(4)!=0) {
            throw IllegalArgumentException("只支持4位数的倍数加密")
        }

        val apply = arrayOfNulls<Long>(builder.length).apply {
            for (index in builder.indices) {
                this[index] = builder[index].code.minus('0'.code.toLong()).plus(5).rem(10)
                if (index != 0 && index.plus(1).rem(4) == 0) {
                    this[index - 3] = this[index].also {
                        this[index] = this[index - 3]
                    }
                    this[index - 2] = this[index - 1].also {
                        this[index - 1] = this[index - 2]
                    }
                }
            }
        }


        return apply.joinToString("").toLong()
    }


}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入4位数字：")
    val number = scanner.nextLong()
    println("解密后的数字为：${Encryption().encrypt(number)}")
}