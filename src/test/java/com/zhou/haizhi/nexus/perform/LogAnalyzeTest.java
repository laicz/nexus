package com.zhou.haizhi.nexus.perform;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Create by zhoumingbing on 2019-10-28
 */
public class LogAnalyzeTest {

    public static void main(String[] args) throws FileNotFoundException {
        String regEx = "[^0-9]";
        Pattern pattern = Pattern.compile(regEx);
        File file = new File("/Users/haizhi/Desktop/gap-restapi-2.5.2.log");
        Map<String, Integer> result = new HashMap<>();
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("--");
                if (split.length == 2 && line.contains("com.haizhi.gap.search.service.impl.GsGdbServiceImpl")) {
                    String log = split[1];
                    String[] split1 = log.split(",");
                    if (split1.length == 3) {
                        String key = split1[1];
                        String valueStr = pattern.matcher(split1[2]).replaceAll("").trim();
                        Integer value = result.get(key);
                        if (value == null) {
                            value = 0;
                        }
                        result.put(key, value + Integer.valueOf(valueStr));
                    }
                }
            }
            System.out.println(JSON.toJSONString(result, true));
            Collection<Integer> values = result.values();
            Iterator<Integer> iterator = values.iterator();
            int total = 0;
            while (iterator.hasNext()) {
                total += iterator.next();
            }
            System.out.println("总耗时：" + total + " ms");
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " : " + (numberFormat.format((float) entry.getValue() / (float) total)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
