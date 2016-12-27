package com.xidian.ml.service;

import com.xidian.ml.dao.StudentDao;
import com.xidian.ml.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yxb on 16/12/23.
 */
@Service
//@ManagedData
public class UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private StudentDao studentDao;

    public Student getUserInfo(long id){
        logger.info("getUserInfo(wm_poi_id:{})",id);
        Student result = studentDao.getUserInfoById(id);
        return result;
    }

    public void save(Student user){
        long x = studentDao.insert(user);
        System.out.println(x);
    }


}
