package com.xidian.ml.java.baseKnowledge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yxb on 2017/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class JsonTest {
    @Test
    public void test1() {
        String str="{\"trace_id\":\"{\\\\\"src_page\\\\\":\\\\\"p_activity\\\\\",\\\\\"action\\\\\":\\\\\"click\\\\\",\\\\\"src_page_object_id\\\\\":\\\\\"24461\\\\\",\\\\\"src_block\\\\\":\\\\\"b_poilist\\\\\",\\\\\"tgt_block\\\\\":\\\\\"\\\\\",\\\\\"src_item_id\\\\\":2619225,\\\\\"src_item_index\\\\\":2,\\\\\"src_item_type\\\\\":1,\\\\\"tgt_page\\\\\":\\\\\"p_poi\\\\\",\\\\\"req_time\\\\\":1510543837673,\\\\\"extra\\\\\":{\\\\\"activity_id\\\\\":\\\\\"24461\\\\\",\\\\\"ys\\\\\":\\\\\"2\\\\\",\\\\\"ys_id\\\\\":\\\\\"23286\\\\\"}}\",\"poi_id\":\"2619225\",\"custom\":{\"poiname\":\"果块儿鲜果切（望京店）\",\"restaurant_id\":\"2619225\",\"yy_log\":\"2_2619225_1_00000_00000_24461_2_23286\",\"longitude\":\"116487501\",\"latitude\":\"40008268\",\"container_type\":\"0\"}}";
        str=str.replaceAll("\\\\","");
        System.out.println("str="+str);

        JSONObject eventAttrJson = JSONObject.parseObject(str);

        String extra = eventAttrJson.getString("trace_id");
        System.out.println("esxcvgh"+extra);
//        String custom = eventAttrJson.getString("custom");
//        JSONObject customJson = JSONObject.parseObject(custom);



    }

    @Test
    public void test2() {
        List<String> list = Lists.newArrayList("1", "2", "3", "asdfg", "qwer");
        System.out.println("esxcvgh="+ JSON.toJSONString(list));
        String json = JSON.toJSONString(list);
        List<String> ll2 = JSONObject.parseArray(json, String.class);
        System.out.println("esxcvgh2="+ ll2);



    }

    @Test
    public void test3() {
        List<Integer> list = Lists.newArrayList(1,2,3,4,56,78,9,0);
        String listJson = JSON.toJSONString(list);
        System.out.println(listJson);
        HashMap<String, String> map = Maps.newHashMap();
        map.put("qwertyui1","111");
        map.put("qwertyui2","222");
        map.put("qwertyui3","333");
        map.put("qwertyui4","444");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);




    }

}





