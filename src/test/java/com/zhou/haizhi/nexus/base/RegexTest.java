package com.zhou.haizhi.nexus.base;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by zhoumingbing on 2020-03-15
 */
public class RegexTest {

    /**
     * 元字符
     * /d 匹配一个数字，是[0-9]的缩写
     * /D 匹配一个非数字，是【^0-9]的缩写
     * /s 匹配一个空格
     * /S 匹配一个非空格
     * /w 匹配一个单词
     * /W 匹配一个非单词
     * <p>
     * 在[]中的字符会被拆开分别进行匹配
     * 而()是一个整体
     */
    @Test
    public void metaSymbol() {
        String str1 = "sfdsajflhsalf3hgsafisah4gibs5kfsdafskakfsadfsdakflsdajk09f0\n\r\n  08d\ns32jj";
        System.out.println(str1.replaceAll("\\d{2,}", ""));
    }

    /**
     * 分组，()能够达到对正则表达式进行分组的效果
     * 在正则表达式中，$表示对分组的反向引用,$0是匹配完整模式的字符串,$1是第一个分组的反向引用，$2是匹配第二个分组的反向引用，以此类推
     */
    @Test
    public void group() {
        String str = "Hello , World .";
        String regex = "(\\w)(\\s+)([.,])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
//        System.out.println(str.replaceAll(regex,"YYY"));
//        System.out.println(matcher.group(0));

    }
}
