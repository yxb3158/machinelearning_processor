package com.xidian.ml.storm.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//@SuppressWarnings("serial")
public class WordCounter implements IRichBolt {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7417828517395364563L;
	private Integer id;
	private String name;
	private Map<String, Integer> counters;
	private OutputCollector collector;
	private Logger logger = LoggerFactory.getLogger(WordCounter.class);
	
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		this.counters = new HashMap<String, Integer>();
		this.collector = collector;
		this.name = context.getThisComponentId();
		this.id = context.getThisTaskId();
	}

	public void execute(Tuple input) {
		String str = input.getString(0);
		if(counters.containsKey(str)){
			Integer c = counters.get(str)+1;
			counters.put(str, c);
		}else{
			counters.put(str, 1);
		}
		collector.ack(input);
	}

	public void cleanup() {
		logger.info("-- Word Counter ["+name+"-"+id+"] --");
		for(Entry<String, Integer> entry:counters.entrySet()){
			logger.info(entry.getKey()+": "+entry.getValue());
		}
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub

	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
