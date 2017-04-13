package com.xidian.ml.storm.bolts;

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
import java.util.Set;

/**
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
        logger.info("ReportBolt==================="+ JSON.toJSONString(tuple));
        logger.info("-----------------begin at"+System.currentTimeMillis()+"------------------");
        logger.info("@report-bolt@: " + word + " ---> " + count);
//        counts.put(word, count);
//        //打印更新后的结果
//        printReport();

    }

    private void printReport() {
        logger.info("--------------------------begin-------------------");
        Set<String> words = counts.keySet();
        for (String word : words) {
            logger.info("@report-bolt@: " + word + " ---> " + counts.get(word));
        }
        logger.info("--------------------------end---------------------");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
