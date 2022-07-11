package com.wx.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang3.tuple.Pair;

public class DateUtils {
    public static void main(String[] args) {
        getCurrentWeek();
    }

    public static Pair<String, String> getCurrentWeek() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);// 以周一为首日
        cld.setTimeInMillis(System.currentTimeMillis());// 当前时间

        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 周一
        String left = df.format(cld.getTime());

        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 周日
        String right = df.format(cld.getTime());
        return Pair.of(left, right);
    }
}
