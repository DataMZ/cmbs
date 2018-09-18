package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/4 10:10
 * @description:
 */
public class Operator {
    private String id; // 操作员ID
    private String name; // 操作员姓名
    private String pwd; // 操作员密码
    private String isAdmin; // 是否拥有管理员权限Y或者N

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
