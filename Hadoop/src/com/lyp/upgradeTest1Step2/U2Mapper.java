package com.lyp.upgradeTest1Step2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class U2Mapper extends Mapper<LongWritable, Text, Text, Text> {
	
	/**
	 * format 
	 */
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String[] fields = value.toString().split("-");
		FileSplit split = (FileSplit) context.getInputSplit();
		String filename = split.getPath().getName();
		context.write(new Text(fields[0]), new Text(fields[1]));
	}
}
