package myreflect;

import java.io.Serializable;

/**
 * @author: fqq
 * @Date: 2025/5/15 - 05 - 15 - 19:14
 * @Description: myreflect
 * @version: 1.0
 */
public class PersonT implements Serializable {
    private int age;
    public String name;
    private void eat(){
        System.out.println("PersonT----eat()");
    }
    private void sleep(){
        System.out.println("PersonT----sleep()");
    }

}
