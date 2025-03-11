# java基础

## 1、jdk、jre、jvm三者之间的关系

jdk(Java Development Kit)： Java 开发工具包， Java从源码编译，到运行所需要的工具集。

- JVM虚拟机： Java程序运行的地方
- 核心类库： Java已经写好的东西，我们可以直接用
- 开发工具： javac、 java 、jdb、jhat(内存分析工具)

jre：Java 的运行环境，是Java在虚拟机运行时i所用到的工具集 

- JVM、核心类库、运行工具

![image-20250106171145073](./assets/1-1.png)

## 2、什么是关键字

关键字就是被Java赋予了特定含义的英文单词

- 关键字的字母都是小写的
- 常用的代码编辑器，会对关键字进行特殊颜色标记、

class关键字就表示定义一个类，后面跟一个类名

## 3、数据类型

![_cgi-bin_mmwebwx-bin_webwxgetmsgimg__&MsgID=938974713479003943&skey=@crypt_ac9934e4_a509cedcfaa35a1143130bfd89dd7a4b&mmweb_appid=wx_webfilehelper](./assets/3-1.jpg)

> [!CAUTION]
>
> 声明long型变量时，必须在数据后面以小写的“l”或大写的"L"结尾
>
> 声明float浮点类型的变量，也需要加一个“F”结尾，double不需要
>
> 整数和小数取值范围的大小关系： double > float > long > int > short > byte

①变量类型分类

按数据类型分：——四类八种



![image-20250106194110785](./assets/3-2.png)

**基本数据类型：**数据值存储在自己的空间中

**引用数据类型：**数据值存储在其他空间中，自己空间中存储的是地址值。

方法传递引用数据类型的内存原理：传递的参数为引用数据类型时，传递的时地址值和，形参的改变，影响实际参数的值。

方法传递基本数据类型的内存原理：传递的参数为引用数据类型时，传递的时地址值和，形参的改变，不影响实际参数的值。

## 4、标识符

- [ ] 由26个英文字母大小写、0-9、_或$组成
- [ ] 数字不可以开头
- [ ] 不可以使用关键字和保留字，但能包含保留字和关键字
- [ ] Java中严格的区分大小写，长度无限制
- [ ] 标识符不能包含空格 

**Java名称命名规范：**

- 包名：多个单词组成时所有字母都小写——xxxyyyzzz
- 类名、接口名：多个单词组成时，所有单词首字母大写——XxxYyyZzz
- 变量名、方法名：多个单词组成时，每一个单词首字母小写，第二个单词开始首字母大写——xxxYyyZzz
- 常量名：所有字母都大写，多个单词时每个单词用下划线连接口。XXX_YYY_ZZZ

## 5、键盘录入

```
1、导包 ：import java.util.Scanner;

2、Scanner 实例化  Scanner scan = new Scanner(Sysem.in);、
  int i= scan.nextInt();
```





## 6、运算符

① 算数运算符  \+ - * / % （前)++ (后)++ (前)-- (后)--

> [!CAUTION]
>
> **代码中,如果有小数参与运算,有可能是不精确的**
>
> 不同数据类型的运算首先需要进行转换
>
>  **自动类型提升：**当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
>
> byte、short、char-->int-->long-->float-->double
>
> 

**转换规则：**隐式转换 、强制转换

**隐式转换**：

-  把一个取值范围小的数值转换成取值范围大的数据
- **byte、short、char三种类型的数据在运算的时候，都会直接先提升为int，然后再进行运算**

**强制转换：**把一个取值范围大的数值，赋值给取值范围小的变量，不允许直接赋值，需要进行强制类型转换。数据比较大，在强转的时候可能会发生错误。

<font color="red">**格式：** </font> **目标数据类型  变量名 = （目标数据类型） 被强制转换的数据**

---------------------------------------------------------------------------------------------

**取余（取模）运算%**： 结果的符号与被模数的符号相同，开发中，经常使用%来判断是否能除尽的情况。

**字符串“+”操作：** 当“+”操作出现字符串时，这个“+”是字符串的连接符，进行拼接操作。出现多个“+”操作时，从左到右逐个执行。**字符串无减操作。**

> [!WARNING]
>
> 例： 1+2+“abc”+1 + 2  = 3abc12

**字符+操作：** 当字符+字符或字符+数字时，会把字符通过ASCII码表查询对应的数字再进行计算。

**自++运算：**

（前）++   ：先自增1，然后再运算。

（后）++：先运算，后自增1.

自增1不会改变本身的数据类型。

（前）--：先自减1，后运算。

（后）--：先运算，后自减1.

**赋值运算：**

![6-1](./assets/6-1.jpg)

**关系运算符/比较运算符：**

![6-2](./assets/6-2.jpg)

**逻辑运算符：**

![6-3](./assets/6-3.jpg)

**短路运算符：**

![6-4](./assets/6-4.jpg)

