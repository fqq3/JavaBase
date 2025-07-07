package iopractice;

public class CustomerThread extends Thread {
    private Product p;
//    Lock lock=new ReentrantLock();
    public CustomerThread (Product p){
        this.p=p;
    }
    public void run(){
        for (int i = 1; i <= 10 ; i++) {//i:消费次数
            p.getProduct();;
        }
//        for(int i=1;i<=10;i++){
//            if(p.flag==false){
//                Product.lock.lock();
//                System.out.println("顾客消费了"+this.p.getBrand()+"--"+this.p.getName());
//                Product.lock.unlock();
//            }
//        }

    }


}
