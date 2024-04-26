package com.silvergravel.basic.practice

import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*

/**
 *
 * @author DawnStar
 * @since : 2024/4/23
 */
class StudentGrade {
    fun output(students: List<Student>) {
        val bufferedWriter = BufferedWriter(FileWriter("student.txt"))
        students.forEach {
            val builder = StringBuilder()
            val append = builder.append(it.number)
                .append(" ")
                .append(it.name)
                .append(" ")
                .append(it.grade[0])
                .append(" ")
                .append(it.grade[1])
                .append(" ")
                .append(it.grade[2])
                .append(" ")
                .append(it.avg)
                .append("\n")
            bufferedWriter.write(append.toString())
        }
        bufferedWriter.close()
    }
}

data class Student(val number: String, val name: String, val grade: Array<Int> = arrayOf(0, 0, 0), val avg: Double) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Student) return false

        if (number != other.number) return false
        if (name != other.name) return false
        if (!grade.contentEquals(other.grade)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + grade.contentHashCode()
        return result
    }

}

fun main() {
    val scanner = Scanner(System.`in`)
    val arrayListOf = arrayListOf<Student>()
    do {
        print("输入序号：")
        val number = scanner.next()
        print("输入名字：")
        val name = scanner.next()
        print("输入第一项成绩：")
        val first = scanner.nextInt()
        print("输入第二项成绩：")
        val second = scanner.nextInt()
        print("输入第三项成绩：")
        val third = scanner.nextInt()
        val student = Student(number, name, arrayOf(first, second, third),first.plus(second).plus(third).toDouble().div(3))
        arrayListOf.add(student)
    } while (arrayListOf.size <= 5)
    StudentGrade().output(arrayListOf)


}
