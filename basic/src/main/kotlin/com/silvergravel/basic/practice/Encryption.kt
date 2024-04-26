package com.silvergravel.basic.practice

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
        if (number < 1000 || builder.length.rem(4) != 0) {
            throw IllegalArgumentException("只支持4位数的倍数加密")
        }

        val apply = arrayOfNulls<Long>(builder.length).apply {
            for (index in builder.indices) {
                this[index] = builder[index].code.minus('0'.code.toLong()).plus(5).rem(10)
                changeValue(this, index)
            }
        }


        return apply.joinToString("").toLong()
    }

    fun decrypt(number: Long): Long {
        val builder = number.toString()
        if (number < 1000 || builder.length.rem(4) != 0) {
            throw IllegalArgumentException("只支持4位数的倍数解密")
        }
        val apply = arrayOfNulls<Long>(builder.length).apply {
            for (index in builder.indices) {
                this[index] = builder[index].code.minus('0'.code.toLong()).let {
                    if (it > 4) {
                        it.minus(5)
                    } else {
                        it.plus(10).minus(5)
                    }
                }
                changeValue(this, index)
            }
        }
        return apply.joinToString("").toLong()
    }

    private fun changeValue(array: Array<Long?>, index: Int) {
        if (index != 0 && index.plus(1).rem(4) == 0) {
            array[index - 3] = array[index].also {
                array[index] = array[index - 3]
            }
            array[index - 2] = array[index - 1].also {
                array[index - 1] = array[index - 2]
            }
        }
    }


}

fun main() {
    val scanner = Scanner(System.`in`)
    print("输入4位数字：")
    val number = scanner.nextLong()
    val encryption = Encryption()
    val encrypt = encryption.encrypt(number)
    println("加密后的数字为：${encrypt}")
    println("解密后的数字为：${encryption.decrypt(encrypt)}")
}