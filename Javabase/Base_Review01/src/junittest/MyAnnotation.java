package junittest;

/**
 * @author: fqq
 * @Date: 2025/5/14 - 05 - 14 - 18:16
 * @Description: junittest
 * @version: 1.0
 */

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.CLASS)
//.SOURCE表示这个注解只在源代码中保留，不会被编译到class文件中(仅源码阶段保留，编译后丢弃)
//.CLASS表示这个注解在class文件中保留,但运行时不可见（默认值）
//.RUNTIME表示这个注解在运行时保留，可以被编译到class文件中，可以被反射读取
//默认值是RententionPolicy.CLSASS
public @interface MyAnnotation {
    // @interface是固定结构，跟接口无关
    String[] value();//成员变量（配置参数）是一个无参方法
    int[] age() default {2,3,3};
    //如果只有一个参数，并且这个参数的名字为value的话，那么value=可以省略不写。
    //内部没有配置参数的是标记
    //有配置参数的是元数据
    //元注解是修饰其它注解的注解
    //@Target用于修饰注解的直接
    //    @Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
    // @Documented用于修饰注解，表示这个注解被javadoc工具记录,提取到API中
    // Inherited 用于修饰注解，表示这个注解可以继承


}



