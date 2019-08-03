package com.example.gateway.common.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * Created by JiWen on 2019/6/30 at home.
 */
public class DateUtil {

    public static DateTimeFormatter DatePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter DateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    public static DateTimeFormatter LongDateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
    public static DateTimeFormatter TimePattern = DateTimeFormatter.ofPattern("hh:mm:ss");
    public static DateTimeFormatter LongTimePattern = DateTimeFormatter.ofPattern("hh:mm:ss.SSS");


    public static Date now() {
        return new Date();
    }

    public static String nowStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String nowStr() {
        return LocalDateTime.now().format(DateTimePattern);
    }

    public static String nowDateTimeStr() {
        return LocalDateTime.now().format(DateTimePattern);
    }

    public static String nowLongDateTimeStr() {
        return LocalDateTime.now().format(LongDateTimePattern);
    }

    public static String nowDateStr() {
        return LocalDate.now().format(DatePattern);
    }

    private static String nowTimeStr() {
        return LocalTime.now().format(TimePattern);
    }

    public static String nowLongTimeStr() {
        return LocalTime.now().format(LongTimePattern);
    }

    public static String str(Date date, String pattern) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String str(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(DateTimePattern);
    }

    public static String dateStr(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(DatePattern);
    }

    public static String dateTimeStr(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(DateTimePattern);
    }

    public static String longDateTimeStr(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(LongDateTimePattern);
    }

    public static String timeStr(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(TimePattern);
    }

    public static String longTimeStr(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(LongTimePattern);
    }


    public static void main(String[] args) {
        System.out.println(DateUtil.now());
        System.out.println(DateUtil.nowDateStr());
        System.out.println(DateUtil.nowDateTimeStr());
        System.out.println(DateUtil.nowLongDateTimeStr());
        System.out.println(DateUtil.nowTimeStr());
        System.out.println(DateUtil.nowLongTimeStr());
        System.out.println();
        System.out.println(DateUtil.str(now()));
        System.out.println(DateUtil.dateStr(now()));
        System.out.println(DateUtil.dateTimeStr(now()));
        System.out.println(DateUtil.longDateTimeStr(now()));
        System.out.println(DateUtil.timeStr(now()));
        System.out.println(DateUtil.longTimeStr(now()));
    }

}
