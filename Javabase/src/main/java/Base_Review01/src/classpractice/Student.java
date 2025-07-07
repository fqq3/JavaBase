package classpractice;

import java.util.Objects;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/19 - 04 - 19 - 13:43
 * @Description: classpractice
 * @version: 1.0
 */
public class Student extends Person {
    private int sno;
    private int grade;//年级
    private String major;//专业
    private int classNo;
    private String schoolname;
    public Student(){

    }
    public Student(String name,int  id, int age ){
        super(name, id,age);
    }
    public Student(String name,int  id, int age ,int sno, int grade, String major, int classNo, String schoolname){
        super(name, id,age);
        this.setSno(sno);
        this.setGrade(grade);
        this.setMajor(major);
        this.setClassNo(classNo);
        this.setSchoolname(schoolname);
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
    public void eat(){
        System.out.println("在学校食堂吃饭");
    }
    public void intro(){
        super.introductions();
        System.out.println("我是学生");
    }
    public String toString(){
        return super.toString()+
                "学号："+this.sno+"年级："+this.grade+"专业："+this.major+"班级："+this.classNo+"学校："+this.schoolname;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student student)) return false;
        Student other=(Student)obj;
        return super.equals(obj) && other.sno == this.sno && other.grade == this.grade && other.classNo == this.classNo && Objects.equals(other.major, this.major) && Objects.equals(other.schoolname, this.schoolname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, grade, major, classNo, schoolname);
    }

}