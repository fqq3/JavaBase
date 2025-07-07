package comnclass;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 23:05
 * @Description: comnclass
 * @version: 1.0
 */
public class MySwitvhAndEnum {
    public static void main(String[] args) {
        Gender sex=Gender.女;
        switch(sex){
            case 女:
                System.out.println("这是一名女性人类");
                break;
            case 男:
                System.out.println("这是一名男性人类");
                break;
        }
    }
}
