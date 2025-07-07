package com.fqq.dao.impl;

import com.fqq.dao.BaseDao;
import com.fqq.dao.EmpDao;
import com.fqq.pojo.Emp;

import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 22:27
 * @Description: com.fqq.dao.impl
 * @version: 1.0
 */
public class EmpDaoImpl extends BaseDao implements EmpDao {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root";


    @Override
    public int addEmp(Emp emp) {
        String sql2 = "insert into emp (deptno, mgr, ename, job, sal, comm, hireDate) values (?,?,?,?,?,?,?)";
        return baseUpdate(sql2,emp.getDeptno(),emp.getMgr(),emp.getEname(),emp.getJob(),emp.getSal(),emp.getComm(),emp.getHireDate());

    }


    @Override
    public int deleteByEmpno(int empno) {
           String sql = "delete from emp  where empno=? ";
           return baseUpdate(sql,empno);
    }

    @Override
    public List<Emp> findAll() {
            String sql2 = "select * from emp";//where ename like ?
            return baseQuery(Emp.class,sql2);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update emp set deptno=?,mgr=?,ename=?,job=?,sal=? ,comm=?,hireDate=? where empno=?";

        return baseUpdate(sql,emp.getDeptno(),emp.getMgr(),emp.getEname(),emp.getJob(),emp.getSal(),emp.getComm(),emp.getHireDate(),emp.getEmpno());
    }


}
