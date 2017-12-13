package com.xidian.ml.java.baseKnowledge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by yxb on 2017/8/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class MapCollectionTest {

    @Test
    public void test1() {
        Map<Long, String> streamingPoiDataMap = Maps.newHashMap();
        streamingPoiDataMap.put(1l, "asdfg");
        streamingPoiDataMap.put(2l, "12345");
        streamingPoiDataMap.put(3l, "werty");
        Set<Long> poiIds = Sets.newHashSet();
        Set<Long> poiIds1 = streamingPoiDataMap.keySet();
        poiIds.addAll(poiIds1);
        System.out.println(poiIds);
        Map<Long, String> streamingPoiDataMap1 = Maps.newHashMap();
        streamingPoiDataMap1.put(4l, "asdfg");
        streamingPoiDataMap1.put(5l, "12345");
        streamingPoiDataMap1.put(3l, "werty");
        streamingPoiDataMap1.put(7l, "werty");
        System.out.println(streamingPoiDataMap1.keySet());
        poiIds.addAll(streamingPoiDataMap1.keySet());
        System.out.println(poiIds);
    }


    @Test
    public void test2() {
        Map<Integer, Set<Integer>> map1 = Maps.newHashMap();
        map1.put(1, null);
        System.out.println(map1);
    }

    @Test
    public void test3() {
        Map<Long, String> streamingPoiDataMap = Maps.newHashMap();
        streamingPoiDataMap.put(1l, "asdfg");
        streamingPoiDataMap.put(2l, "12345");
        streamingPoiDataMap.put(3l, "werty");
        streamingPoiDataMap.put(4l, "werty");
        streamingPoiDataMap.put(5l, "werty");
        streamingPoiDataMap.put(6l, "werty");

        System.out.println("wse1=" + streamingPoiDataMap);
        Iterator<Long> it1 = streamingPoiDataMap.keySet().iterator();
        while (it1.hasNext()) {
            Long key = it1.next();
            System.out.println(key + " : " + streamingPoiDataMap.get(key));
            if (streamingPoiDataMap.get(key).equals("werty")) {
                it1.remove();
            }
        }

        System.out.println("wse2=" + streamingPoiDataMap);

        Iterator<Map.Entry<Long, String>> it3 = streamingPoiDataMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<Long, String> entry = it3.next();
            Long poiId = entry.getKey();

            System.out.println(entry.getKey() + " : " + entry.getValue());
            System.out.println(poiId + " : " + streamingPoiDataMap.get(poiId));
            if (streamingPoiDataMap.get(poiId).equals("werty")) {
                it3.remove();
            }
        }

        System.out.println("wse3=" + streamingPoiDataMap);

    }

}
