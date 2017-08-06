package com.xidian.ml.java.file;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yxb on 2017/6/7.
 */
@Service
public class FileProcessor {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessor.class);


    public String readFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        System.out.println(file);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";

    }



    public String checkFileData(String txtInputPoiIds,String regex) {
        if (StringUtils.isEmpty(txtInputPoiIds)) {
            return "TXT文本内容不能为空!";
        }
        String pattern = txtInputPoiIds.replaceAll(regex, "");
        System.out.println("pattern="+pattern);
        if (!StringUtils.isEmpty(pattern)) {
            boolean isPatternAllNum = true;
            List<Character> list = Lists.newArrayList();
            for (int i = 0; i < pattern.length(); i++) {
                if (!(pattern.charAt(i) >= 48 && pattern.charAt(i) <= 57) && !list.contains(pattern.charAt(i))) {
                    isPatternAllNum = false;
                    list.add(pattern.charAt(i));
                }
            }
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            //若str全部为数字,说明文本存在某个数字过长
            if (isPatternAllNum) {
                return "<br/>文件中含有过长的数字,数字不能超过11位";
            } else {
                return "<br/>文件含有" + list + "等其他字符.<br/>文本内容必须为数字加英文逗号分隔模式";
            }
        }
        return null;
    }


    public String checkFileLongNum(String txtInputPoiIds,String regex){
        if (StringUtils.isEmpty(txtInputPoiIds)) {
            return "TXT文本内容不能为空!";
        }
//        String pattern = txtInputPoiIds.replaceAll(regex, "");
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txtInputPoiIds);
        // 字符串是否与正则表达式相匹配
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            sb.append(","+matcher.group());
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        String content = fileProcessor.readFileFromResources("file/test1.txt");
        String result = fileProcessor.checkFileLongNum(content, "\\d{2,100}");
        System.out.println(result);

    }


}
