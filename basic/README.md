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
>
题解：利用辗除法 [欧几里得算法](https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675)<br/>
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
> 题解：指定上界，在上界内判断这个数<br/>
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

> 16.题目：输出乘法口诀<br/>
> 题解：使用双层for循环<br/>
> [MultiplicationMnemonic](./src/main/kotlin/com/silvergravel/basic/MultiplicationMnemonic.kt)

---

> 17.题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
> 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
> 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。<br/>
> 题解：使用逆向思维，从第10天开始<br/>
> [MonkeyEatPeach](./src/main/kotlin/com/silvergravel/basic/MonkeyEatPeach.kt)

---

> 18.题目：打印出如下图案（菱形）<br/>
> `*`<br/>
`***`<br/>
`******`<br/>
`********`<br/>
`******`<br/>
`***`<br/>
`*`<br/>
> 题解：上半部分使用顺序for循环，下半部分使用逆循环<br/>
> [Diamond](./src/main/kotlin/com/silvergravel/basic/Diamond.kt)
 
---

> 19.题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和<br/>
> 题解：下一个分子为上个分子与分母之和，下个分母为上个分子的值<br/>
> [FractionSum](./src/main/kotlin/com/silvergravel/basic/FractionSum.kt)

---

> 20.题目：求1+2!+3!+...+20!的和<br/>
> 题解：分别求出每个数的阶乘再求和<br/>
[FactorialSum](./src/main/kotlin/com/silvergravel/basic/FactorialSum.kt)

---

> 21.题目：利用递归方法求5!<br/>
> 题解：构建递归方法求和<br/>
[FactorialRecursive](./src/main/kotlin/com/silvergravel/basic/FactorialRecursive.kt)
 
---

> 22.题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
> 问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。
> 问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。
> 请问第五个人多大<br/>
> 题解：使用递归法或直接乘法<br/>
> [AgeCalc](./src/main/kotlin/com/silvergravel/basic/AgeCalc.kt)

---

> 23.题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字<br/>
> 题解：可以使用字符串判断长度然后逆序打印字符<br/>
> [DigitJudge](./src/main/kotlin/com/silvergravel/basic/DigitJudge.kt)

---

> 24.题目：一个5位数，判断它是不是回文数。即12321是回文数，
> 个位与万位相同，十位和千位相同<br/>
> 题解：使用字符串翻转判断是否一致<br/>
> [PerfectNumber](./src/main/kotlin/com/silvergravel/basic/PerfectNumber.kt)

--- 

> 25.题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母<br/>
> 题解：直接使用字符串来匹配<br/>
> [WeekJudge](./src/main/kotlin/com/silvergravel/basic/WeekJudge.kt)

---

> 26.题目：对10个数进行排序<br/>
> 题解：快排、冒泡、选择等算法均可<br/>
> [NumberSort](./src/main/kotlin/com/silvergravel/basic/NumberSort.kt)

---

> 27.题目：求一个3*3矩阵对角线元素之和<br/>
> 题解：构建一个二维数组，取出array[i][i]和array[i][n-i]<br/>
> [MatrixDiagonal](./src/main/kotlin/com/silvergravel/basic/MatrixDiagonal.kt)

---

> 28.题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中<br/>
> 题解：首先判断是否与边界比较，再从中间比较<br/>
> [InsertNumberSort](./src/main/kotlin/com/silvergravel/basic/InsertNumberSort.kt)

---

> 29.取一个整数a从右端开始的4～7位<br/>
> 题解：使用字符串截出4-7位的数字<br/>
> [RangeNumber](./src/main/kotlin/com/silvergravel/basic/RangeNumber.kt)

---

> 30.题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组<br/>
> 题解：找到最大元素最小元素的下标，然后切换<br/>
> [MaxMinElementChange](./src/main/kotlin/com/silvergravel/basic/MaxMinElementChange.kt)

---

> 31.题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数<br/>
> 题解：数组、集合等方法可以使用，方案可以有：1.空间换时间；2.原有的数据结构进行操作<br/>
> [ElementMove](./src/main/kotlin/com/silvergravel/basic/ElementMove.kt)

---

> 32.题目：编写一个函数，
> 输入n为偶数时，调用函数求1/2+1/4+...+1/n,
> 当输入n为奇数时，调用函数1/1+1/3+...+1/n<br/>
> 题解：设置for循环起始参数即可 2-num%2<br/>
> [OddEvenMethod](./src/main/kotlin/com/silvergravel/basic/OddEvenMethod.kt)

---

> 33.题目：有n个人围成一圈，顺序排号。
> 从第一个人开始报数（从1到3报数），
> 凡报到3的人退出圈子，问最后留下的是原来第几号的那位<br/>
> 题解：一个顺序数组，退出圈子的设置为null，总数为1退出循环<br/>
> [CountOut](./src/main/kotlin/com/silvergravel/basic/CountOut.kt)

---

> 34.题目：海滩上有一堆桃子，五只猴子来分。
> 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
> 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，
> 拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子<br/>
> 题解：五只猴子，取完之后剩下4n份，(4n+n+1)*5 = 第四只猴子的4n份<br/>
> [MonkeyDividingPeach](./src/main/kotlin/com/silvergravel/basic/MonkeyDividingPeach.kt)

---

> 35.题目：求0—7所能组成的奇数个数<br/>
题解： 1,3,5,7为尾数的则为奇数，<br/>
> [OddCounter](./src/main/kotlin/com/silvergravel/basic/OddCounter.kt)

---

> 36.题目：一个偶数总能表示为两个素数之和<br/>
> 题解：输入偶数，判断两个加数是不是都为素数，2不可以
> [EvenPrimeAddend](./src/main/kotlin/com/silvergravel/basic/EvenPrimeAddend.kt)


---

> 37.题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的`＊`<br/>
> 题解：使用String#repeat方法<br/>
> [AsteriskPrint](./src/main/kotlin/com/silvergravel/basic/AsteriskPrint.kt)

---

> 38.题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
> 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
> 再将第一位和第四位交换，第二位和第三位交换<br/>

--- 

> 39.题目：计算字符串中子串出现的次数<br/>

---

> 40.题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
> 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，
> 高于10万元的部分，可可提成7.5%；20万到40万之间时，
> 高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；
> 60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，
> 超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数<br/>

---

> 41.题目：要求输出国际象棋棋盘。<br/>


> 42.判断三角形<br/>