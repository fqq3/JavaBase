package com.fqq.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: fqq
 * @Date: 2025/7/15 - 07 - 15 - 4:22
 * @Description: com.fqq.test
 * @version: 1.0
 */
public class test02 {
    public static void main(String[] args) {
        Properties properties=new Properties();
        //下一句仅适用于JDK 1.8  第一个"/"表示src 目录
        InputStream inputStream=test02.class.getResourceAsStream("/jdbc.properties");//返回IO流指向字节码根路径（out里）下的文件
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String property=properties.getProperty("driver");
        System.out.println(property);
    }

}
