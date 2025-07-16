package com.fqq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author: fqq
 * @Date: 2025/5/28 - 05 - 28 - 22:46
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestJdbc_delete {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root";

    public static void main(String[] args) {
//        delete();
        update();
    }
    public static void delete()  {
        int rows=0;
        Connection con=null;
        Statement stt=null;
        try{
            con= DriverManager.getConnection(url,user,password);
            //获得语句对象Statement
            stt=con.createStatement();
            String sql1="delete from dept where deptno=112;";
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
            if(stt!=null){
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void update()  {
        int rows=0;
        Connection con=null;
        Statement stt=null;
        try{
            con= DriverManager.getConnection(url,user,password);
            //获得语句对象Statement
            stt=con.createStatement();
            String sql1="update dept  set dname='总部',loc='北京' where deptno=60;";
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
            if(stt!=null){
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

