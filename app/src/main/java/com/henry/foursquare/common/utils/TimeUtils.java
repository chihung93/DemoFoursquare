package com.henry.foursquare.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String getCurrentDay(){
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
