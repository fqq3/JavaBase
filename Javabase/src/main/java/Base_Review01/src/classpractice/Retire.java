package classpractice;

import java.util.Objects;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/20 - 04 - 20 - 9:27
 * @Description: classpractice
 * @version: 1.0
 */
public class Retire extends Person{
    private int retireAge;
    private int retireYear;
    private int penson;
    private String retireCompany;
    public Retire(){

    }
    public Retire(String name, int id, int age, int retireAge, int retireYear, int penson, String retireCompany) {
        super(name, id, age);
        this.retireAge = retireAge;
        this.retireYear = retireYear;
        this.penson = penson;
        this.retireCompany = retireCompany;
    }

    public void setRetireAge(int retireAge) {
        this.retireAge = retireAge;
    }

    public void setRetireYear(int retireYear) {
        this.retireYear = retireYear;
    }

    public void setPenson(int penson) {
        this.penson = penson;
    }

    public void setRetireCompany(String retireCompany) {
        this.retireCompany = retireCompany;
    }

    public int getRetireAge() {
        return retireAge;
    }

    public int getRetireYear() {
        return retireYear;
    }

    public int getPenson() {
        return penson;
    }

    public String getRetireCompany() {
        return retireCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Retire retire)) return false;
        if (!super.equals(o)) return false;
        return retireAge == retire.retireAge && retireYear == retire.retireYear && penson == retire.penson && Objects.equals(retireCompany, retire.retireCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), retireAge, retireYear, penson, retireCompany);
    }
}
