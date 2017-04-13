package com.xidian.ml.storm;

import com.xidian.ml.storm.other.AdderBolt;
import com.xidian.ml.storm.other.WordCounter;
import com.xidian.ml.storm.other.WordNormalizer;
import com.xidian.ml.storm.other.WordReader;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.junit.Test;

/**
 * Created by yxb on 17/1/8.
 */
public class DRPCTopologyTest {

    @Test
    public void addTest(){
        // Create the local drpc client/server
        LocalDRPC drpc = new LocalDRPC();

        // Create the drpc topology and specify the function name.
        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("add");
        builder.addBolt(new AdderBolt());

        Config conf = new Config();
        conf.setDebug(true);

        // Create cluster and submit the topology
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("drpc-adder-topology", conf,
                builder.createLocalTopology(drpc));

        //Test the topology
        String result = drpc.execute("add", "1+2+3+4+5");
        System.out.println("####### result ---> "+result+" #######");

        cluster.shutdown();
        drpc.shutdown();
    }

    @Test
    public void topologyTest() throws InterruptedException {
        		/*
		 * Topology definition
		 */
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("word-reader", new WordReader());
        builder.setBolt("word-normalizer", new WordNormalizer())
                .shuffleGrouping("word-reader");
//		builder.setBolt("word-counter", new WordCounter(),3).shuffleGrouping("word-normalizer");
        builder.setBolt("word-counter", new WordCounter(),3).fieldsGrouping(("word-normalizer"), new Fields("word"));

		/*
		 * Configuration
		 */
        Config conf = new Config();
        conf.put("wordsFile", "src/main/resources/word.txt");
        conf.setDebug(true);


		/*
		 * Topology run local cluster
		 */
        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("Getting-Started-Topologie", conf, builder.createTopology());
        Thread.sleep(5000);
        cluster.shutdown();

        //remote cluster
//		conf.setMaxTaskParallelism(3);
//		StormSubmitter.submitTopology("Getting-Started-Topologie", conf, builder.createTopology());
    }
}
