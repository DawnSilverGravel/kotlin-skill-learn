# basic

该模块主要是一些经典的项目

## 汇总题目

> 1.题目：有一对兔子，从出生后第3个月起每个月都生一对兔子，
> 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
> 问每个月的兔子对数为多少<br/>
> 规律为：1,1,2,3,5,8,13,21...
> <br/>
> 题解：使用递归函数,从最先的第一个月和第二个月开始相加
> <br/>
> [RabbitReproduction](./src/main/kotlin/com/silvergravel/basic/RabbitReproduction.kt)

---

> 2.题目：输出输出斐波那契数列<br/>
> 题解：生成一个二维数组，下三角为斐波那契数列数据，缺点：浪费空间<br/>
> [FibonacciSequence](./src/main/kotlin/com/silvergravel/basic/FibonacciSequence.kt)

--- 

> 3.题目：判断101-200之间有多少个素数，并输出所有素数<br/>
> 题解：先平方该数，该数的平方根取下整到 2，如果能被它们其中一个整除，则为合数，否则为素数<br/>
> [PrimeNumber](./src/main/kotlin/com/silvergravel/basic/PrimeNumber.kt)

---

> 4.题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
> 如：153 = 1<sup>3</sup>+5<sup>3</sup>+3<sup>3</sup><br/>
> 题解：将数字拆分为3个数，然后分别进行3次方<br>
> [NarcissusFlower](./src/main/kotlin/com/silvergravel/basic/NarcissusFlower.kt)

---

> 5.题目：将一个正整数分解质因数。例如：输入90,打印出 90 = 2 * 3 * 3 *5<br/>
> 题解：第一步：找到最小的质数k,如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可 <br/>
> &emsp;&emsp;&emsp;第二步：如果n!=k，但n能被k整除，
> 则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步<br/>
> &emsp;&emsp;&emsp;第三步：如果n不能被k整除，则用k+1作为k的值,重复执行第一步<br>
> [PrimeNumberFactor](./src/main/kotlin/com/silvergravel/basic/PrimeNumberFactor.kt)

---

> 6.题目：利用条件运算符的嵌套来完成分数等级展示：学习成绩>=90分的同学用A表示，
> 60-89分之间的用B表示，60分以下的用C表示<br>
> 题解：使用when关键字解题<br/>
> [GradeShow](./src/main/kotlin/com/silvergravel/basic/GradeShow.kt)
