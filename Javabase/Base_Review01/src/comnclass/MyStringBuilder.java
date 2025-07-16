package comnclass;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/28 - 04 - 28 - 18:40
 * @Description: comnclass
 * @version: 1.0
 */
public class MyStringBuilder {
    public static void main(String[] args) {
        System.out.println("StringBuilder练习");
        StringBuilder sb=new StringBuilder();//默认长度16
        StringBuilder sb2=new StringBuilder(6);//指定长度6
        StringBuilder sb3=new StringBuilder("Sold out");//传字符串，长度为len（字符串）+16，然后调用append放str
        System.out.println(sb3.length());
        sb3.append("source");

    }
}
