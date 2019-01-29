package com.lyp.mrFlow;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowReducer extends Reducer<Text, FlowBean, Text, LongWritable> {
	
	/**
	 *  (Text,{flowbean,flowbean,flowbean,flowbean})
	 */
	@Override
	protected void reduce(Text text, Iterable<FlowBean> values,Context context)
			throws IOException, InterruptedException {
		int countM = 0;
		for(FlowBean bean:values) {
			countM += bean.getCousumeM();
		}
		context.write(text,new LongWritable(countM));
	}

}
