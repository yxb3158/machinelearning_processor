package com.xidian.ml.dao;

import com.xidian.ml.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yxb on 16/12/23.
 */
@Component
public interface StudentDao {
    static final Logger loggr = LoggerFactory.getLogger(StudentDao.class);
    public static final String SELECT_KEY = "id,name,age";
    public static final String INSERT_KEY = "name,age";
    public static final String INSERT_VALUES = "#{name},#{age}";


    @Insert("insert ignore into student (" + INSERT_KEY + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insert(Student user);

    @Select("select "+SELECT_KEY+" from student where id=#{id}")
    Student getUserInfoById(@Param("id") Long id);
}
