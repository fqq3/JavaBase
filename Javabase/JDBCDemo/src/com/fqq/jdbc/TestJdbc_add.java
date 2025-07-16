package com.fqq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author: fqq
 * @Date: 2025/5/28 - 05 - 28 - 22:30
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestJdbc_add {

    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root";

    public static void main(String[] args) {
          /*
        向dept表中插入数据

         */
//        //1.加载驱动 Driver
//        Driver driver=new com.mysql.cj.jdbc.Driver();
//        //注册驱动  DriverManager  registerDriver静态方法
//        DriverManager.registerDriver(driver);
        //通过反射加载驱动 Driver里已经有注册驱动
        //SPI机制可以省略 Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        //url 统一资源定位符（定位数据库） = 协议(jdbc:mysql)+IP+端口号+数据库名 +参数
        //问号后：参数： useSSL 使用ssl认证机制   &useUnicode=true  启用Unicode支持，不指定具体编码  &characterEncoding=utf-8  使用utf-8编码
        //severTimezone服务器时区
        int rows=0;
        Statement stt=null;
        Connection con=null;
        try{
            con= DriverManager.getConnection(url,user,password);
            //获得语句对象Statement
            stt=con.createStatement();
            String sql1="insert into dept values(112,'后勤部','东京');";
            rows=stt.executeUpdate(sql1);
        }catch(Exception e){
            e.printStackTrace();

        } finally{
            System.out.println("影响行数"+rows);
            if(stt!=null){//避免空指针异常
                try{
                    stt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        //释放，倒序！！

//public key retrial is not allowed 意思是：公钥重试不允许 可能是密码错误，+&allowPublicKeyRetrial=true  这个参数有受攻击的风险
//Acess denied for user 'root'@'localhost' (using password ：yes) 也是密码错误
//no suitable driver found 驱动错误
        //you have an error in your SQL syntax; SQL 语法错误
        //Table 'mydb.dept'doesn't exist 表名错
        //"Duplicate" “重复项”


    }

}
