package com.fqq.dao;

import com.fqq.pojo.Emp;

import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 22:26
 * @Description: com.fqq.dao
 * @version: 1.0
 */
public interface EmpDao {
    /**
     *  向数据库Emp中增加数据的方法
     * @param emp Emp表的对应类
     * @return  增加成功，返回增加行数，失败返回0
     */
    public int addEmp(Emp emp);
    /**
     * 根据员工编号删除员工信息
     * @param empno 员工编号
     * @return 删除成功，返回删除行数，失败返回0
     */
    public int deleteByEmpno(int empno);

    /**
     * 查看数据库里所有员工的信息
     * @return 所有员工封装的List
     */
    List<Emp> findAll();
    public int updateEmp(Emp emp);


}
