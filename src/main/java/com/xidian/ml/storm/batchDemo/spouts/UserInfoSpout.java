package com.xidian.ml.storm.batchDemo.spouts;

import com.google.common.collect.Lists;
import com.xidian.ml.storm.batchDemo.domain.UserInfo;
import org.apache.storm.shade.org.jboss.netty.util.internal.ConcurrentHashMap;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by yxb on 17/1/8.
 */
public class UserInfoSpout extends BaseRichSpout {
    private ConcurrentHashMap<UUID, Values> pending;
    private SpoutOutputCollector spoutOutputCollector;
    //为了简单,定义一个静态数据模拟不断的数据流产生
    private long lastTime;
    private static final List<UserInfo> userinfo = Lists.newArrayList();

    private void test() {
        userinfo.clear();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();//默认构造方法
            UserInfo user = new UserInfo();
            user.setId(i);
            user.setAge(20 + random.nextInt(10));
            user.setSex(random.nextInt(1000) % 2);
            user.setName("user_" + i);
            userinfo.add(user);
        }
    }

    //向下游输出
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("user_info"));
//        outputFieldsDeclarer.declareStream(,new Fields("user_info"));
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
        // 每count条tuple批量提交一次，或者每个1秒钟提交一次
        test();
        Values values = new Values(userinfo);
        UUID msgId = UUID.randomUUID();
        this.pending.put(msgId, values);
        spoutOutputCollector.emit(values, msgId);
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
