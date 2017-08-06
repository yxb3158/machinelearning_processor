package com.xidian.ml.storm.batchDemo.bolt;

import com.alibaba.fastjson.JSON;
import com.xidian.ml.storm.batchDemo.domain.UserInfo;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yxb on 17/1/8.
 */
public class ReportMaleBolt extends BaseRichBolt {
    private static final Logger logger = LoggerFactory.getLogger(ReportMaleBolt.class);


    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {

    }

    @Override
    public void execute(Tuple tuple) {
        logger.info("wsedfghjsdfghj===================" + JSON.toJSONString(tuple));
        List<UserInfo> maleInfo = (List<UserInfo>) tuple.getValue(0);
        logger.info("ReportMaleBolt===================" + JSON.toJSONString(tuple));
        logger.info("-----------------begin at" + System.currentTimeMillis() + "------------------");
        logger.info("@report-maleInfo@: ----size ----> " + maleInfo.size());
    }
}