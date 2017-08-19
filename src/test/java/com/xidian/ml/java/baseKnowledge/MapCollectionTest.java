package com.xidian.ml.java.baseKnowledge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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









}
