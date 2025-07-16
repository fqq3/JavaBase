package com.fqq.jdbc;

/**
 * @author: fqq
 * @Date: 2025/5/28 - 05 - 28 - 19:53
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testjdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        向dept表中插入数据
         */
//        //1.加载驱动 Driver
//        Driver driver=new com.mysql.cj.jdbc.Driver();
//        //注册驱动  DriverManager  registerDriver静态方法
//        DriverManager.registerDriver(driver);
        //通过反射加载驱动 Driver里已经有注册驱动
        //SPI机制可以省略    Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        //url 统一资源定位符（定位数据库） = 协议(jdbc:mysql)+IP+端口号+数据库名 +参数
        //问号后：参数： useSSL 使用ssl认证机制   &useUnicode=true  启用Unicode支持，不指定具体编码  &characterEncoding=utf-8  使用utf-8编码
        //severTimezone服务器时区

        String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user="root";
        String password="root";
        Connection con=DriverManager.getConnection(url,user,password);
        //获得语句对象Statement
        Statement stt=con.createStatement();
        String sql1="insert into dept values(100,'助教部','合肥');";
        int rows=stt.executeUpdate(sql1);
        System.out.println("影响行数"+rows);
        //释放，倒序！！
        stt.close();
        con.close();
//public key retrial is not allowed 意思是：公钥重试不允许 可能是密码错误，+&allowPublicKeyRetrial=true  这个参数有受攻击的风险
//Acess denied for user 'root'@'localhost' (using password ：yes) 也是密码错误
//no suitable driver found 驱动错误
        //you have an error in your SQL syntax; SQL 语法错误
        //Table 'mydb.dept'doesn't exist 表名错

    }

}































