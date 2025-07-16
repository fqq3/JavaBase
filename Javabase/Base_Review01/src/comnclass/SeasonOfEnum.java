package comnclass;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 22:10
 * @Description: comnclass
 * @version: 1.0
 */
public enum SeasonOfEnum implements TestInterface {         //注意改成enu类！！！！！！！！！！

    SPRING("春","春暖花开"){
        @Override
        public void show(){
            System.out.println("春天是一只小猪");
        }
    },
    SUMMER("夏","烈日炎炎"){
        @Override
        public void show(){
            System.out.println("夏天是一只小老虎");
        }
    },
    AUTUMN("秋","秋高气爽"){
        @Override
        public void show(){
            System.out.println("秋天是一只小猫");
        }
    },
    WINTER("冬","冰天雪地"){
        @Override
        public void show(){
            System.out.println("冬天是一只小狗");
        }
    };

    private final String seasonName;
    private final String seasonDesc;
    private SeasonOfEnum(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return this.seasonName+"--"+this.seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("SHOW:Name:"+this.seasonName+"\tDesc:"+this.seasonDesc);
//    }

}
