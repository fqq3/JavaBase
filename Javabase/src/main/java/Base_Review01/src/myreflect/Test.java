package myreflect;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 23:24
 * @Description: MyReflect
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
//        Way w=Way.微信;

        Mtwm mtwm=new AliPay();
        //定义一个字符串，用来模拟前台的支付方式：
        String str = "微信";
        if("微信".equals(str)){//str.equals("微信")---？避免空指针异常
            //微信支付：
            //new WeChat().payOnline();
            pay(new WeChat());
        }
        if("支付宝".equals(str)){//str.equals("微信")---？避免空指针异常
            //new WeChat().payOnline();
            pay(new AliPay());
        }
        if("银行卡".equals(str)){//str.equals("微信")---？避免空指针异常
            //new WeChat().payOnline();
            pay(new BankCard());
        }


//        switch(w){
//            case 微信:
////                System.out.println("微信支付");
//                new WeChat().payOnline();
//                break;
//            case 支付宝:
////                System.out.println("支付宝支付");
//                new AliPay().payOnline();
//                break;
//
//            case 银行卡:
////                System.out.println("银行卡支付");
//                new WeChat().payOnline();
//                break;
//        }
    }
    public static void pay(Mtwm  mt){
        mt.payOnline();
    }
//    public static void pay(WeChat wc){
//        wc.payOnline();
//    }
//    public static void pay(AliPay ap){
//        ap.payOnline();
//    }
//    public static void pay(BankCard  bc){
//        bc.payOnline();
//    }
}
