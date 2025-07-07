package classpractice;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/20 - 04 - 20 - 9:58
 * @Description: classpractice
 * @version: 1.0
 */
public class HR{
    public static Person getPerson(String name) {
        Person per = null;
        if("学生".equals(name)){
            per  = new Student();
        }
        if("工人".equals(name)){
            per = new Worker();
        }
        if("退休人员".equals(name)){
            per  = new Retire();
        }
        return per;
    }
}
