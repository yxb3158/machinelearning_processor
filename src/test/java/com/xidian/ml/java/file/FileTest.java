package com.xidian.ml.java.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 2017/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class FileTest {
    @Autowired
    private FileProcessor fileProcessor;

    @Test
    public void test1(){
        String content = fileProcessor.readFileFromResources("file/test1.txt");
        System.out.println(content);
    }



}
