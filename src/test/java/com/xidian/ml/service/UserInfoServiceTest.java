package com.xidian.ml.service;

import com.xidian.ml.domain.Student;
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

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getUserInfoTest() {
        Student result = userInfoService.getUserInfo(2);
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
