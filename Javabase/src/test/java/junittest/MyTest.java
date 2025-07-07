package junittest;
import junittest.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: fqq
 * @Date: 2025/5/12 - 05 - 12 - 23:11
 * @Description: junittest
 * @version: 1.0
 */
public class MyTest {
    @Before
    public void init(){
        System.out.println("开始方法:一般会在@Beforer修饰的那个方法中加入：加入一些申请资源的代码：申请数据库资源，申请IO资源，申请网络资源。。。");
    }
    @After
    public void end(){
        System.out.println("结束方法:一般会在@After修饰的那个方法中加入：加入释放资源的代码：释放数据库资源，释放IO资源，释放网络资源。。。");
    }
    @Test
    public void testAdd(){
        System.out.println("测试add方法");
        Calculator cal = new Calculator();
        int result = cal.add(10, 30);
        System.out.println(result);
        Assert.assertEquals(40,result);
    }
    @Test
    public void testSub(){
        System.out.println("测试sub方法");
        Calculator cal = new Calculator();
        int result = cal.sub(10, 30);
        System.out.println(result);
    }
}
