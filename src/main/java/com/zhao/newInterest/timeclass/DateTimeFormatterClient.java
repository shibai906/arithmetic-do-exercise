package com.zhao.newInterest.timeclass;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @PROJECT_NAME: arithmetic-do-exercise
 * @USER: zhaohuan
 * @DATE: 2020/6/19 3:51 下午
 * @DESCRIPTION: java 8 新时间戳的使用方式
 * LocalDate 只会获取年、月、日、星期几
 * LocalTime 只会获取时分秒
 * LocalDateTime 获取年、月、日、星期几、时分秒
 */
public class DateTimeFormatterClient {
    // 昨天
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

//        System.out.println(LocalDateTime.now().format(formatter));
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));

        long time = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long now = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(now);
        studyLocalDate();
    }

    public static void studyLocalDate() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDateNext = LocalDate.of(2000,1,1);
        System.out.println("localDateYear = " + localDate.getYear());
        System.out.println("localDateNextYear = " + localDateNext.getYear());
        System.out.println("localDateMonth = " + localDate.getMonth());
        System.out.println("localDateMonthYear = " + localDateNext.getMonth().getValue());
        System.out.println("localDateDay = " + localDate.getDayOfMonth());
        System.out.println("localDateNextDay = " + localDateNext.getDayOfMonth());
        System.out.println("localDateWeek = " + localDate.getDayOfWeek());
        System.out.println("localDateNextWeek = " + localDateNext.getDayOfWeek());
    }

    public static void studyLocalTime() {

        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTimeNext = LocalTime.now();

        System.out.println();

    }



}
