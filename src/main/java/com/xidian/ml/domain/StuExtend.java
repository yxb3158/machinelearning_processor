package com.xidian.ml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yxb on 2017/12/5.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StuExtend {
    private String address;
    @XmlAttribute(name = "stu_tel")
    private Long telPhoneNum;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelPhoneNum() {
        return telPhoneNum;
    }

    public void setTelPhoneNum(Long telPhoneNum) {
        this.telPhoneNum = telPhoneNum;
    }


    @Override
    public String toString() {
        return "StuExtend{" +
                "address='" + address + '\'' +
                ", telPhoneNum=" + telPhoneNum +
                '}';
    }
}
