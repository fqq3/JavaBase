package com.fqq.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/25 - 06 - 25 - 4:14
 * @Description: com.fqq.dao
 * @version: 1.0
 */
public abstract class BaseDao {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root";
    public int baseUpdate(String sql,Object ... args) {//可变参数（varargs），表示可以传入任意数量的Object类型参数
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        int rt = 0;
        try {
            Class.forName(driver);// 加载驱动
            con = DriverManager.getConnection(url, user, password);//连接数据库
            //使用preparedStatement语句防止注入攻击  ？作为占位符 不再需要‘’
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
//            String sql2 = "insert into emp values(default,?,?,?,?,?,?,?)";
            prestt = con.prepareStatement(sql);// 获得一个预编译PreparedStatement 对象
            for(int i=0;i<args.length;i++){
                prestt.setObject(i+1, args[i]);//占位符从1开始，设置参数
            }
            rt = prestt.executeUpdate();
            System.out.println("返回结果：" + rt);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
////            System.out.println("返回结果："+rt);
            if (null != prestt) {//避免空指针异常
                try {
                    prestt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != con) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rt;
    }

    public List baseQuery(Class clazz,String sql,Object ... args) {//通过字节码获得类的字段
        List list = null;
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        ResultSet rt = null;

        try {
            Class.forName(driver);// 加载驱动  运行时根据类名的字符串形式来动态地加载指定的类
            con = DriverManager.getConnection(url, user, password);//连接数据库
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
//            String sql2 = "select * from emp where ename like ?";
            prestt = con.prepareStatement(sql);// 获得一个预编译PreparedStatement 对象
            for(int i=0;i<args.length;i++){
                prestt.setObject(i+1, args[i]);//占位符从1开始，设置参数
            }
//            rt=prestt.executeUpdate();//执行更新语句
            rt = prestt.executeQuery();//查询语句 System.out.println("返回结果：" + rt);
            list=new ArrayList();
            Field[] fields=clazz.getDeclaredFields();//获得传入类所有字段
            for(Field f:fields){
                f.setAccessible(true);//使私有字段也可以被访问和修改
            }
            while(rt.next()){
                Object obj=clazz.getDeclaredConstructor().newInstance();//默认通过反射调用空参构造方法
                for(Field field:fields){//临时用field
                    String fieldName=field.getName();//获得字段名
                    Object data = rt.getObject(fieldName); // 8. 从结果集中获取对应字段名的数据
                    field.set(obj, data);//设置属性值
                }
                list.add( obj);
            }
//
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (null != rt) {//避免空指针异常
                try {
                    rt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != prestt) {//避免空指针异常
                try {
                    prestt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != con) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
//        list.forEach(System.out::println);//:: 是 Java 的方法引用符号，读作“引用方法”。
        return list ;
    }

}
