package com.lyp.upgradeTest1Step2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class U2Reducer extends Reducer<Text, Text, Text, Text>{
	
	@Override
	protected void reduce(Text text, Iterable<Text> values,Context context) throws IOException, InterruptedException {
			StringBuffer str = new StringBuffer();
		for(Text lc:values) {
			str.append(lc.toString());
		}
		context.write(text, new Text(str.toString()));
	}
	

}
