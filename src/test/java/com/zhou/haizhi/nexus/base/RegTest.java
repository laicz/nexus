package com.zhou.haizhi.nexus.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by zhoumingbing on 2019-11-13
 */
public class RegTest {

    private static final String REG_TABLE_NAME = "(?<=((from)|(join))\\s+)[a-zA-Z_]\\w*[;\\s+]";
    private static final Pattern PATTERN_TABLE_NAME = Pattern.compile(REG_TABLE_NAME, Pattern.CASE_INSENSITIVE);

    @Test
    public void reg() {
        String reg = "(\\s+)limit\\s+(\\d+)[;\\s+]?";
        Pattern pattern = Pattern.compile(reg);
        String s = "select a from b limit 10 ";
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String group = matcher.group(2);
            System.out.println(matcher.replaceAll(" limit 100 "));
            System.out.println(group);
            System.out.println(s.replace(reg, " limit 100 "));
        }
    }

    @Test
    public void tableName() {
        String sql = "Select * from combinedata_aqse2l3ja_out_test.";
//        if (!StringUtils.endsWithAny(sql, " ", ";")) {
//            sql += " ";
//        }
        Matcher matcher = PATTERN_TABLE_NAME.matcher(sql);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            sql = matcher.replaceFirst("dataBase." + group);
            System.out.println(sql);
            matcher = PATTERN_TABLE_NAME.matcher(sql);
        }
        System.out.println(sql);
    }
}
