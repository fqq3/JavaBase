package main.fqq.dao.impl;

import main.fqq.dao.BaseDao;
import main.fqq.dao.DeptDao;
import main.fqq.pojo.Dept;

import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 22:28
 * @Description: com.fqq.dao.impl
 * @version: 1.0
 */
public class DeptDaoImpl extends BaseDao implements DeptDao {
//    private static String driver="com.mysql.cj.jdbc.Driver";
//    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
//    private static String user="root";
//    private static String password="root";

    @Override
    public List<Dept> findAll(){

            String sql1="select * from dept";//写SQL
            return baseQuery(Dept.class,sql1);

    }

    public int addDept(Dept dept){

        String sql="insert into dept values(?,?,?);";
        return baseUpdate(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
    }
}
