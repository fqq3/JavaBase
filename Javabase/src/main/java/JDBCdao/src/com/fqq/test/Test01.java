package com.fqq.test;

import com.fqq.dao.EmpDao;
import com.fqq.dao.impl.EmpDaoImpl;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 23:29
 * @Description: com.fqq.test
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
//        Emp emp=new Emp(null,30,7839,"JHON","MANNAGER",3000.12,1000.31,new Date());
//        EmpDao empDao=new EmpDaoImpl();
//        int rows =empDao.addEmp(emp);
//        System.out.println("rows:"+rows);
        EmpDao eDI=new EmpDaoImpl();
        int rows=eDI.deleteByEmpno(7935);









    }
}














