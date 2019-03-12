package com.shuai.utils;

/**
 * DateUtils
 *
 * @author shuai
 * @date 2019/3/12
 */
public class DateUtils {
	public static String getWeek(int week){
		String weekStr = "";
		switch (week) {
			case 1:
				weekStr = "星期日";
				break;
			case 2:
				weekStr = "星期一";
				break;
			case 3:
				weekStr = "星期二";
				break;
			case 4:
				weekStr = "星期三";
				break;
			case 5:
				weekStr = "星期四";
				break;
			case 6:
				weekStr = "星期五";
				break;
			case 7:
				weekStr = "星期六";
				break;
			default:
				break;
		}
		return weekStr;
	}
}
