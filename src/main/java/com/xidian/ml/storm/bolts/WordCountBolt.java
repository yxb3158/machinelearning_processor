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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yxb on 17/1/8.
 */
public class WordCountBolt extends BaseRichBolt {
    private static final Logger logger = LoggerFactory.getLogger(WordCountBolt.class);

    //保存单词计数
    private Map<String, Long> wordCount = null;

    private OutputCollector outputCollector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
        wordCount = new HashMap<String, Long>();

    }

    @Override
    public void execute(Tuple tuple) {
        String word = tuple.getStringByField("word");
        Long count = wordCount.get(word);
        if (count == null) {
            count = 0L;
        }
        ++count;
        wordCount.put(word, count);
        outputCollector.emit(new Values(word, count));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word", "count"));
    }
}
