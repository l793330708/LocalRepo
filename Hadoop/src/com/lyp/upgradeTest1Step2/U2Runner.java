package com.lyp.upgradeTest1Step2;

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



public class U2Runner  {
	public static void main(String[] args) throws Exception {
		
		Job job = Job.getInstance();
		
		job.setMapperClass(U2Mapper.class);
		job.setReducerClass(U2Reducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job, new Path("/home/leiyp/Downloads/input/"));
		FileOutputFormat.setOutputPath(job, new Path("/home/leiyp/Downloads/output/"));
		
		job.waitForCompletion(true);
	}
	
}

