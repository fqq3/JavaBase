package comnclass;


import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 15:54
 * @Description: comnclass
 * @version: 1.0
 */
public class CalendarPractice {
    public static void main(String[] args) {
        //创建对象
        Calendar cal1 =new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance();
        System.out.println("cal1: "+cal1);
        System.out.println(cal1.get(Calendar.YEAR));
        System.out.println(cal1.get(Calendar.MONTH));
        System.out.println(cal1.get(Calendar.DATE));
        System.out.println(cal1.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal1.getActualMaximum(Calendar.DATE));
        System.out.println(cal1.getActualMinimum(Calendar.DATE));
        //改变用set
        cal1.set(Calendar.YEAR,2020);
        cal1.set(Calendar.MONTH,4);
        cal1.set(Calendar.DATE,16);
        System.out.println(cal1);
        java.sql.Date d1=java.sql.Date.valueOf("2020-4-5");
        cal1.setTime(d1);
        System.out.println(cal1);



    }
}
