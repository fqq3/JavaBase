package iopractice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private String brand;
    private String name;
    boolean flag=false;
    static Lock lock=new ReentrantLock();
    Condition ProduceCondition=lock.newCondition();
    Condition CustomerCondition=lock.newCondition();
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Product(){
    }
//    public void setAll(String brand,  String name){
//        this.brand=brand;
//        this.name=name;
//    }

    //生产商品
    public void setProduct(String brand,String name){//synchronized
        lock.lock();
        try {
            if(flag == true){//灯是红色，证明有商品，生产者不生产，等着消费者消费
                try {
    //                wait();
                    ProduceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);
            //将生产信息做一个打印：
            System.out.println("生产者生产了：" + this.getBrand() + "---" + this.getName());
            flag=true;
//            notify();
            CustomerCondition.signal();
        } finally {
            lock.unlock();
        }
    }
    //消费商品：
    public void getProduct(){//synchronized
        lock.lock();
        try {
            if (!flag) {
                try {
//                    wait();
                    CustomerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
            flag = false;
//            notify();
            ProduceCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
