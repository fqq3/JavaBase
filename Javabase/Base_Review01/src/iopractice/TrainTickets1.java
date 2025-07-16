package iopractice;

/**
 * @author: fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 19:54
 * @Description: iopractice
 * @version: 1.0
 */
public class TrainTickets1 extends Thread {

    static int ticketNum=10;//共享十张票
    public void run(){
        for(int i=1;i<=100;i++){
            synchronized (TrainTickets1.class){//同步代码块
                if (ticketNum>0) {
                    System.out.println("我在"+this.getName()+"买到了第"+ticketNum--+"张车票");
                }
            }
        }
    }
    public TrainTickets1(String name) {
        super(name);
    }

}
