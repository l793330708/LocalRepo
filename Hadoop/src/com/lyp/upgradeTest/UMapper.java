package com.lyp.upgradeTest;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	
	/**
	 * format 
	 */
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String[] fields = value.toString().split("\\s+");
		for(String str:fields) {
		context.write(new Text(str), new LongWritable(1));
		}
	}
}
