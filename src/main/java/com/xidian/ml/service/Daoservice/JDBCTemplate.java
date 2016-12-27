package com.xidian.ml.service.Daoservice;

import com.xidian.ml.domain.ColumnInfo;
import com.xidian.ml.domain.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by yxb on 16/12/27.
 */
@Component
public class JDBCTemplate {
    private static final Logger logger = LoggerFactory.getLogger(JDBCTemplate.class);

    @Autowired
    private DataSource dataSource;
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection conn;

    /**
     * 获取表的主键
     *
     * @param tableName 表名
     * @return 表中的主键
     * @throws SQLException
     */

    public List getPks(String tableName) throws SQLException {
        conn = dataSource.getConnection();
        List pks = new ArrayList();
        ResultSet rsPks = conn.getMetaData().getPrimaryKeys(null, null, tableName);
        while (rsPks.next()) {
            pks.add(rsPks.getString("COLUMN_NAME"));
        }
        rsPks.close(); //关闭
        return pks;
    }

    /**
     * 获取所有的列信息
     *
     * @param conn      数据库连接
     * @param tableName 表名
     * @return 列的详细信息
     * @throws SQLException
     */
    /**
     *
     * @return
     * @throws SQLException
     */
    public List<ColumnInfo> getColumns(String tableName) throws SQLException {
        conn = dataSource.getConnection();
        List<ColumnInfo> cols = new ArrayList<ColumnInfo>();
        //获取这个表的主键 ，并存储在list中
        Statement stmt = conn.createStatement();
        List pks = getPks(tableName);
        ResultSet rs = stmt.executeQuery("select * from "+tableName+" limit 1");
//        System.out.println("rs="+rs);
        ResultSetMetaData rsCols = rs.getMetaData();
        int columnCount = rsCols.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            ColumnInfo col = new ColumnInfo();
            col.setName(rsCols.getColumnName(i));
            col.setType(rsCols.getColumnTypeName(i));
            col.setIsPk(pks.contains(rsCols.getColumnName(i)) ? 1 : 0);
            col.setLength(rsCols.getColumnDisplaySize(i));
            col.setIsNotNull(rsCols.isNullable(i) == 0 ? 1 : 0);
            cols.add(col);
        }
        rs.close();
        stmt.close();
        return cols;
    }

    /**
     * 获取所有表信息
     * @return
     * @throws SQLException
     */
    public List<TableInfo> collectAllTables() throws SQLException {
        conn = dataSource.getConnection();
//        System.out.println("conn="+conn.getMetaData().getURL());
        DatabaseMetaData dmd = conn.getMetaData();
//        System.out.println("dmd="+ dmd);
        //获取库中的所有表
        ResultSet rsTables = dmd.getTables(null, null, null, new String[]{"TABLE"});
//        System.out.println("rsTables="+rsTables);
        List<TableInfo> tables = new ArrayList<TableInfo>();
        //将表存到list中
        while (rsTables.next()) {
            TableInfo tb = new TableInfo();
//            tb.setSpace(db);
            //获取表名称
            String tbName = rsTables.getString("TABLE_NAME");
            tb.setName(tbName);
            //获取表中的字段及其类型
            List<ColumnInfo> cols = getColumns(tbName);
            tb.setColumnsInfo(cols);
            tables.add(tb);
        }
        rsTables.close();

        return tables;           //connection未关闭
    }

}
