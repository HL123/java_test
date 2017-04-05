# Java解惑
## 奇数性
```java
public class OddMain {
    public static void main(String[] args) {
        System.out.println("1是奇数么" + isOdd(1));
        System.out.println("2是奇数么" + isOdd(2));
        System.out.println("-1是奇数么" + isOdd(-1));
    }

    private static boolean isOdd2(int i) {
        return (i & 1 ) != 0;
    }
    
}

```

### 分析
这是Java对取余操作符（%）的定义所产生的。isOdd方法对于对所有负奇数的判断都会失败。在任何负整数上调用该方法都回返回false，不管该整数是偶数还是奇数。
### 建议
无论你何时使用到了取余操作符，都要考虑到操作数和结果的符号。
### 解决
方案一

```
    private static boolean isOdd1(int i) {
        return i % 2 != 0;
    }
```
方案二
```
    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }
```
## 长整除
```java
public class LongDivision {
    public static void main(String[] args) {
        final long MICEOS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICEOS_PER_DAY/MILLIS_PER_DAY);
    }
}
```

### 分析
当两个int数值相乘时，将得到另一个int数值。因此最后的结果是int数值，从而导致溢出。

### 建议
当在操作很大的数字时，千万要提防溢出。

### 解决
强制表达式中的所有后续计算都用long运算来完成
```java
public class LongDivision {
    public static void main(String[] args) {
        final long MICEOS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println(MICEOS_PER_DAY/MILLIS_PER_DAY);
    }
}

```

## 找零时刻
```java
public class Change {
    public static void main(String[] args) {
        System.out.println(2.0-1.1);
    }
}
```
### 分析
并不是所有的小数都可以用二进制浮点数精确表示。
### 建议
在需要精确答案的地方，要避免使用float和double。对于货币计算，要使用int、long、BigDecimal。一定要用BigDecimal（String）构造器，而千万不要用BigDecimal（double）。后一个构造器将用它的参数的精确值来创建一个实例。
### 解决
方案一  使用printf控制
```
System.out.printf("%.2f",2.0-1.1);
```
方案二  使用BigDecimal
```
public class Change2 {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("2.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.1");
        System.out.println(bigDecimal1.subtract(bigDecimal2));
    }
}
```

## 多重转型
```java
public class Multicast {
    public static void main(String[] args) {
        System.out.println((int)(char)(byte)-1); 
    }
}
```

### 分析
应该是这样的byte(-1)自动类型提升
java采用补码 所以byte(-1)的补码为1111 1111 1111 1111 1111 1111 1111 1111
后面的就是

1。char类型向表示范围比它大的类型转换时使用的是0扩展，也就是说在高位补0。


2。byte类型转换为char类型其实是2步：先把byte提升为int，再把int转化为char（去掉高位）
 
 
 
如果最初的数值类型是有符号的，就执行符号扩展。如果是char，那么不管它将要被转换成什么类型，都执行零扩展。

byte 1个字节


char 2个字节


int   4个字节

## Dos Equis
```java
public class DosEquis {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.println(true?x:0);
        System.out.println(false?i:x);
    }
}

```

### 分析
1、如果第二个和第三个操作数具有相同的类型，那么它就是条件表达式的类
型。换句话说，你可以通过绕过混合类型的计算来避免大麻烦。


2、如果一个操作数的类型是 T，T 表示 byte、short 或 char，而另一个操作
数是一个 int 类型的常量表达式，它的值是可以用类型 T 表示的，那么条
件表达式的类型就是T。


3、否则，将对操作数类型运用二进制数字提升，而条件表达式的类型就是第
二个和第三个操作数被提升之后的类型。

### 建议 
总之，通常最好是在条件表达式中使用类型相同的第二和第三操作数。
