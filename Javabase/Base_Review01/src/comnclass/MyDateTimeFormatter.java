package comnclass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 17:47
 * @Description: comnclass
 * @version: 1.0
 */
public class MyDateTimeFormatter {
    public static void main(String[] args) {
        //String转换成Date
        //方式一:预定义的标准格式。如: ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;IS0_LOCAL_TIME
        DateTimeFormatter df1=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now=LocalDateTime.now();
        String str1= df1.format(now);
        System.out.println("now:"+now);
        //string=->localdata
        TemporalAccessor parse=df1.parse(str1);
        System.out.println("parse"+parse);
        System.out.println("----------二---------------------");

        //方式二:本地化相关的格式。如: oflocalizedDateTime()
        //参数：FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
        // LocalDateTime-》String
        LocalDateTime now1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.systemDefault());
        DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);;

        String str2=df2.format(zonedDateTime);
        System.out.println("str2: "+str2);

        TemporalAccessor parse1=df2.parse(str2);
        System.out.println("parse1:"+parse1);

        System.out.println("-------------三------------------");
        //方式三:自定义的格式。如: ofPattern("yyyy-MM-dd hh:mm:ss")
        //LocalDateTime--->String
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time2 = LocalDateTime.now();
        String str3 = df3.format(time2);
        System.out.println("str3: "+str3);
        //String--->LocalDateTime
        TemporalAccessor parse2 =df3.parse(str3);
        System.out.println("parse2: "+parse2);

    }
}
