package comnclass;

import java.util.Random;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/28 - 04 - 28 - 16:06
 * @Description: comnclass
 * @version: 1.0
 */
public class MyRandom {
    public static void main(String[] args) {
        System.out.println("Random练习");
        //带参数
        Random rd1 = new Random(15246L);//System.currentTimeMillis()
        int r=rd1.nextInt();
        System.out.println(r);

        //空参构造器
        Random r2=new Random();//构造器自带参数

    }
}
