package com.zjwm.wyx.utils;

import java.util.Calendar;


public class UUIDS {

    public static String getDateUUID(){
        Calendar Cld = Calendar.getInstance();
        int YY = Cld.get(Calendar.YEAR) ;
        int MM = Cld.get(Calendar.MONTH)+1;
        int DD = Cld.get(Calendar.DATE);
        int HH = Cld.get(Calendar.HOUR_OF_DAY);
        int mm = Cld.get(Calendar.MINUTE);
        int SS = Cld.get(Calendar.SECOND);
        int MI = Cld.get(Calendar.MILLISECOND);
        int number = (int)(Math.random()*999);
        return YY + "" + MM + "" + DD + "" + HH + "" + mm + "" + SS + "" + MI + "" + number;
    }

    public static String getDateTime(){
        Calendar Cld = Calendar.getInstance();
        int YY = Cld.get(Calendar.YEAR) ;
        int MM = Cld.get(Calendar.MONTH)+1;
        int DD = Cld.get(Calendar.DATE);
        int HH = Cld.get(Calendar.HOUR_OF_DAY);
        int mm = Cld.get(Calendar.MINUTE);
        int SS = Cld.get(Calendar.SECOND);
        return YY + "" + MM + "" + DD + "" + HH + "" + mm + "" + SS;
    }
    
    
    public static String OutTradeNo(){
        Calendar Cld = Calendar.getInstance();
        int YY = Cld.get(Calendar.YEAR) ;
        int MM = Cld.get(Calendar.MONTH)+1;
        int DD = Cld.get(Calendar.DATE);
        int number = (int)(Math.random()*99999);
        return YY + "" + MM + "" + DD + number;
    }
    

}
