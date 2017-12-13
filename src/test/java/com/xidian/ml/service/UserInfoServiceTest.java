package com.xidian.ml.service;

import com.google.common.collect.Lists;
import com.xidian.ml.domain.StuExtend;
import com.xidian.ml.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.annotation.XmlElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

    @Test
    public void StuTest() {
        Class<Student> xx = Student.class;

        Field[] fields = Student.class.getDeclaredFields();

        for (Field f : fields) {
            String filedName = f.getName();
            System.out.println("属性名称:【" + filedName + "】");
            //1、获取属性上的指定类型的注解
            Annotation annotation = f.getAnnotation(XmlElement.class);
            System.out.println(annotation);
            //有该类型的注解存在
             if (annotation != null) {
                //强制转化为相应的注解
                XmlElement xmlElement = (XmlElement) annotation;
                //3、获取属性上的指定类型的注解的指定方法
                //具体是不是默认值可以去查看源代码
                if (xmlElement.name().equals("##default")) {
                    System.out.println("属性【" + filedName + "】注解使用的name是默认值: " + f.getName());
                } else {
                    System.out.println("属性【" + filedName + "】注解使用的name是自定义的值: " + xmlElement.name());
                }
            }

        }
    }

    @Test
    public void StuTest2() {
        StuExtend stuExtend=new StuExtend();
        stuExtend.setAddress("望京科创大厦");
        stuExtend.setTelPhoneNum(18519504579l);
        ArrayList<String> other = Lists.newArrayList("1", "2", "sdf", "245");
        Student student=new Student();
        student.setId(1);
        student.setAge(20);
        student.setName("yxb");
        student.setStuExtend(stuExtend);
        student.setOthers(other);
        StudentIndexService indexService =new StudentIndexService();
        indexService.bulkData(student);
    }
}
