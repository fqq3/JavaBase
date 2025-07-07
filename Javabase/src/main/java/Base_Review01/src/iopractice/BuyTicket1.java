package iopractice;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 19:59
 * @Description: iopractice
 * @version: 1.0
 */
public class BuyTicket1 {
    public static void main(String[] args) {
        //方法一
        TrainTickets1 tt1=new TrainTickets1("窗口一");
        tt1.start();
        TrainTickets1 tt2=new TrainTickets1("窗口二");
        tt2.start();
        TrainTickets1 tt3=new TrainTickets1("窗口三");
        tt3.start();
//        //方法二
//        TrainTickets2 tt21=new TrainTickets2();
//        Thread t21=new Thread(tt21,"窗口一");
//        t21.start();
//        Thread t22=new Thread(tt21,"窗口二");
//        t22.start();
//        Thread t23=new Thread(tt21,"窗口三");



        System.out.println("方法一：java单继承的局限性（只能继承一个类），Thread也实现了Runnable接口" +
                "方法二：不用static修饰类变量，共享资源能力强");
        System.out.println("1)多个代码块使用了同一个同步监视器（锁），锁住一个代码块的同时，也锁住所有使用该锁的所有代码块，其他线程无法访问其中的任何一个代码块 \n" +
                "2)多个代码块使用了同一个同步监视器（锁），锁住一个代码块的同时，也锁住所有使用该锁的所有代码块， 但是没有锁住使用其他同步监视器的代码块，其他线程有机会访问其他同步监视器的代码块" +
                "强调：同步代码块中能发生CPU的切换吗？能！！！ 但是后续的被执行的线程也无法执行同步代码块（因为锁仍旧close） ");
        System.out.println("Lock lock=new ReentrantLock() " +
                "Lock锁优先 -》同步代码块-》同步方法");


        //方法三
    }
}
