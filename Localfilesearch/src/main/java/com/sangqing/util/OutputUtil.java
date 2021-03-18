package com.sangqing.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputUtil {

    public static String formatLength(Long length){
        if(length < 1024){
            return length+"byte";
        }
        if(length <1024*1024){
            return (length/1024)+"KB";
        }
        if(length <1024*1024*1024){
            return (length/1024/1024)+"MB";
        }
        return(length/1024/1024/1024)+"GB";
    }

    public static String formatTimestamp(Long timestamp){
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date(timestamp);
        return format.format(date);
    }
}
