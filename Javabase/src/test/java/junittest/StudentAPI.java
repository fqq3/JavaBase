package junittest;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 17:17
 * @Description: junittest
 * @version: 1.0
 */
public class StudentAPI extends PersonAPI{
    @SuppressWarnings("unused")
    private int age=10;



    @Override
    public void eat(int p, int d){
        System.out.println("一个学生正在吃第"+p+"道菜，总共有"+d+"道菜");
    }
    @Deprecated
    public void test(){
        System.out.println("Deprecated被弃用的方法:这个学生进行了一场考试。");
        System.out.println("@SupressWarnings(\"\")后面不加分号");
    }

}
