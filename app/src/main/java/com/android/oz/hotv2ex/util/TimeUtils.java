package com.android.oz.hotv2ex.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author O.z Young
 * @date 16/9/18
 * @desc ${CURSOR}
 */
public class TimeUtils {

    /**
     * 根据传入的时间来拼接成 yyyy-MM-dd hh:MM:ss 的格式
     *
     * @param times 这个时间不需要 * 1000 在方法中计算
     * @return
     */
    public static String buildFullTime(long times) {
        long fullTime = times * 1000;
        // 这个时间记得 * 1000，否则就只能获取到日了
        Date date = new Date(fullTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.YEAR))
                .append("-")
                .append(calendar.get(Calendar.MONTH))
                .append("-")
                .append(calendar.get(Calendar.DAY_OF_MONTH))
                .append(" ")
                .append(calendar.get(Calendar.HOUR_OF_DAY))
                .append(":")
                .append(calendar.get(Calendar.MINUTE))
                .append(":")
                .append(calendar.get(Calendar.SECOND));
        return sb.toString();
    }

}
