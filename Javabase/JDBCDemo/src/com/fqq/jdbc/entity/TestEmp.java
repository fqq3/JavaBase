package com.fqq.jdbc.entity;

import java.util.Date;

/**
 * @author: fqq
 * @Date: 2025/5/29 - 05 - 29 - 9:34
 * @Description: com.fqq.jdbc.entity
 * @version: 1.0
 */
public class TestEmp {
    //需要实现序列化接口
    //至少一个空参构造方法
    private Integer empno;//可能有null值
    private Integer deptno;
    private Integer mgr;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    private Date hireDate;//导入util时间类 util是sql DATE的父类，可以多态
// 空参构造器
    public TestEmp(){

    }

    public TestEmp(Integer empno, Integer deptno, Integer mgr, String ename, String job, double sal, double comm, Date hireDate) {
        this.empno = empno;
        this.deptno = deptno;
        this.mgr = mgr;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "TestEmp{" +
                "empno=" + empno +
                ", deptno=" + deptno +
                ", mgr=" + mgr +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", hireDate=" + hireDate +
                '}';
    }

    //所有参数getter和setter方法
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
