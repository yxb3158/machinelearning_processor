package com.xidian.ml.domain;

/**
 * Created by yxb on 16/12/27.
 */
public class ColumnInfo {
    /**
     * 列名称(字段名称)
     */
    private String name;
    /**
     * 是否主键
     */
    private  int isPk;
    /**
     * 默认值
     */
    private String value;
    /**
     * 是否为空
     */
    private int isNotNull;
    /**
     * 数据类型
     */
    private String type;
    /**
     * 数据长度
     */
    private int length;
    /**
     * 代码类型
     */
    private int codeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsPk() {
        return isPk;
    }

    public void setIsPk(int isPk) {
        this.isPk = isPk;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIsNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(int isNotNull) {
        this.isNotNull = isNotNull;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "name='" + name + '\'' +
                ", isPk=" + isPk +
                ", value='" + value + '\'' +
                ", isNotNull=" + isNotNull +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", codeType=" + codeType +
                '}';
    }
}
