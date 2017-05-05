package com.xidian.ml.storm.batchDemo;

import com.xidian.ml.storm.batchDemo.bolt.ReportFemaleBolt;
import com.xidian.ml.storm.batchDemo.bolt.ReportMaleBolt;
import com.xidian.ml.storm.batchDemo.bolt.SexDivisionBolt;
import com.xidian.ml.storm.batchDemo.spouts.UserInfoSpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yxb on 2017/5/4.
 */
public class BatchTopology {
    private static final Logger log = LoggerFactory.getLogger(BatchTopology.class);
    //各个组件名字的唯一标识
    private final static String USERINFO_SPOUT_ID = "userinfo-spout";
    private final static String SEX_DIV_BOLT_ID = "sex-div-bolt";
    private final static String REPORT_MALE_BOLT_ID = "report-bolt-male";
    private final static String REPORT_FEMALE_BOLT_ID = "report-bolt-female";

    //拓扑名称
    private final static String BATCH_TOPOLOGY_NAME = "batch-topology";

    public static void main(String[] args) {

        log.info(".........begining.......");
        //各个组件的实例
        UserInfoSpout spout = new UserInfoSpout();
        SexDivisionBolt sexDivBolt = new SexDivisionBolt();
        ReportMaleBolt reportMaleBolt = new ReportMaleBolt();
        ReportFemaleBolt reportFemaleBolt = new ReportFemaleBolt();


        //构建一个拓扑Builder
        TopologyBuilder topologyBuilder = new TopologyBuilder();

        //配置第一个组件sentenceSpout
        topologyBuilder.setSpout(USERINFO_SPOUT_ID, spout, 1);
        topologyBuilder.setBolt(SEX_DIV_BOLT_ID, sexDivBolt, 1).shuffleGrouping(USERINFO_SPOUT_ID);
        topologyBuilder.setBolt(REPORT_MALE_BOLT_ID, reportMaleBolt, 1).shuffleGrouping(SEX_DIV_BOLT_ID, "sex_male");
        topologyBuilder.setBolt(REPORT_FEMALE_BOLT_ID, reportFemaleBolt, 1).shuffleGrouping(SEX_DIV_BOLT_ID, "sex_female");
        Config config = new Config();
        //建立本地集群,利用LocalCluster,storm在程序启动时会在本地自动建立一个集群,不需要用户自己再搭建,方便本地开发和debug
        LocalCluster cluster = new LocalCluster();

        //创建拓扑实例,并提交到本地集群进行运行
        cluster.submitTopology(BATCH_TOPOLOGY_NAME, config, topologyBuilder.createTopology());
//        cluster.killTopology(BATCH_TOPOLOGY_NAME);
//        cluster.shutdown();
    }
}
