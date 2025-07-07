package comnclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 12:57
 * @Description: comnclass
 * @version: 1.0
 */
public class TestMainFormat {

        public static void main(String[] args) {
            //（1）String--->java.sql.Date
            java.sql.Date date = java.sql.Date.valueOf("2015-9-24");
            //（2）java.sql.Date--->java.util.Date
            java.util.Date date2 = date;
            System.out.println(date2.toString());
            System.out.println("date2: "+date2);
            System.out.println("上面的代码有局限性，字符串的格式只能是年-月-日拼接的形式，" +
                    "换成其它类型，就会出现异常");

            //日期转换：
            //SimpleDateFormat(子类) extends DateFormat（父类是一个抽象类）
            //格式化的标准已经定义好了：
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String--->Date
            try {
                Date d = df.parse("2019-4-6 12:23:54");
                System.out.println("String--->Date:  "+d);//=d.toString()
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Date--->String
            String format = df.format(new Date());
            System.out.println("Date--->String: "+format);
            Date t = new Date();//这个构造函数不接受参数，自动将当前系统日期和时间封装到一个新的 Date 对象中
            System.out.println(t.toString());
            System.out.println(t.toGMTString());
            System.out.println(t.toLocaleString());






        }

}
