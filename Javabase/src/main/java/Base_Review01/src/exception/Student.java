package exception;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/20 - 04 - 20 - 23:24
 * @Description: exception
 * @version: 1.0
 */
public class Student {
    private int age;
    private String name;
    private String sex;

    public Student() {
    }

    public Student(int age, String name, String sex) {
        this.age = age;
        this.name = name;

        try {
            this.setSex(sex);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        if(sex.equals("男")||sex.equals("女")){
            this.sex = sex;
        }else{
            System.out.println("错");
//            try {
//                throw new RuntimeException();
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
            throw new MyException("出错了？？？？？？？？？？？？？");
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
//    public void
}
