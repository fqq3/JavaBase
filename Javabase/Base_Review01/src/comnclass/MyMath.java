package comnclass;
import static java.lang.Math.*;
/**
 * @Auther: fangqingqing
 * @Date: 2025/4/28 - 04 - 28 - 15:47
 * @Description: comnclass
 * @version: 1.0
 */
public class MyMath {
//    public static void main(String[] args) {
//        System.out.println(Math.PI);
//        System.out.println("随机数"+Math.random());
//        System.out.println("绝对值"+Math.abs(-20));
//        System.out.println("Math.ceil(9.134)向上取值："+Math.ceil(9.134));
//        System.out.println("Math.floor(9.95)向下取值："+Math.floor(9.95));
//        System.out.println("Math.round(3.45)四舍五入："+Math.round(3.45));
//        System.out.println("Math.sqrt(9)开平方："+Math.sqrt(9));
//        System.out.println("Math.pow(2,3)2的3次方："+Math.pow(2,3));
//        System.out.println("Math.max(2,3)取最大值："+Math.max(2,3));
//        System.out.println("Math.min(2,3)取最小值："+Math.min(2,3));
//    }
    public static void main(String[] args) {
        // Math类中的方法都是静态方法，所以要使用Math.方法名
        //导入静态包就不用
        //同名方法，就近原则
        System.out.println(PI);
        System.out.println("随机数"+random());//[0.0-1.0)
        System.out.println("绝对值"+abs(-20));
        System.out.println("Math.ceil(9.134)向上取值："+ceil(9.134));
        System.out.println("Math.floor(9.95)向下取值："+floor(9.95));
        System.out.println("Math.round(3.45)四舍五入："+round(3.45));
        System.out.println("Math.sqrt(9)开平方："+sqrt(9));
        System.out.println("Math.pow(2,3)2的3次方："+pow(2,3));
        System.out.println("Math.max(2,3)取最大值："+max(2,3));
        System.out.println("Math.min(2,3)取最小值："+min(2,3));
    }
}
