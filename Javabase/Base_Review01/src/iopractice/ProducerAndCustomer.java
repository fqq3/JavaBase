package iopractice;

public class ProducerAndCustomer {
    public static void main(String[] args) {
        Product p1=new Product();
        ProducerThread pt1=new ProducerThread(p1);
        pt1.start();
        CustomerThread ct1=new CustomerThread(p1);
        ct1.start();
        System.out.println("notyfy 唤醒等待池中的程序并继续执行wait()后面的" +
                "wait()和notyfy()必须放在synchronized修饰的代码块里，才生效" +
                "wait()进入阻塞状态，进同步池，释放同步锁，");
        System.out.println(" Condition ProduceCondition=lock.newCondition();" +
                " lock.lock();" +
                " CustomerCondition.await();" +
                " ProduceCondition.signal();" +
                "lock.unlock();");
    }
}
