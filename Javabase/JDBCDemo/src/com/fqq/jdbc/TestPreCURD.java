package com.fqq.jdbc;

import com.fqq.jdbc.entity.TestEmp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/5/30 - 05 - 30 - 0:34
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestPreCURD {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPreStmts=true&cachePrepStmts=true";
    private static String user = "root";
    private static String password = "root";

    public static void main(String[] args) {
//        Add();
//        Update();
//        Delete();
            Query();
    }

    public static void Add() {
        //向emp增加一条数据
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        int rt = 0;
        try {
            Class.forName(driver);// 加载驱动
            con = DriverManager.getConnection(url, user, password);//连接数据库
            //获得语句对象Statement
//            stt=con.createStatement();
//            String sql1="select * from account where username='"+name+"' and password='"+p+"';";//!!!!!!!
            //使用preparedStatement语句防止注入攻击  ？作为占位符 不再需要‘’
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
            String sql2 = "insert into emp values(default,?,?,?,?,?,?,?)";
            prestt = con.prepareStatement(sql2);// 获得一个预编译PreparedStatement 对象
            prestt.setString(1, "Micro");
            prestt.setString(2, "CLERK");
            prestt.setInt(3, 7839);//manager
            //特殊要求要导入 SQL包里的date  ！！！！！！！！！！
            prestt.setDate(4, new Date(System.currentTimeMillis()));
            prestt.setDouble(5, 3000.12);//sal
            prestt.setDouble(6, 200.0);//津贴
            prestt.setInt(7, 30);//部门

//            rt=prestt.executeQuery();//执行查询语句
            rt = prestt.executeUpdate();
            System.out.println("返回结果：" + rt);
//            System.out.println("sql2:"+sql2);
//            rt=prestt.executeQuery(sql2);//!!!!!!!!!!!!
//            boolean next =rt.next();
//            while(rt.next()){
//                int aid=rt.getInt("aid");
//                String username=rt.getString("username");
//                String pwd=rt.getString("password");
//                Double money=rt.getDouble("money");
//                ac=new Account(aid,username,pwd,money);
//                System.out.println("ac:"+ac);
//            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
////            System.out.println("返回结果："+rt);
//            if( null!=rt){//避免空指针异常
//                try{
//                    rt.close();
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
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
    }

    public static void Update() {
//向emp增加一条数据
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        int rt = 0;
        try {
            Class.forName(driver);// 加载驱动
            con = DriverManager.getConnection(url, user, password);//连接数据库
            //获得语句对象Statement
//            stt=con.createStatement();
//            String sql1="select * from account where username='"+name+"' and password='"+p+"';";//!!!!!!!
            //使用preparedStatement语句防止注入攻击  ？作为占位符 不再需要‘’
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
            String sql2 = "update emp set ename=? ,job=? where empno=? ";
            prestt = con.prepareStatement(sql2);// 获得一个预编译PreparedStatement 对象
            prestt.setString(1, "Alpha");
            prestt.setString(2, "MANAGER");
            prestt.setInt(3, 7934);
            rt = prestt.executeUpdate();//执行更新语句
            System.out.println("返回结果：" + rt);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
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

    }

    public static void Delete() {
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        int rt = 0;
        try {
            Class.forName(driver);// 加载驱动
            con = DriverManager.getConnection(url, user, password);//连接数据库
            //获得语句对象Statement
//            stt=con.createStatement();
//            String sql1="select * from account where username='"+name+"' and password='"+p+"';";//!!!!!!!
            //使用preparedStatement语句防止注入攻击  ？作为占位符 不再需要‘’
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
            String sql2 = "delete from emp  where empno=? ";
            prestt = con.prepareStatement(sql2);// 获得一个预编译PreparedStatement 对象

            prestt.setInt(1, 7935);
            rt = prestt.executeUpdate();//执行更新语句
            System.out.println("返回结果：" + rt);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
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
    }

    public static void Query() {
        List<TestEmp> list = null;
        Connection con = null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt = null;
        ResultSet rt = null;

        try {
            Class.forName(driver);// 加载驱动
            con = DriverManager.getConnection(url, user, password);//连接数据库
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
            String sql2 = "select * from emp where ename like ?";
            prestt = con.prepareStatement(sql2);// 获得一个预编译PreparedStatement 对象
            prestt.setString(1, "%S%");
//            rt=prestt.executeUpdate();//执行更新语句
            rt = prestt.executeQuery();
            System.out.println("返回结果：" + rt);
            list=new ArrayList<TestEmp>();
            while (rt.next()) {
                int a = rt.getInt("empno");//rt.getInt(列号也行，比如：1，2，3，)
                int dt = rt.getInt("deptno");
                int m = rt.getInt("mgr");
                String s = rt.getString("ename");
                String j = rt.getString("job");
                Double sal = rt.getDouble("sal");
                double cm = rt.getDouble("comm");
                Date d = rt.getDate("hiredate");//注意是java.sql包里的date
                System.out.println("empno:" + a + "deptno:" + dt + "job" + j + " ename:" + s + " hiredate:" + "sal" + sal + d + " comm:" + cm);
                TestEmp tem = new TestEmp(a, dt, m, s, j, sal, cm, d);
                list.add(tem);
            }
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
    }
}
