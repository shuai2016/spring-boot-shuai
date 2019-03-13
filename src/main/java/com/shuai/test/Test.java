package com.shuai.test;

import com.shuai.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

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
		Calendar c = Calendar.getInstance();
		c.set(2019, 2, 12);
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(DateUtils.getWeek(c.get(Calendar.DAY_OF_WEEK)));

		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		int year = c1.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH);
		System.out.println(year);
		System.out.println(month);

	}
}
