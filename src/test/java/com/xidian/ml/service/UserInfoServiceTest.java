package com.xidian.ml.service;

import com.xidian.ml.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 16/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class UserInfoServiceTest {
    private static final Logger logger = LogManager.getLogger(UserInfoServiceTest.class);


    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getUserInfoTest() {
        Student result = userInfoService.getUserInfo(3);
        logger.info("result=" + result);
        System.out.println(result);

    }

    @Test
    public void saveTest() {
        Student user = new Student();
        user.setName("haha");
        user.setAge(123456);
        userInfoService.save(user);
    }


}
