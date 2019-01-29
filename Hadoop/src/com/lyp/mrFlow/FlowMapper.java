package com.lyp.mrFlow;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		 //leileilei 1354 22
		String[] fields = value.toString().split(" ");
		String name = fields[0];
		String phoneNB = fields[1];
		int count = Integer.parseInt(fields[2]);
		context.write(new Text(name),new FlowBean(name,phoneNB,count));
	}
}	
