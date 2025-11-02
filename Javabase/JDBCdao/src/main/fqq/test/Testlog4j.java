package main.fqq.test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;  // 关键！

/**
 * @author: fqq
 * @Date: 2025/7/17 - 07 - 17 - 4:16
 * @Description: com.fqq.test
 * @version: 1.0
 */
public class Testlog4j {
    public static void main(String[] args) {
        //多表没有单表查询效率高
        //1.字符串一般传入类的全路径名
        //2.传入类的字节码根据类的字节码自动获取全路径
        Logger logger1=LogManager.getLogger("com.fqq.dao.impl.EmpDaoImpl");
        Logger logger2=LogManager.getLogger(Testlog4j.class);
        //依据 *配置文件* 中定义的日志级别，打印日志
        logger2.fatal("fatal message");//五个级别，依次降低日志级别
        logger2.error("error message");
        logger2.warn("warn message");
        logger2.info("info message");
        logger2.debug("debug message");
        //3.传入对象字节码
        try {
            int i=1/0;
        } catch (Exception e) {
//            e.printStackTrace();
            logger2.warn("程序捕获到了异常信息",e);
        }
    }
}
