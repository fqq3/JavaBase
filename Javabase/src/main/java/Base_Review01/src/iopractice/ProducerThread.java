package iopractice;

public class ProducerThread extends  Thread{
    //共享商品
    private Product p;
    public ProducerThread(Product p){
        this.p=p;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {//生产十个商品 i:生产的次数
            if(i % 2 == 0){
                p.setProduct("费列罗","巧克力");
            }else{
                p.setProduct("哈尔滨","啤酒");
            }
        }
    }
//    public void run(){
//        for(int i=1;i<20;i++){
//            if(p.flag==true){
//                try{
//                    wait();
//                }catch(InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//
//            Product.lock.lock();
//            if(i%2==0){
//                p.setAll("费列罗","巧克力");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }else{
//                p.setAll("哈尔滨","啤酒");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("工厂生产了: "+p.getBrand()+"--"+p.getName());
//            Product.lock.unlock();
//            p.flag=true;
//        }
//    }
}
