package com.lei.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 切割一个或多个空白符的字符串
 * @author Administrator
 *
 */
public class TestCode2 {

	public static void main(String[] args) throws Exception {
		String str = "Hello-->1.txt	3";
		String[] fields = str.split("-->");
		for(String str1:fields) {
			System.out.println(str1);
		}
				
	}
}
