package com.zhou.haizhi.nexus.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Create by zhoumingbing on 2020-02-13
 */
public class StringTest {
    @Test
    public void encode() {
        String word = "Prespecialized";
        word = word.toLowerCase();
        char[] chars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (chars[i] != 0) {
                continue;
            }
            char first = word.charAt(i);
            boolean replace = false;
            for (int j = i + 1; j < word.length(); j++) {
                if (first == word.charAt(j)) {
                    replace = true;
                    chars[j] = ')';
                }
            }
            if (replace) {
                chars[i] = ')';
            } else {
                chars[i] = '(';
            }
        }
        System.out.println(new String(chars));
    }

    @Test
    public void getField() {
        String str = "------------------------------------------------------------------------------------------------\n" +
                "Property Key Name              | Cardinality | Data Type                                          |\n" +
                "---------------------------------------------------------------------------------------------------\n" +
                "name                           | SINGLE      | class java.lang.String                             |\n" +
                "long_field                     | SINGLE      | class java.lang.Long                               |\n" +
                "object_key                     | SINGLE      | class java.lang.String                             |\n" +
                "double_field                   | SINGLE      | class java.lang.Double                             |\n" +
                "date_field                     | SINGLE      | class java.lang.String                             |\n" +
                "date_field1                    | SINGLE      | class java.lang.String                             |\n" +
                "long_field1                    | SINGLE      | class java.lang.Long                               |\n" +
                "double_field1                  | SINGLE      | class java.lang.Double                             |\n" +
                "object_key1                    | SINGLE      | class java.lang.String                             |\n" +
                "date_field2                    | SINGLE      | class java.lang.String                             |\n" +
                "long_field2                    | SINGLE      | class java.lang.Long                               |\n" +
                "double_field2                  | SINGLE      | class java.lang.Double                             |\n" +
                "object_key2                    | SINGLE      | class java.lang.String                             |\n" +
                "---------------------------------------------------------------------------------------------------\n";

        String[] rows = StringUtils.split(str,"\n");
        for (int i = 0; i < rows.length; i++) {
            if (i < 3 || i == (rows.length - 1)) {
                continue;
            }
            String row = rows[i];
            String[] cells = StringUtils.split(row, "|");
            System.out.println(cells[0].trim());
        }
    }
}
