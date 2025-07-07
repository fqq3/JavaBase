package comnclass;

import java.sql.Date;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 12:49
 * @Description: comnclass
 * @version: 1.0
 */
public class SqlTime {
    public static void main(String[] args) {

        Date d = new Date(1592055964263L);
        System.out.println(d);
        System.out.println("(1)java.sql.Date和java.util.Date的区别：\n" +
                "        java.util.Date：年月日  时分秒\n" +
                "        java.sql.Date：年月日\n" +
                "        (2)java.sql.Date和java.util.Date的联系：\n" +
                "        java.sql.Date(子类) extends java.util.Date （父类）");
        java.util.Date date = new Date(15955254L);
        Date date1 = (Date)date;
        Date date2 = new Date(date.getTime());
        java.util.Date date3 = d;
        Date date4 = Date.valueOf("2020-06-13");

    }
}
