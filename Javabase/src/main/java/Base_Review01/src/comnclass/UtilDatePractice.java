package comnclass;

import java.util.Date;
/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 12:01
 * @Description: comnclass
 * @version: 1.0
 */
public class UtilDatePractice {

    public static void main(String[] args) {
        Date d=new Date();
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(d.toGMTString());
        System.out.println(d.toLocaleString());
        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println("1）疑问：以后获取时间差用：getTime()还是currentTimeMillis()\n" +
                "        答案：currentTimeMillis()--》因为这个方法是静态的，可以类名.方法名直接调用");
// （2）public static native long currentTimeMillis();
//        本地方法
//        为什么没有方法体？因为这个方法的具体实现不是通过java写的。
//        （3）这个方法的作用：
//        一般会去衡量一些算法所用的时间
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
