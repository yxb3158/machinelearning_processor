package com.xidian.ml.storm.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.security.InvalidParameterException;

public class AdderBolt extends BaseBasicBolt {
	private OutputCollector collector;

	public void execute(Tuple input, BasicOutputCollector collector) {
		System.out.println("输入参数的个数："+input.size());
		String[] numbers = input.getString(1).split("\\+");
		Integer added = 0;

		try {
			if (numbers.length < 2) {
				throw new InvalidParameterException(
						"Should be at least 2 numbers");
			}
			for (String num : numbers) {
				added += Integer.parseInt(num);
			}
		} catch (Exception e) {
			collector.emit(new Values(input.getValue(0), "NULL"));
		}
		collector.emit(new Values(input.getValue(0),added));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("id", "result"));
	}

}
