package com.xidian.ml.domain;

import java.util.List;

/**
 * Created by yxb on 16/12/27.
 */
public class TableInfo {
    /**
     * 存储空间(库名)
     */
    private String space;
    /**
     * 表名称
     */
    private String name;

    /**
     * 表中的列
     */
    private List<ColumnInfo> columnsInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public List<ColumnInfo> getColumnsInfo() {
        return columnsInfo;
    }

    public void setColumnsInfo(List<ColumnInfo> columnsInfo) {
        this.columnsInfo = columnsInfo;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "space='" + space + '\'' +
                ", name='" + name + '\'' +
                ", columnsInfo=" + columnsInfo +
                '}';
    }
}
