package com.xidian.ml.storm.other;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordNormalizer implements IRichBolt {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7158201844283308829L;
	private OutputCollector collector;
	
	
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		this.collector = collector;
	}

	public void execute(Tuple input) {
		String sentence = input.getString(0);
		String words[] = sentence.split(" ");
		for (String word : words) {
			if(!word.isEmpty()){
				word = word.toLowerCase();
				List l = new ArrayList();
				l.add(input);
				collector.emit(l, new Values(word));
			}
		}
		collector.ack(input);
	}

	public void cleanup() {

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
