package com.zjwm.wyx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

	/**
	 * 时间戳转换成日期格式字符串
	 * 
	 * @param seconds   精确到秒的字符串
	 * @return 日期格式字符串
	 */
	public static String timeStampToDate(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 获取过去或者未来 任意天内的日期数组
	 * 
	 * @param intervals intervals天内
	 * @return 日期数组
	 */
	public static List<String> test(int intervals) {
		List<String> pastDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			pastDaysList.add(getPastDate(i));
		}
		return pastDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 * 
	 * @param past 几天
	 * @return 日期
	 */
	private static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
	}

    /**
     * 两段日期的中间日期数据(day)
     * @param start 开始日期
     * @param end 结束日期
     * @return 之间的日期
     */

    private static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.DAY_OF_YEAR, 1);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * @return 过去一个月的数据
     */
    public static List<String> getDateStr(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = dateFormat.format(new Date());
        Date nowTime = null;
        Date prevTime = null;
        try {
            nowTime  = dateFormat.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        String preMonth = dateFormat.format(c.getTime());
        try {
            prevTime=  dateFormat.parse(preMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Date> betweenDates = getBetweenDates(prevTime, nowTime);
        List<String> dateStr = new ArrayList<>();
        for (Date date : betweenDates) {
            String format = dateFormat.format(date);
            dateStr.add(format);
        }
        return dateStr;
    }


    /**
     *
     * @param start 开始日期
     * @param end 结束日期
     * @return 两段日期的中间日期数据(Year)
     */

    private static List<Date> getBetweenYears(Date start, Date end) {
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        tempStart.add(Calendar.MONTH, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.MONTH, 1);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     *
     * @return 年之间的数据
     */
    public static List<String> getYearStr(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String now = dateFormat.format(new Date());
        Date nowTime = null;
        Date prevTime = null;

        try {
            nowTime  = dateFormat.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        String preYear = dateFormat.format(c.getTime());
        try {
            prevTime=  dateFormat.parse(preYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Date> betweenDates = getBetweenYears(prevTime, nowTime);
        List<String> dateStr = new ArrayList<>();
        for (Date date : betweenDates) {
            String format = dateFormat.format(date);
            dateStr.add(format);
        }
        return dateStr;
    }
}
