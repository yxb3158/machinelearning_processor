package com.xidian.ml.table;

import com.xidian.ml.domain.TableInfo;
import com.xidian.ml.service.Daoservice.JDBCTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yxb on 16/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class JDBCTemplateTest {
    @Autowired
    private JDBCTemplate jdbc;

    @Test
    public void test() throws SQLException {
//        List<ColumnInfo> result = jdbc.getColumns("student");
//        System.out.println(result);
        List<TableInfo> allTables = jdbc.collectAllTables();
        System.out.println(allTables);

    }

}
