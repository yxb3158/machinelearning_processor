package com.xidian.ml.domain;

/**
 * Created by yxb on 16/12/23.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "stu_age")
    private int age;
//   @XmlElements({
//            @XmlElement(name = "stu_extend", type = StuExtend.class),
//    })
    @XmlAttribute(name = "stu_extend")
    private StuExtend stuExtend;

    @XmlElementWrapper(name = "stu_other")
    private List<String> others;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StuExtend getStuExtend() {
        return stuExtend;
    }

    public void setStuExtend(StuExtend stuExtend) {
        this.stuExtend = stuExtend;
    }

    public List<String> getOthers() {
        return others;
    }

    public void setOthers(List<String> others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
