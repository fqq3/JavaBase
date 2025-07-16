package com.fqq.jdbc;

import com.fqq.jdbc.entity.TestEmp;

import java.sql.*;
import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/1 - 06 - 01 - 22:10
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestBatch {
//查询不修改数据，不进行批处理


    private static String driver="com.mysql.cj.jdbc.Driver";
    //加缓存参数：useServerPreStmts=true使用服务器端预编译语句 &cachePreStmts缓存预编译语句       &rewriteBatchedStatements=trueJDBC 驱动程序会尝试优化批处理的 SQL 语句。驱动程序可能会重写或改写这些语句，以便更高效地执行
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPreStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
    private static String user="root";
    private static String password="root";
    public static void main(String[] args) {
        testBatch();
    }

    public static void testBatch(){
        Connection con=null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt=null;
        ResultSet rt=null;
        List<TestEmp> list=null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,password);
            String sql1="insert into dept values(default,?,?)";//!!!!!!!;不要
            int rows=0;
            //获得语句对象
            prestt=con.prepareStatement(sql1);
            for(int i=0;i<10660;i++){//1000.for
                prestt.setString(1,"name");
                prestt.setString(2,"loc");
//                rows+=prestt.executeUpdate();//方法一
                prestt.addBatch();
                if( i%1000==0){//每一千作为一批，清理一次内存
                    prestt.executeBatch();
                    prestt.clearBatch();

                }
            }
//            int[] ints=prestt.executeBatch();
//            for(int i:ints){//每个i都是-2
//                rows++;
//                 System.out.println(rows);
//            }
            prestt.executeBatch();
            prestt.clearBatch();
//            System.out.println(rows);
//            rt=prestt.executeQuery(sql1);//!!!!!!!!!!!!
//            list =new ArrayList();
//            while(rt.next()){
//                int a=rt.getInt("empno");//rt.getInt(列号也行，比如：1，2，3，)
//                int dt=rt.getInt("deptno");
//                int m=rt.getInt("mgr");
//                String s=rt.getString("ename");
//                String j=rt.getString("job");
//                Double sal=rt.getDouble("sal");
//                double cm=rt.getDouble("comm");
//                Date d=rt.getDate("hiredate");//注意是java.sql包里的date
//
////                System.out.println("empno:"+a+"deptno:"+dt+"job"+j+" ename:"+s+" hiredate:"+"sal"+sal+d+" comm:"+cm);
//                TestEmp tem=new TestEmp(a,dt,m,s,j,sal,cm,d);
//                list.add(tem);
//            }
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

    }

}

