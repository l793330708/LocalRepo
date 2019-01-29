package com.lyp.areapartition;

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


public class areaRunner extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setMapperClass(areaMapper.class);
		job.setReducerClass(areaReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
	
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setPartitionerClass(MyPartition.class);
		
		job.setNumReduceTasks(2);
		
		job.setJarByClass(areaRunner.class);
		
		int flag = job.waitForCompletion(true)?1:0;
		return flag;
	}
	public static void main(String[] args) throws Exception {
		int a = ToolRunner.run(new areaRunner(), args);
		
	}

}
