package com.fqq.view;

import com.fqq.dao.DeptDao;
import com.fqq.dao.EmpDao;
import com.fqq.dao.impl.DeptDaoImpl;
import com.fqq.dao.impl.EmpDaoImpl;
import com.fqq.pojo.Dept;
import com.fqq.pojo.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @author: fqq
 * @Date: 2025/6/19 - 06 - 19 - 17:33
 * @Description: com.fqq.view
 * @version: 1.0
 */
public class EmpManagerSystem {
    private static Scanner sc=new Scanner(System.in);
    private static EmpDao ed=new EmpDaoImpl();
    private static DeptDao dd=new DeptDaoImpl();
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while(true){
            showMenu();
            System.out.println("请录入选项：");
            int option =sc.nextInt();
            switch(option){
                case 1:

                    List<Emp> emps=ed.findAll();
                    emps.forEach(System.out::println);
                    break;
                case 2:
                    List<Dept> depts=dd.findAll();
                    depts.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("请输入要删除的员工号：");
                    int empno=sc.nextInt();
                    ed.deleteByEmpno(empno);
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    System.out.println("请输入要增加的部门号：");
                    int deptno=sc.nextInt();
                    System.out.println("请录入部门名称：");
                    String dname=sc.next();
                    System.out.println("请录入部门位置：");
                    String loc=sc.next();
                    Dept dept=new Dept(deptno,dname,loc);
                    dd.addDept(dept);
                    break;
                case 7:
                    exit(1);
                    break;
                default:
                    System.out.println("请输入正确的选项");
            }
        }
    }

    public static void showMenu(){
        System.out.println("************************************************");
        System.out.println("1.查询所有员工信息");
        System.out.println("2.查看所有部门信息");
        System.out.println("3.根据工号删除员工信息");
        System.out.println("3.根据工号修改员工信息");
        System.out.println("5.添加员工信息");
        System.out.println("6.增加部门信息");
        System.out.println("7.退出系统");
        System.out.println("************************************************");
    }
    public static void case4(){
        System.out.println("请输入要修改的员工编号：");
        int empno=sc.nextInt();
        System.out.println("请输入员工部门号：");
        int deptno=sc.nextInt();
        System.out.println("请输入员工上级：");
        int mgr=sc.nextInt();
        System.out.println("请输入员工姓名：");
        String ename=sc.next();
        System.out.println("请输入员工职位：");
        String job=sc.next();
        System.out.println("请输入员工工资：");
        double sal=sc.nextDouble();
        System.out.println("请输入员工补助：");
        double comm=sc.nextDouble();
        System.out.println("请输入员工入职日期,格式为yyyy-MM-dd：");
//        String hireDate=sc.next();//需要转化为日期
        Date hireDate=null;
        try{
            hireDate =sdf.parse(sc.next());
        }catch(ParseException e){
            e.printStackTrace();
        }
        Emp emp4=new Emp(empno,deptno,mgr,ename,job,sal,comm,hireDate);
        ed.updateEmp(emp4);
    }
    public static void case5() {
//        System.out.println("请输入要修改的员工编号：");
//        int empno=sc.nextInt();//完全由数据库自行维护
        System.out.println("请输入员工部门号：");
        int deptno=sc.nextInt();
        System.out.println("请输入员工上级：");
        int mgr=sc.nextInt();
        System.out.println("请输入员工姓名：");
        String ename=sc.next();
        System.out.println("请输入员工职位：");
        String job=sc.next();
        System.out.println("请输入员工工资：");
        double sal=sc.nextDouble();
        System.out.println("请输入员工补助：");
        double comm=sc.nextDouble();
        System.out.println("请输入员工入职日期,格式为yyyy-MM-dd：");
//        String hireDate=sc.next();//需要转化为日期
        Date hireDate=null;
        try{
            hireDate =sdf.parse(sc.next());
        }catch(ParseException e){
            e.printStackTrace();
        }
        Emp emp5=new Emp(null,deptno,mgr,ename,job,sal,comm,hireDate);
        ed.addEmp(emp5);
    }

//    public Static

}
