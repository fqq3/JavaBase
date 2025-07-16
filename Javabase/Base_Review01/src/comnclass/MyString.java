package comnclass;

import java.util.Arrays;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/28 - 04 - 28 - 16:27
 * @Description: comnclass
 * @version: 1.0
 */
public class MyString {
    public static void main(String[] args) {
        //字符串不可变，用char数组存储
        //被final修饰，无子类
        String s1 = "hello world";
        System.out.println(s1);
        String s2 = "";
        System.out.println(s2);
        String s3=new String("SOlD OUT:");
        //字符数组 拷贝成新数组赋值给Value
        String s4=new String(new char[]{'S','o','l','d'});
        System.out.println(s4.isEmpty());
        System.out.println(s4.charAt(3));
        System.out.println(s1.equals(s4));
        //String 实现了Comparable接口，必须实现方法compareTo
        //返回第一个不同位ASCII码的差值,字符串的长度差值
        System.out.println(s1.compareTo(s4));
        //字符串切片
        System.out.println(s3.substring(2,6));//[2,6) 左包右不包
        //字符串拼接
        String ss = "abcdeahija";
        System.out.println(ss.replace('a', 'u'));
        System.out.println(s3.concat("i'be a leader"));
        String s5=new String("a-b-s-c-d");
        String[] strs=s5.split("-");
        System.out.println("strs:"+ Arrays.toString(strs));
        System.out.println(s5);
        System.out.println(s4.toUpperCase());
        System.out.println(s4.toUpperCase().toLowerCase());
        //去除首尾空格
        String s6="  hello world  ";
        System.out.println(s6.trim());
        System.out.println(String.valueOf(false));
        //内存分析
        //第一次遇到的字符串会存储在字符串常量池，后面不会重复存储
        //ldc入栈
    }
}
