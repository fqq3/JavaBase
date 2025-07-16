package com.fqq.jdbc;

import com.fqq.jdbc.entity.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author: fqq
 * @Date: 2025/5/29 - 05 - 29 - 22:38
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestAccount {
    //预编译需要加两个参数才能开启：useServerPreStmts=true &cachePrepStmts=true 适用于批处理
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPreStmts=true&cachePrepStmts=true";
    private static String user="root";
    private static String password="root";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入密码");
        String pwd=sc.next();
//        String name="张三";
//        String pwd="333333";
        Account customer=getAccount(name,pwd);
        System.out.println(null!=customer?"登陆成功":"登陆失败");
        sc.close();
    }
    public static Account getAccount(String name,String p){
        Account ac=null;
        Connection con=null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt=null;
        ResultSet rt=null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,password);
            //获得语句对象Statement
//            stt=con.createStatement();
//            String sql1="select * from account where username='"+name+"' and password='"+p+"';";//!!!!!!!
            //使用preparedStatement语句防止注入攻击  ？作为占位符 不再需要‘’
            // connection.createStatement获得普通语句
            //preparedStatement获得的是预编译语句，先传入语句再设置参数
            String sql2="select * from account where username = ? and password = ?";
            prestt=con.prepareStatement(sql2);
            prestt.setString(1,name);
            prestt.setString(2,p);
            rt=prestt.executeQuery();
//            System.out.println("sql2:"+sql2);
//            rt=prestt.executeQuery(sql2);//!!!!!!!!!!!!
//            boolean next =rt.next();
            while(rt.next()){
                int aid=rt.getInt("aid");
                String username=rt.getString("username");
                String pwd=rt.getString("password");
                Double money=rt.getDouble("money");

                ac=new Account(aid,username,pwd,money);
                System.out.println("ac:"+ac);
            }
        }catch(Exception e){
            e.printStackTrace();

        } finally{
//            System.out.println("返回结果："+rt);
            if( null!=rt){//避免空指针异常
                try{
                    rt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if( null!=prestt){//避免空指针异常
                try{
                    prestt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(null !=con){
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return ac;
    }
}
