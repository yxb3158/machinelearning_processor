package com.xidian.ml.storm.batchDemo.bolt;

import com.google.common.collect.Lists;
import com.xidian.ml.storm.batchDemo.domain.UserInfo;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据性别设置不同的stream_id，分发成两个数据流
 * Created by yxb on 2017/5/4.
 */
public class SexDivisionBolt extends BaseRichBolt {
    private static final Logger logger = LoggerFactory.getLogger(SexDivisionBolt.class);

    private OutputCollector outputCollector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        Map<Integer, List<UserInfo>> sexMap = new HashMap<Integer, List<UserInfo>>();
        List<UserInfo> userInfo = (List<UserInfo>) tuple.getValue(0);
        logger.info("userInfo.size={}", userInfo.size());
        for (UserInfo info : userInfo) {
            List<UserInfo> temp = Lists.newArrayList();
            if (sexMap.containsKey(info.getSex())) {
                temp = sexMap.get(info.getSex());
            }
            temp.add(info);
            sexMap.put(info.getSex(), temp);
        }
        for (Map.Entry<Integer, List<UserInfo>> entry : sexMap.entrySet()) {
            if (entry.getKey().intValue() == 0) {
//                outputCollector.emit(new Values(entry.getValue()));
                outputCollector.emit("sex_female", new Values(entry.getValue()));
            } else if (entry.getKey().intValue() == 1) {
                outputCollector.emit("sex_male", new Values(entry.getValue()));
            }
        }
        outputCollector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
//        outputFieldsDeclarer.declare(new Fields("listInfo"));
        outputFieldsDeclarer.declareStream("sex_male", new Fields("maleInfo"));
        outputFieldsDeclarer.declareStream("sex_female", new Fields("femaleInfo"));
    }
}
