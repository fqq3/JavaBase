package com.fqq.jdbc;

import com.fqq.jdbc.entity.TestEmp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/5/28 - 05 - 28 - 23:27
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestSelec {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root";

    public static void main(String[] args) {
      List<TestEmp>list= select();
        for(TestEmp tem:list) {
            System.out.println(tem);
        }
    }
    public static List<TestEmp> select(){
        Connection con=null;//穿衣服，先穿的后脱掉
        Statement stt=null;
        ResultSet rt=null;
        List<TestEmp> list=null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,password);
            //获得语句对象Statement
            stt=con.createStatement();
            String sql1="select * from emp where deptno=10;";//!!!!!!!
            rt=stt.executeQuery(sql1);//!!!!!!!!!!!!
//            boolean next =rt.next();
            list =new ArrayList();
            while(rt.next()){
                int a=rt.getInt("empno");//rt.getInt(列号也行，比如：1，2，3，)
                int dt=rt.getInt("deptno");
                int m=rt.getInt("mgr");
                String s=rt.getString("ename");
                String j=rt.getString("job");
                Double sal=rt.getDouble("sal");
                double cm=rt.getDouble("comm");
                Date d=rt.getDate("hiredate");//注意是java.sql包里的date

//                System.out.println("empno:"+a+"deptno:"+dt+"job"+j+" ename:"+s+" hiredate:"+"sal"+sal+d+" comm:"+cm);
                TestEmp tem=new TestEmp(a,dt,m,s,j,sal,cm,d);
                list.add(tem);
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
            if( null!=stt){//避免空指针异常
                try{
                    stt.close();
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
        return list;
    }
}
