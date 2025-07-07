package comnclass;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 16:17
 * @Description: comnclass
 * @version: 1.0
 */
public class MyCalendar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你想要查看的日期（请按照例如2025-4-22的格式书写）：");
        String strDate= scanner.next();
        //System.out.println(strDate);

        //字符串变 日期
        java.sql.Date date1= java.sql.Date.valueOf(strDate);//strDate
        //date变 Calendar
        Calendar cal =Calendar.getInstance();
        cal.setTime(date1);
        System.out.println("日\t一\t二\t三\t四\t五\t六\t");
        int maxDay =cal.getActualMaximum(Calendar.DATE);
        int nowDay=cal.get(Calendar.DATE);
        cal.set(Calendar.DATE,1);//日期调为本月的号
        int num=cal.get(Calendar.DAY_OF_WEEK);//获取一号是本周第几天

        //System.out.println("num: "+num);
        int count=0;
        for(int i=0;i<num;i++){
            System.out.print("\t");
            count++;
        }

        for(int i=1;i<=maxDay;i++){
            if(count%7 == 0){
                System.out.println();
            }
            if(i==nowDay){
                System.out.print(i+"*\t");
            }else{
                System.out.print(i+"\t");
            }
            count++;

        }
        System.out.println("\n");



    }

}
