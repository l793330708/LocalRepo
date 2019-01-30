package com.lyp.upgradeTest;

import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;



public class URunner  {
	public static void main(String[] args) throws Exception {
		
		Job job = Job.getInstance();
		
		job.setMapperClass(UMapper.class);
		job.setReducerClass(UReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("/home/leiyp/Downloads/input/"));
		FileOutputFormat.setOutputPath(job, new Path("/home/leiyp/Downloads/output/"));
		
		job.waitForCompletion(true);
	}
	
}

