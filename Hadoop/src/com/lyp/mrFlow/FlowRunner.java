package com.lyp.mrFlow;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FlowRunner  {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(FlowRunner.class);

		job.setMapperClass(FlowMapper.class);
		job.setReducerClass(FlowReducer.class);

	

		job.setOutputKeyClass(Text.class); 
		job.setOutputValueClass(LongWritable.class);
		
		job.setMapOutputKeyClass(Text.class); 
		job.setMapOutputValueClass(FlowBean.class);
		
		FileInputFormat.setInputPaths(job, new Path("~/Downloads/1.txt"));
		FileOutputFormat.setOutputPath(job, new Path("~/Downloads/output2"));
		
		job.waitForCompletion(true);
		
		//ToolRunner.run(new RRuner(), args); 下方方法的执行
		
		}
	public static class RRuner extends Configured implements Tool{
		
		@Override
		public int run(String[] args) throws Exception {
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf);

			job.setJarByClass(FlowRunner.class);

			job.setMapperClass(FlowMapper.class);
			job.setReducerClass(FlowReducer.class);

			

			job.setOutputKeyClass(Text.class); 
			job.setOutputValueClass(LongWritable.class);
			
			job.setMapOutputKeyClass(Text.class); 
			job.setMapOutputValueClass(FlowBean.class);
			
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			int flag = (job.waitForCompletion(true))?0:1;
			return flag;
		}
		
	}
}
