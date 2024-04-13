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

---

> 7.题目：输入两个正整数m和n，求其最大公约数和最小公倍数<br/>
> 题解：利用辗除法 [欧几里得算法](https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675)<br/>
> [CommonDivisorMultiple](./src/main/kotlin/com/silvergravel/basic/CommonDivisorMultiple.kt)

---

> 8.输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数<br/>
> 题解：使用正则表达式<br/>
> [StatisticalCharacters](./src/main/kotlin/com/silvergravel/basic/StatisticalCharacters.kt)

---

> 9.题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
> 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。<br/>
> 题解：循环计算每一项的值<br/>
> [SameNumberItem](./src/main/kotlin/com/silvergravel/basic/SameNumberItem.kt)

---

> 10.题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。
> 例如6=1＋2＋3.编程找出1000以内的所有完数<br/>
> 题解：平方这个数得到平方根，然后从2循环至平方根 得到两个因子，最后汇总相加<br/>
> [PerfectNumber](./src/main/kotlin/com/silvergravel/basic/PerfectNumber.kt)

---

> 11.题目：一个球从一定高度自由落下，每次落地后反跳回原高度的一半；
> 再落下，求它在 第N次落地时，共经过多少米？第N次反弹多高<br/>
> 题解：每一次落地弹起都是该高度的3/2<br/>
> [BallFalling](./src/main/kotlin/com/silvergravel/basic/BallFalling.kt)

---

> 12.题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
> 题解：三层循环，相同的数字跳过当前循环<br>
> [DifferentNotRepeatNumber](./src/main/kotlin/com/silvergravel/basic/DifferentNotRepeatNumber.kt)

---

> 13.题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？</br>
题解：指定上界，在上界内判断这个数<br/>
> [PerfectSquare](./src/main/kotlin/com/silvergravel/basic/PerfectSquare.kt)

---

> 14.题目：输入某年某月某日，判断这一天是这一年的第几天？<br/>
> 题解：处理闰年多一天的情况，创建一个每月的天数数组<br/>
> [DetermineNumberDay](./src/main/kotlin/com/silvergravel/basic/DetermineNumberDay.kt)

---
 
> 15.题目：输入三个整数x,y,z，请把这三个数由小到大输出<br/>
> 题解：使用also两两交换变量<br/>
> [ThreeNumberSort](./src/main/kotlin/com/silvergravel/basic/ThreeNumberSort.kt)

---

