package com.xidian.ml.storm.spouts;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

//@SuppressWarnings("serial")
public class WordReader implements IRichSpout{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7480983775366602804L;
	private SpoutOutputCollector collector;
	private FileReader fileReader;
	private boolean completed = false;
	private TopologyContext context;
	private Logger logger = LoggerFactory.getLogger(WordReader.class);

	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		try {
			this.context = context;
			this.fileReader = new FileReader(conf.get("wordsFile").toString());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error reading file["+conf.get("wordsFile")+"]");
		}
		this.collector = collector;
	}

	public void close() {		
	}

	public void activate() {
		
	}

	public void deactivate() {
		
	}

	public void nextTuple() {
		logger.info("nextTuple is called!");
		if(completed){
			try {
				Thread.sleep(1000);
//				Thread.yield();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		String str;
		BufferedReader reader = new BufferedReader(fileReader);
		try {
			while((str = reader.readLine()) != null){
				collector.emit(new Values(str), str);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error reading tuple",e);
		} finally{
			completed = true;
		}
		
	}

	public void ack(Object msgId) {
		System.out.println("OK: "+msgId);
	}

	public void fail(Object msgId) {
		System.out.println("FAIL: "+msgId);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("line"));
	}

	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
