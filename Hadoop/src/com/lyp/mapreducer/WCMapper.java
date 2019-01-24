package com.lyp.mapreducer;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//Text为封装的String类,LongWritable为Long类型封装
public class WCMapper extends Mapper<LongWritable, Text, Text,LongWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//得到每一行的单词
		String[] values = value.toString().split(" ");
		//遍历
		for (String word:values) {
			//输出
			context.write(new Text(word), new LongWritable(1));
		}
	}
}	
