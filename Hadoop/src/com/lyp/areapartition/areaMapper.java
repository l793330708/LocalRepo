package com.lyp.areapartition;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class areaMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
	protected void map(LongWritable key, Text value, Context context) throws java.io.IOException ,InterruptedException 
	{
		String[] fields = value.toString().split("\\s+");
		int count=Integer.parseInt(fields[2]);
		context.write(new Text(fields[0]), new LongWritable(count));
		
	}
}
