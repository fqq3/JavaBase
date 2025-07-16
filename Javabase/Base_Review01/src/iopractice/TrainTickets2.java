package iopractice;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 20:43
 * @Description: iopractice
 * @version: 1.0
 */
public class TrainTickets2 implements Runnable{
    static int tickets=10;
//    public TrainTickets2(String name){
//        this.setName(name);
//    }
    public void run(){
        for(int i=0;i<100;i++){
            Buy();
        }
    }
    public static synchronized void Buy() {//同步方法 类共享
        if (tickets > 0) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + "正在卖第" + (tickets--) + "张票");
        }
    }
}
