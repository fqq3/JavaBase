package com.fqq.pojo;

/**
 * @author: fqq
 * @Date: 2025/5/29 - 05 - 29 - 22:39
 * @Description: com.fqq.jdbc.entity
 * @version: 1.0
 */
public class Account {
    private Integer aid;
    private String usename;
    private String password;
    private Double money;

    public Account() {
    }

    public Account(Integer aid, String usename, String password, Double money) {
        this.aid = aid;
        this.usename = usename;
        this.password = password;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }


    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
