package comnclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/22 - 04 - 22 - 17:26
 * @Description: comnclass
 * @version: 1.0
 */
public class LocalDatePractice {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime =LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate of=LocalDate.of(2020,4,5);
        System.out.println(of);
        LocalTime of1=LocalTime.of(12,35,24);
        System.out.println(of1);
        LocalDateTime of2=LocalDateTime.of(1986,2,24,9,21,46);
        System.out.println(of2);

        //一些列常用的get***
        System.out.println(localDateTime.getYear());//2020
        System.out.println(localDateTime.getMonth());//JUNE
        System.out.println(localDateTime.getMonthValue());//6
        System.out.println(localDateTime.getDayOfMonth());//14
        System.out.println(localDateTime.getDayOfWeek());//SUNDAY
        System.out.println(localDateTime.getHour());//22
        System.out.println(localDateTime.getMinute());//22
        System.out.println(localDateTime.getSecond());//6
        // 不是set方法，叫with
        //        //体会：不可变性
        LocalDateTime localDateTime2=localDateTime.withMonth(8);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        //加减

        //提供了加减的操作：
        //加：
        LocalDateTime localDateTime1 = localDateTime.plusMonths(4);//
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        //减：
        LocalDateTime localDateTime3 = localDateTime.minusMonths(5);//
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

    }
}
