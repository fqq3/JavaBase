package iopractice;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 22:13
 * @Description: iopractice
 * @version: 1.0
 */
public class MyThreaddd implements Callable<Integer> {
    //实现Callable接口，可以不带泛型，默认Object类型
     //如果带泛型，那么call的返回值就是泛型的类型
    //call方法有返回值，可以抛出异常
    public Integer call() throws Exception{
        int r=new Random().nextInt(10);
        return r;
    }
}
//class Test{
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//
//    }
//}
