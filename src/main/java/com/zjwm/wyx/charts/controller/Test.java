package com.zjwm.wyx.charts.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
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

    public static void main(String[] args) {

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
        List<Date> betweenDates = getBetweenDates(prevTime, nowTime);
        List<String> dateStr = new ArrayList<>();
        for (int i = 0; i < betweenDates.size(); i++) {
            Date date = betweenDates.get(i);
            String format = dateFormat.format(date);
            System.out.println(format);
//            dateStr.add(format);
        }
    }

}
