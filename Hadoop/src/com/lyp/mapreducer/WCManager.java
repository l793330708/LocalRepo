package com.lyp.mapreducer;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCManager {

	public static void main(String[] args) throws Exception {
		Job job = Job.getInstance(new Configuration());
		
		
		//设置Mapper类
		job.setMapperClass(WCMapper.class);
		//设置Reducer类
		job.setReducerClass(WCReducer.class);
		//设置输出Key类型
		job.setOutputKeyClass(Text.class);
		//设置输出value类型
		job.setOutputValueClass(LongWritable.class);
		//设置原始文件存放路径
		FileInputFormat.setInputPaths(job, new Path("/Downloads/1.txt"));
		FileOutputFormat.setOutputPath(job, new Path("/Downloads/output2"));
		//设置输出
		job.setJarByClass(WCManager.class);
		
		//输出提示信息
		job.waitForCompletion(true);
	}

}
