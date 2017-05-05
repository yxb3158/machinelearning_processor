package com.xidian.ml.service;

import com.xidian.ml.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

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
//        for(int i=0;i<10;i++){
        Student user = new Student();
        String name = RandomString(10000);
        user.setName(name);
        System.out.println("name=" + name);
        user.setAge(10000);
        userInfoService.save(user);
//        }
    }

    private String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int maxIndex = str.length();
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(maxIndex);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }


}
