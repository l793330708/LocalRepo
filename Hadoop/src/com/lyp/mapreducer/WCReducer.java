package com.lyp.mapreducer;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
	
	@Override
	protected void reduce(Text text, Iterable<LongWritable> iterable,Context context) throws IOException, InterruptedException {
		long count = 0;
		for (LongWritable writable:iterable) {
			long num = writable.get();
			count+=num;
		}
		context.write(text, new LongWritable(count));
	}
}
