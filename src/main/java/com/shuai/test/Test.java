package com.shuai.test;

import java.util.Calendar;

/**
 * Test
 *
 * @author shuai
 * @date 2019/3/11
 */
public class Test {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 3, 0);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
	}
}
