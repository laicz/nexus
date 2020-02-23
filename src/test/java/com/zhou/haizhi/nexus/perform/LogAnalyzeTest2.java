package com.zhou.haizhi.nexus.perform;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-12-30
 */
public class LogAnalyzeTest2 {

    public static void main(String[] args) {
        String start = " -> ";
        String left = "[";
        String right = "]";
        File file = new File("/Users/haizhi/Desktop/application.log");
        Map<String, Map<String, Long>> result = new HashMap<>();
        Map<String, List<Long>> stepPerMap = new HashMap<>();
        List<TraceLink> traceLinks = new ArrayList<>();
        long allTime = 0L;
        long count = 0L;
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (StringUtils.contains(line, start)) {
                    String[] split = line.split(start);
                    String[] split1 = split[1].split(right);
                    String traceId = split1[0].replace(left, "");
                    allTime += Long.valueOf(traceId);
                    count++;
                }
            }
            System.out.println(allTime / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TraceLink {

        private String traceId;

        private Long time;

        public TraceLink(String traceId, Long time) {
            this.traceId = traceId;
            this.time = time;
        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }
    }
}