**逻辑运算符与短路运算符之间的区别：**

- 区分& 与 &&：

  相同点：运算结果相同，当符号左边是true时，二者都会执行符号右边的运算

​       不同点：当符号左边时false时，&会继续执行符号右边的运算，&&不再执行符号右边的运算。

- 区分| 与||：

  相同点：二者的运算结果还是相同的，当符号左边都是false时，二者都会执行符号右边的计算

​       不同点：当符号左边时true时，|会继续执行符号右边的运算，而||不会继续执行符号右边的运算。

![6-5](./assets/6-5.jpg)

**三元运算符：**

<font  color="red">**结构：**</font>（条件表达式）？表达式1：表达式2

1. 说明：

​       ①条件表达式的结果都为布尔类型

​       ②根据条件表达式真假，决定执行表达式1，还是表达式2，如果表达式为true，则执行表达式1，若表达式为false，则执行表达式2.

​       ③表达式1和表达式2要求是一致的。

凡是可以使用三元运算符，都可以使用if-else

如果程序既可以使用三元运算符，又可以使用if-else，则优选使用三元运算符，原因是简洁效率高。

**其他运算符：**

![6-6](./assets/6-6.jpg)

## 7、原码、补码、反码

**原码：**十进制的二进制的表现形式，最左边的是符号位，0为正，1为负。

原码弊端：利用原码进行计算时，正数完全没有问题，反如果是负数，结果就会出错，实际的运算方向与正确的运算方向是相反的。

**反码：**为了解决原码不能出现负数的问题而出现的。

反码弊端：负数运算的时候，如果结果不跨0，那么计算结果没有问题，如果结果跨0，那么跟实际的结果会有1的误差。

**反码计算规则：**正数的反码不变，负数的反码在原码的基础上符号位不变，数值取反。

**补码：**为了解决负数计算时跨0的问题而出现的。

**补码计算规则：**正数的补码不变，负数的补码在反码的基础上+1。、

> [!CAUTION]
>
> 计算机中的存储和计算都是以补码的形式进行的。

## 8、进制说明

1、对于整数，有四种不同的表示方式：

- 二进制（binary）：0，1，满2进1，以0b或0B开头。
- 十进制（decimal）：0-9，满10进1.
- 八进制（octal）：0-7，满8进1.
- 十六进制（hex）：0-9及A-F，满16进1，以0x或0X开头表示，此处区分A-F大小写

2、二进制整数 的三种形式：

- 原码：直接将一个数值换成二进制数。最高号为是符号位
- 反码：对原码按位取反，只是最高位（符号位）确定为1.
- 补码：其反码+1.

注：计算机以二进制补码的形式保存所有的整数。

正数的原码、反码、补码都相同，三码合一

负数的补码是反码+1.

 

二进制——>八进制   二进制从右到左每三个一位看成一组。

二进制——>十六进制   二进制从右到左每四个一组看成一位。 

## 9、程序流程控制

- **顺序结构：**

- **选择结构：**

  if-else：

  ```
  if(条件1){
  	结果1；
  }else if(条件2){
  	结果2；
  }else{
  	结果3； 
  }
  ```

  switch -case：

  ```
  switch（表达式）{
      case 常量1：
              语句1；
              //break；
      case 常量2：
              语句2；
              //break;
          ........
       case 常量N：
              语句N；
              //break;
          default:
              语句；
              //break;
  }
  
  //switch新用法 JDK12:
    switch(week ){
               case 1 ->{
      }
  }
  ```

  说明：

  1. 根据switch表达式中的值，依次匹配各个case中的常量，一旦匹配成功，则进入相应的case结构中，调其执行语句。
  2. 当调用完执行语句之后，则仍继续向下执行其他的case结构中的执行语句，直到遇到break关键字或此switc-case结构末尾为止。
  3. break，可以使用在switch-case结构中，表示一旦执行到此关键字，就跳出switch-case结构。
  4. switch结构中的表达式们只能是如下6种类型之一：byte、short、char、int、枚举类型、String类型。表达式不允许放Boolean类型。
  5. case之后只是判断是否相等，只能声明常量，不能声明范围。
  6. break关键字是可选的
  7. default：相当于if-else结构中的else。default结构是可选的。，而且位置是灵活的。
  8. case穿透：就是语句体中没有写break导致。
  9. if-else一般用于对范围的判断，switch-case把有限个数据一一列举出来，任选其一。

- **循环结构：**

循环语句的四个部分：①初始化部分、②循环条件部分-----Boolean类型、③循环体部分、④迭代部分

说明：通常情况下，循环结束都是因为②中的循环条件返回false。

```
for循环  ：for（① ；②；④）{
      ③；
}

while循环：①；
       while（②）{
             ③；
             ④；
}
```

- [ ] 写while循环一定不要丢了迭代条件，一旦丢了，就可能出现死循环。
- [ ] for循环和while循环可以相互转换。
- [ ] for 和while的区别在于①初始化条件的作用范围不一样。

