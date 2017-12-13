package com.xidian.ml.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Created by yxb on 2017/12/4.
 */
public class IndexService<T> {

    @PostConstruct
    public Map<String, Field> getTFieldMap() {
        Map<String, Field> tFieldMap = Maps.newHashMap();
        //反射方式获取类F的名称(过滤器的基类名称)
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        Field[] fields = new Field[0];
        try {
            fields = clazz.newInstance().getClass().getDeclaredFields();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Field f : fields) {
            f.setAccessible(true);
            String filedName = f.getName();
            //1、获取属性上的指定类型的注解
            Annotation annotation = f.getAnnotation(XmlElement.class);
            //有该类型的注解存在
            String key = filedName;
            if (annotation != null) {
                //强制转化为相应的注解
                XmlElement xmlElement = (XmlElement) annotation;
                //3、获取属性上的指定类型的注解的指定方法
                if (null != xmlElement.name() && !xmlElement.name().equals("##default")) {
                    key = xmlElement.name();
                }
            }
            if (!tFieldMap.containsKey(key)) {
                tFieldMap.put(key, f);
            } else {
                throw new RuntimeException(clazz.getName() + "不能包含相同的注解名或属性名 name:" + key);
            }
        }
        System.out.println("tFieldMap:" + tFieldMap);
        return tFieldMap;

    }

    public void bulkData(T data) {
        Map<String, Field> tFieldMap = getTFieldMap();
        for (Map.Entry<String, Field> entry : tFieldMap.entrySet()) {
            Field field = entry.getValue();
            Object obj = null;
            try {
                obj = field.get(data);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(entry.getKey() + "\t" + JSON.toJSONString(obj) + "\t" + entry.getValue());
        }
    }
}
