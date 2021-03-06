package com.xidian.ml.storm.wordCountDemo.bolts;

import com.alibaba.fastjson.JSON;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 经过wordcount计数的单词个数需要统一打印报表
 * Created by yxb on 17/1/8.
 */
public class ReportBolt extends BaseRichBolt {
    private static final Logger logger = LoggerFactory.getLogger(ReportBolt.class);
    private Map<String, Long> counts = null;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        counts = new HashMap<String, Long>();

    }


    @Override
    public void execute(Tuple tuple) {
        String word = tuple.getStringByField("word");
        Long count = tuple.getLongByField("count");
        logger.info("ReportMaleBolt==================="+ JSON.toJSONString(tuple));
        logger.info("-----------------begin at"+System.currentTimeMillis()+"------------------");
        logger.info("@report-bolt@: " + word + " ---> " + count);
//        counts.put(word, count);
//        //打印更新后的结果
//        printReport();

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
