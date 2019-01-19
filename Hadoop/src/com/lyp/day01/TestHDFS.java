package com.lyp.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class TestHDFS {
	FileSystem fs = null;
	{
		Configuration conf = new Configuration();
		 try {
			fs = FileSystem.get(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  测试上传
	 * @throws IOException 
	 */
	@Test	
	public void upload() throws IOException {
		
		Path src = new Path("D:/1.txt");
		Path dst = new Path("hdfs://leiyp:9000/");
		fs.copyFromLocalFile(src, dst);
		
		
	}
	/**
	 * 测试下载
	 */
	@Test
	public void download() {
		
	} 
	/**
	 * 列出目录
	 */
	@Test
	public void list() {
		
	}
	/**
	 * 移动目录
	 */
	
	/**
	 * 删除目录
	 */
}
