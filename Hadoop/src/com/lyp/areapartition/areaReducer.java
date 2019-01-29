package com.lyp.areapartition;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class areaReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
	@Override
	//values = {leileilei,{1,1,1,1,1}}
	protected void reduce(Text text, Iterable<LongWritable> values,
			Context context) throws IOException, InterruptedException {
		long value = 0;
		for(LongWritable writable:values) {
			 value += writable.get();
		}
		context.write(text, new LongWritable(value));
	}
}
