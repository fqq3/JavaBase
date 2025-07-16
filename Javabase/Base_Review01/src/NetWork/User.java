package NetWork;

import java.io.Serializable;

/**
 * @Auther: fqq
 * @Date: 2025/5/11 - 05 - 11 - 22:43
 * @Description: NetWork
 * @version: 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1294758597393L;
    private String name;
    private String pwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }
    public User(String name,String pwd)
    {
        this.name = name;
        this.pwd = pwd;
    }
}
