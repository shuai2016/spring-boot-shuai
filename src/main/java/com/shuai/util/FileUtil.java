package com.shuai.util;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * FileUtil
 *
 * @author shuai
 * @date 2018/12/27
 */
public class FileUtil {

	public static String readFile(String Path) {
		BufferedReader reader = null;
		String lastStr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				lastStr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lastStr;
	}

	public static void writeFile(Object o, String Path) {
		String strData = JSON.toJSONString(o);
		System.out.println(strData);
		File file = new File(Path);
		Writer writer = null;
		try {
			file.createNewFile();
			writer = new FileWriter(file);
			writer.write(strData);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}