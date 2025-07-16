package comnclass;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 21:47
 * @Description: comnclass
 * @version: 1.0
 *
 */
public class Season {
    //自定义枚举类练习
    //属性
    private final String seasonName;
    private final String seasonDesc;
    //构造器 私有化
    private Season(String season,String seasonDesc){
        this.seasonName=season;
        this.seasonDesc=seasonDesc;
    }
    //提供枚举类的有限实例
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","烈日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","冰天雪地");
    //已经创建好了对象，不用set方法

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season:"+"\t"+"seasonName:"+seasonName+"\t"+"seasonDesc:"+seasonDesc;
    }
}
