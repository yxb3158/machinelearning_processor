package com.xidian.ml.storm.spouts;

import org.apache.storm.shade.org.jboss.netty.util.internal.ConcurrentHashMap;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by yxb on 17/1/8.
 */
public class SentenceSpout extends BaseRichSpout {
    private ConcurrentHashMap<UUID, Values> pending;
    private SpoutOutputCollector spoutOutputCollector;
    private int index = 0;
    //为了简单,定义一个静态数据模拟不断的数据流产生
    private static final String[] sentences = {
            "The logic for a realtime application is packaged into a Storm topology",
            "A Storm topology is analogous to a MapReduce job",
            "One key difference is that a MapReduce job eventually finishes whereas a topology runs forever",
            " A topology is a graph of spouts and bolts that are connected with stream groupings"
    };

    //向下游输出
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("sentence"));
    }

    //初始化操作
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.spoutOutputCollector = spoutOutputCollector;
        this.pending = new ConcurrentHashMap<UUID, Values>();

    }

    //核心逻辑
    @Override
    public void nextTuple() {
        Values values = new Values(sentences[index]);
        UUID msgId = UUID.randomUUID();
        this.pending.put(msgId, values);
        spoutOutputCollector.emit(values, msgId);
        ++index;
        if (index >= sentences.length) {
            index = 0;
        }
        Utils.sleep(10000);
    }

    @Override
    public void ack(Object msgId) {
        this.pending.remove(msgId);
    }

    @Override
    public void fail(Object msgId) {
        spoutOutputCollector.emit(this.pending.get(msgId), msgId);
    }
}
