package com.zhou.haizhi.nexus.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Create by zhoumingbing on 2020-02-18
 */
public class DataTest {

    @Test
    public void test() throws ParseException {
        Date date = parseDate("2019-06-2301:03:56");
        System.out.println(date.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    public  Date parseDate(String time) throws ParseException {
        if (StringUtils.isBlank(time)) {
            return null;
        } else {
            if (time.contains("T")) {
                Date date = utc2Local(time, "yyyy-MM-dd'T'HH:mm:ss'Z'");
                if (date == null) {
                    return null;
                }
            }

            String format = "";
            time = time.replaceAll("[-|:| ]", "");
            if (time.length() == 8) {
                format = "yyyyMMdd";
            } else if (time.length() == 14) {
                format = "yyyyMMddHHmmss";
            }

            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(time);
            return date;
        }
    }

    public  Date utc2Local(String utcTime, String utcPatten) {
        SimpleDateFormat utc = new SimpleDateFormat(utcPatten);
        utc.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;

        try {
            utcDate = utc.parse(utcTime);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return utcDate;
    }
}
