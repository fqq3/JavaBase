package classpractice;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/19 - 04 - 19 - 23:26
 * @Description: classpractice
 * @version: 1.0
 */
public class Worker extends Person{
    int salary;
    int workAge;
    String job;
    String company;

    public Worker() {
    }
    public Worker(String name, int id, int age, int salary, int workAge, String job, String company) {
        super(name, id, age);
        this.salary = salary;
        this.workAge = workAge;
        this.job = job;
        this.company = company;
    }

}
