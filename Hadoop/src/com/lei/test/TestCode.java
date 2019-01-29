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
public class TestCode {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String pathname = scanner.nextLine();
		File file = new File(pathname);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader reader2 = new BufferedReader(reader);
		String txt = null;
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		while((txt=reader2.readLine())!=null) {
			arrayList.add(txt.split("\\s+"));
		}
		for(String[] strs:arrayList) {
			System.out.println(strs[0]+"\t"+strs[1]+"\t"+strs[2]);
		}
		reader2.close();
		reader.close();
	}

}
