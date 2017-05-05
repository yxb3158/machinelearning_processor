package com.xidian.ml.storm.batchDemo.domain;

/**
 * Created by yxb on 2017/5/4.
 */
public class UserInfo {
    private Integer id;
    private Integer age;
    private String name;
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
