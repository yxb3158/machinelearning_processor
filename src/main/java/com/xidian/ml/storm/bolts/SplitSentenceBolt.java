package com.xidian.ml.storm.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by yxb on 17/1/8.
 */
public class SplitSentenceBolt extends BaseRichBolt {
    private static final Logger logger = LoggerFactory.getLogger(SplitSentenceBolt.class);

    private OutputCollector outputCollector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;

    }

    @Override
    public void execute(Tuple tuple) {
//        String sentence = tuple.getStringByField("sentence");
        String sentence = (String) tuple.getValue(0);
        String[] words = sentence.split(" ");
        for (String word : words) {
            outputCollector.emit(tuple, new Values(word));
        }
        outputCollector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
