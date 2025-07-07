package myreflect;

import java.lang.reflect.Method;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 23:51
 * @Description: MyReflect
 * @version: 1.0
 */
public class Reflect {
    public static void main(String[] args) throws Exception{
        String str="myreflect.WeChat";//类的全限定名（包名 + 类名）
        Class cls=Class.forName(str);
        Object o =cls.newInstance();
        Method m=cls.getMethod("payOnline");
        m.invoke(o);
    }
}
