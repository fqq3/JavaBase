package iopractice;

import java.util.concurrent.ExecutionException;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 3:11
 * @Description: iopractice
 * @version: 1.0
 */
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start方法是线程启动的方法，调用该方法表示要启动一个线程，而run方法单独调用的话就是一个普通方法；当线程启动后，会调用run方法来作为线程里面的内容");
        System.out.println("先启动子线程，子线程才能有能力争抢资源" +
                "=====================第一种===================");

        //给main方法线程设置名字
//        Thread.currentThread().setName("主线程");
//        for (int i = 1; i <= 10 ; i++) {
//            System.out.println(Thread.currentThread().getName()+"1:"+i);
//        }
//        MyThread mt=new MyThread();
//        mt.setName("子线程");
////        mt.run();
//        mt.setPriority(6);
//        mt.start();
//        System.out.println("already start1！！！！！！！！");
//
//        for (int i = 1; i <= 10 ; i++) {
//            System.out.println(Thread.currentThread().getName()+"2:"+i);
//        }
//        System.out.println("================第二种==============");
//        MyThreadd mt2=new MyThreadd();//MyThreadd继承Runnable
//        Thread t =new Thread(mt2,"2子线程1");
//        t.start();
//        System.out.println("already start2！！！！！！！！");
//        for(int i=1;i <= 11;i++){
//            System.out.println(Thread.currentThread().getName()+"主: "+i);
//        }
        System.out.println("===================第三种============================");
//        MyThreaddd mt1=new MyThreaddd();
//        FutureTask ft=new FutureTask(mt1);
//        Thread t1=new Thread(ft);
//        t1.start();
//        Object obj=ft.get();
//        System.out.println("obj:"+obj);
        System.out.println("new Thread创建" +
                "start()启动后进入就绪状态" +
                "run()获取执行权进入运行状态" +
                "若阻塞 进入阻塞状态   否则结束进入消亡状态" +
                "阻塞结束进入就绪状态");
        System.out.println("=--------------------------立马执行.join。伴随线程.setDaemon---------------------------=");

        for(int i=1;i<=20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            if(i==5){
                MyThread mt3=new MyThread("子线程3:");
//               mt3.setDaemon(true);
                mt3.start();
//                mt3.join();
            }
        }
//        System.out.println("=--------------------------sleep---------------------------=");
//        //定义事件类型
//        DateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        int i=0;
//        while (i<100) {
//            Date d=new Date();
//            Thread.sleep(1500);
//            String date = df.format(d);
//            System.out.println(date);
//            i++;
//        }
//        System.out.println("=----------------------------过期方法----stop------------------------=");
//        for (int i = 1; i <=30 ; i++) {
//            if(i == 6){
//                Thread.currentThread().interrupt();//过期方法，不建议使用
//            }
//            System.out.println(i);
//        }

    }
}
