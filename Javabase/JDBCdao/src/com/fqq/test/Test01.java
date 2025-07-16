package com.fqq.test;

import com.fqq.dao.MyConnectionPool;

import java.sql.Connection;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 23:29
 * @Description: com.fqq.test
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
////        Emp emp=new Emp(null,30,7839,"JHON","MANNAGER",3000.12,1000.31,new Date());
////        EmpDao empDao=new EmpDaoImpl();
////        int rows =empDao.addEmp(emp);
////        System.out.println("rows:"+rows);
//        EmpDao eDI=new EmpDaoImpl();
//        int rows=eDI.deleteByEmpno(7935);

        Connection con1= MyConnectionPool.getConnection();
        Connection con2= MyConnectionPool.getConnection();
        Connection con3= MyConnectionPool.getConnection();
        Connection con4= MyConnectionPool.getConnection();
        Connection con5= MyConnectionPool.getConnection();
        Connection con6= MyConnectionPool.getConnection();
        Connection con7= MyConnectionPool.getConnection();
        Connection con8= MyConnectionPool.getConnection();
        Connection con9= MyConnectionPool.getConnection();
        Connection con10= MyConnectionPool.getConnection();
        Connection con11= MyConnectionPool.getConnection();

        MyConnectionPool.returnConnection(con1);
        MyConnectionPool.returnConnection(con2);
        MyConnectionPool.returnConnection(con3);
        MyConnectionPool.returnConnection(con4);
        MyConnectionPool.returnConnection(con5);
        MyConnectionPool.returnConnection(con6);
        MyConnectionPool.returnConnection(con7);
        MyConnectionPool.returnConnection(con8);
        MyConnectionPool.returnConnection(con9);
        MyConnectionPool.returnConnection(con10);
        MyConnectionPool.returnConnection(con11);


    }
}














