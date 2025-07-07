package comnclass;

import test.java.junittest.PersonAPI;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 21:59
 * @Description: comnclass
 * @version: 1.0
 */
public class TestSeason {
    public static void main(String[] args) {
        Season s=Season.AUTUMN;
        System.out.println(s);
        System.out.println("Season:"+s.getSeasonDesc());

        SeasonOfEnum soe=SeasonOfEnum.SPRING;//SUMMER
        System.out.println(soe);
        System.out.println(s.getSeasonDesc());
        System.out.println("===========================================");
        System.out.println("Enum的父类是java.lang.Enum");
        System.out.println("自定义类的父类是Object");
        System.out.println(soe);
        System.out.println(SeasonOfEnum.values());
        System.out.println(SeasonOfEnum.valueOf("AUTUMN"));
        SeasonOfEnum soee=SeasonOfEnum.WINTER;
        soe.show();
        soee.show();
        System.out.println("--------------------------------------------------------------------");
        PersonAPI p1=new PersonAPI();
        p1.setAge(23);
        p1.setName("lili");
        p1.setSex(Gender.女);
    }
}
