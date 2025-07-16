package com.fqq.jdbc;

import java.sql.*;

/**
 * @author: fqq
 * @Date: 2025/6/2 - 06 - 02 - 13:31
 * @Description: com.fqq.jdbc
 * @version: 1.0
 */
public class TestTransaction {
    //JDBC默认自动提交事务,每个 prepareStatement.executeUpdate都会提交一次事务
    //Connection对象.setAutoCommit()方法控制手动提交，   设置手动提交后，executeUpdate()不再提交事务，
    //事务最终一定要提交，建议放在finally里
    private static String driver="com.mysql.cj.jdbc.Driver";
    //加缓存参数：useServerPreStmts=true使用服务器端预编译语句 &cachePreStmts缓存预编译语句       &rewriteBatchedStatements=trueJDBC 驱动程序会尝试优化批处理的 SQL 语句。驱动程序可能会重写或改写这些语句，以便更高效地执行
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPreStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
    private static String user="root";
    private static String password="root";
    public static void main(String[] args) {
        testTransaction();
    }
    public static void testTransaction(){
        Connection con=null;//穿衣服，先穿的后脱掉
        PreparedStatement prestt=null;
        ResultSet rt=null;
//        List<TestEmp> list=null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,password);
            //手动提交
            con.setAutoCommit(false);//手动提交，默认自动提交
            String sql1="update account set money=money-? where aid =?";//!!!!!!!;不要
            prestt=con.prepareStatement(sql1);

//            int rows=0;
            //转入
            prestt.setDouble(1,100);
            prestt.setInt(2,1);
            prestt.executeUpdate();//自动提交
//            int i = 1/0;//异常测试
            //转出
            prestt.setDouble(1, -100);
            prestt.setInt(2,2);
            prestt.executeUpdate();
            //获得语句对象
//            for(int i=0;i<10660;i++){//1000.for
//                prestt.setString(1,"name");
//                prestt.setString(2,"loc");
////                rows+=prestt.executeUpdate();//方法一
//                prestt.addBatch();
//                if( i%1000==0){//每一千作为一批，清理一次内存
//                    prestt.executeBatch();
//                    prestt.clearBatch();
//                }
//            }
//            int[] ints=prestt.executeBatch();
//            for(int i:ints){//每个i都是-2
//                rows++;
//                 System.out.println(rows);
//            }
            prestt.executeBatch();//
            prestt.clearBatch();//清理
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

            if (null!=con) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();

        } finally{
//            System.out.println("返回结果："+rt);

            if (null!=con) {
                try {
                    con.commit();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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
