package iopractice;

/**
 * &#064;author:  fangqingqing
 * @Date: 2025/5/10 - 05 - 10 - 3:00
 * @Description: iopractice
 * @version: 1.0
 */
public class MyThread extends Thread {
    public MyThread(){
        super();
    }
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
//        super.run();
        for (int i = 1; i <= 10 ; i++) {

            System.out.println("MyThread:"+this.getName()+i);
        }
    }
}
