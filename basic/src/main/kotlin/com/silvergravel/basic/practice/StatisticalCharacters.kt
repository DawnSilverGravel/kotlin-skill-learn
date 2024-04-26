package com.silvergravel.basic.practice

import java.util.*

/**
 * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数<br/>
 * @author DawnStar
 * @since : 2024/4/10
 */
class StatisticalCharacter {
    private val chineseRegex = Regex("[\u4e00-\u9fa5]")
    private val englishRegex = Regex("[A-z]")

    private val numberRegex = Regex("\\d")
    private val spaceRegex = Regex("\\s")

    fun handleText(text: String) {
        var chineseChars = 0
        var englishChars = 0
        var numberChars = 0
        var spaceChars = 0
        var otherChars = 0
        for (c in text) {
            val character = c.toString()
            if (character.matches(chineseRegex)) {
                chineseChars++
                continue
            }
            if (character.matches(englishRegex)) {
                englishChars++
                continue
            }
            if (character.matches(numberRegex)) {
                numberChars++
                continue
            }
            if (character.matches(spaceRegex)) {
                spaceChars++
                continue
            }
            otherChars++
        }
        print("该段文字中文字符：$chineseChars 个，英文字符：$englishChars 个，数字字符：$numberChars 个，空格字符：$spaceChars 个，其他字符：$otherChars 个")
    }
}

fun main() {
    // in 是 kotlin中的硬关键字
    val scanner = Scanner(System.`in`)
    print("输入一行字符串：")
    val text = scanner.nextLine()
    StatisticalCharacter().handleText(text)

}