package iopractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 16:48
 * @Description: iopractice
 * @version: 1.0
 */


public class MyThreadd implements Runnable{
    Lock lock=new ReentrantLock();//接口等于实现类  多态
    @Override
    public void run() {
        for(int i=1;i<10;i++){
            lock.lock();

            try {
                System.out.println("MyThreadd:"+Thread.currentThread().getName()+"-----"+i);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}
