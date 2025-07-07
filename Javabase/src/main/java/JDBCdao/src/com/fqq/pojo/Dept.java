package com.fqq.pojo;

import java.io.Serializable;

/**
 * @author: fqq
 * @Date: 2025/6/17 - 06 - 17 - 22:20
 * @Description: com.fqq.pojo
 * @version: 1.0
 */
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc ;

    public Dept(){

    }
    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
