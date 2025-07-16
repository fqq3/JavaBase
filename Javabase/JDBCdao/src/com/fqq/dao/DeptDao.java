package com.fqq.dao;

import com.fqq.pojo.Dept;

import java.util.List;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 22:26
 * @Description: com.fqq.dao
 * @version: 1.0
 */
public interface DeptDao {
    List<Dept> findAll();
    int addDept(Dept dept);
}