do-while循环：

​                   ①  

​                   do{

​                     ③；

​                     ④；

​                   }while（②）

执行过程：①--->③--->④--->②--->③。。。。。。--->②

说明：

- do-while循环至少会执行一次循环体。执行多次的话while和do-while就没区别。 
- 不在循环条件部分限制次数的结构：for（；；）和while（true）
- 结束循环的几种方式：
  - 方式一  循环条件部分返回false。
  - 方式二  循环体中返回break。 

**无限循环：**循环一直不停止

for(;;) {}    while(true){ }  

**跳过循环：**

continue: 跳过本次循环，继续执行下次循环。

break: 结束整个循环。

## **10、随机数生成**

如何获取一个随机数：double value = Math.random();   //[0.0，1.0)

​                   double value = Math.random()*100;  //[0.0，100.0)

​                    double value = Math.random()*90 +10;   //[0.0，100) ，

   获得一个整型的随机数：int value = (int)(Math.random()*90+10);   //即随机数范围是0-99

**随机数公式：[a,b] ----> (int)(Math.random()\*(b-a+1)+a)**

## 11、数组

**数组：**就是一种容器，可以用来存储同种数据类型的多个值。

> [!CAUTION]
>
> 数组容器在存储数据的时候，需要结合隐式转换考虑，如：int类型的数组容器不能存储Boolean、double类型的数据。容器的类型建议和存储的了

**数组的定义：**

格式一： 数据类型 [ ]  数组名

格式二： 数据类型   数组名[ ]

```
数组长度： arr.length 
```

**数组的初始化：**

- [ ] 静态初始化：在内存中，为数组容器开辟空间，并将数据存储到容器中的过程。

完整格式： 数据类型  [ ] 数组名 = new 数据类型[ ]{元素1，元素2……..} 

简化格式： 数据类型  [ ] 数组名 = {元素1，元素2……..}  

- [ ] 动态初始化：初始化时只指定数组长度，有系统为数组分配初始值。

格式： 数据类型[ ] 数组名  = new 数据类型[ 数组长度]；

​	    String[] names = **new** String[5];

说明：

​	数组元素的默认初始化值-----不同类型的数据类型默认初始化值

​	①数组元素是整型元素：0

​	②数组元素是浮点型：0.0

​	③数组元素是char类型：0

​	④数组元素是Boolean型：false

​	⑤数组元素是String类型：null

**动态初始化与静态初始化之间的区别：**

动态初始化：手动指定数组长度，由系统给出默认的初始化值

只明确元素个数，不明确具体数值，用动态初始化。

静态初始化：手动指定数组元素，系统会根据元素个数，计算出数组长度。

需求中明确了要操作的具体数据，直接用静态初始化即可。

**数组中常见的问题：**数组索引越界。



**数组内存分配：**

栈： 方法运行时使用的内存，比如main方法运行，进入方法栈中执行

堆： 存储对象或者数组，new来创建的，都存储在堆区

方法区： JVM使用操作系统的时候使用，和我们开发无关

寄存器： 给CPU使用，和我们开发无关。



**二维数组：**

**静态初始化**

```
格式： 数据类型[][] 数组名 = new 数据类型[][]{{元素1},{},{}};
简化格式： 数据类型[][] 数组名 = {{},{},{}}
```

**动态初始化**

```
格式： 数据类型[][] 数组名 = new 数据类型[m][n];
```

当需要把数据进行分组管理的时候就需要用到二位数组

## 12、方法

**方法定义：**方法是程序中最小的执行单元。

什么地方会用到方法： 重复的代码，具有独立功能的代码可以抽取到方法中。

方法的好处：提高代码的复用性和可维护性。

什么时候用到有返回值的结果？ 在调用处要根据方法的结果，去编写另外一段代码。

**有返回值的方法的定义格式？**

```
public static 返回值类型 方法名（参数）{
	方法体；
	return 返回值；
}
```

有返回值方法的调用格式：直接调用、赋值调用、输出调用

**方法的重载：**

- 在同一类中，定义了多个同名的方法，这些方法名具有相同的功能。
- 每个方法具有不同的参数类型或参数个数，这些同名的方法，就构成了重载关系。

**<font color="red">简单记：在同一个类中，方法名相同，参数不同的方法（包括参数类型或参数个数或顺序不同）。与返回值无关。</font>**

虚拟机根据参数的不同来确定调用的方法

基本数据类型：数据值存储在自己的空间中

引用数据类型：数据值存储在其他控件中，自己空间中存储的是地址值。

**方法传递引用数据类型的内存原理**：传递的参数为引用数据类型时，传递的时地址值和，形参的改变，影响实际参数的值。

**方法传递基本数据类型的内存原理**：传递的参数为引用数据类型时，传递的时地址值和，形参的改变，不影响实际参数的值。
