package com.corporationname.sum;
//
//import java.net.SocketOption;
//import java.net.SocketTimeoutException;

public class BasicUsage {
//    public static void main (String[] args) {
//        System.out.println("  BasicUsage.  ");
//
//    }
    public static class ArrayUtils {
    /**
     * 计算数组的平均值
     *
     * @param numbers 输入的整数数组
     * @return 数组的平均值
     * @throws IllegalArgumentException 如果数组为空或为null
     */
    public static double calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("数组不能为空或为null");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.length;
    }

    /*整数类型：
    byte：8位，范围是-128到127
    short：16位，范围是-32,768到32,767
    int：32位，范围是-2^31到2^31-1
    long：64位，范围是-2^63到2^63-1
    浮点类型：
    float：32位单精度浮点数
    double：64位双精度浮点数
    字符类型：
    char：16位Unicode字符
    布尔类型：
    boolean：表示真或假，只有两个取值true和false
    Java还提供了引用数据类型，包括：
    类（Class）
    接口（Interface）
    数组（Array）
    枚举（Enum）
    注解（Annotation）*/
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double average = calculateAverage(numbers);
        System.out.println("System.out.print ： 将双引号中内容原样输出，不换行\n" +
                "System.out.println ：将双引号中内容原样输出，换行");
        System.out.println("\t一个制表符“\\t”");
        System.out.println("数组的平均值是: " + average);
        System.out.println("【1】创建内容：alt+insert\n" +
                "【2】main方法：psvm\n" +
                "【3】输出语句：sout\n" +
                "【4】复制行：ctrl+d\n" +
                "【5】删除行：ctrl+y");
        System.out.println("【6】代码向上/下移动：Ctrl + Shift + Up / Down\n" +
                "【7】搜索类：  ctrl+n\n" +
                "【8】生成代码  ：alt + Insert（如构造函数等，getter,setter,hashCode,equals,toString）\n" +
                "【9】百能快捷键 : alt + Enter （导包，生成变量等）\n" +
                "【10】单行注释或多行注释 ：  Ctrl + / 或 Ctrl + Shift + /\n" +
                "【11】重命名 shift+f6\n" +
                "【12】for循环  直接 ：fori   回车即可\n" +
                "【13】代码块包围：try-catch,if,while等  ctrl+alt+t"
                +"【14】 代码自动补全提示:Control+ 空格"
                +"【16】代码一层一层调用的快捷键：\n" +
                "点进源码：ctrl+鼠标悬浮在代码上+点进去即可：");

        System.out.println("【17】显示代码结构  : alt + 7\n" +
                "【18】显示导航栏： alt +1 \n" +
                "【19】撤回：ctrl+z");
        int num1 = 12 ;//默认情况下赋值就是十进制的情况
        System.out.println(num1);
        int num3 = 0x12;//前面加上0x或者0X，这个值就是十六进制的
        System.out.println(num3);
        int num2 = 012;//前面加上0，这个值就是八进制的
        System.out.println(num2);
        int num4 = 0b10;//前面加上0b或者0B,这个值就是二进制的
        System.out.println(num4);
        double  f = 314e2;  //314*10^2-->31400.0
        double  f2 = 314e-2; //314*10^(-2)-->3.14
        System.out.println(f+"\n"+f2);
        //浮点类型的变量：
        //注意：浮点型默认是double类型的，要想将一个double类型的数赋给float类型，必须后面加上F或者f
        float f1 = 3.14234567898623F;
        //注意：我们最好不要进行浮点类型的比较：
        float e2 = 0.3F;
        double d2 = 0.3;
        System.out.println(e2==d2);
        double dd2 = 12+1294L+8.5F+3.81+'a';
        System.out.println(dd2);

        //逻辑异或： ^  规律：两个操作数相同，结果为false，不相同，结果为true
        System.out.println(true^true);
        System.out.println(true^false);
        System.out.println(false^false);
        System.out.println(false^true);
        int x=~6;
        System.out.println(x);
    }
}

}
