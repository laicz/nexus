package com.zhou.haizhi.nexus.perform;

import org.apache.commons.collections4.CollectionUtils;
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
public class LogAnalyzeTest1 {

    public static void main(String[] args) {
        String start = " -> ";
        String left = "[";
        String right = "]";
        File file = new File("/Users/haizhi/Desktop/application.log");
        Map<String, Map<String, Long>> result = new HashMap<>();
        Map<String, List<Long>> stepPerMap = new HashMap<>();
        List<TraceLink> traceLinks = new ArrayList<>();
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
                    String step = split1[1];
                    Long costTime = Long.valueOf(split[2].replace(left, "").split(right)[0].replaceAll(",",""));
                    Map<String, Long> stepMap = result.get(traceId);
                    if (stepMap == null) {
                        stepMap = new HashMap<>();
                        result.put(traceId, stepMap);
                    }
                    stepMap.put(step, costTime);

                    List<Long> costTimes = stepPerMap.get(step);
                    if (CollectionUtils.isEmpty(costTimes)) {
                        costTimes = new ArrayList<>();
                        stepPerMap.put(step, costTimes);
                    }
                    costTimes.add(costTime);
                }
            }

            for (Map.Entry<String, Map<String, Long>> entry : result.entrySet()) {
                Long total = 0L;
                for (Long value : entry.getValue().values()) {
                    total += value;
                }
                traceLinks.add(new TraceLink(entry.getKey(), total));
            }

            traceLinks.sort((o1, o2) -> o1.getTime() - o2.getTime() > 0L ? 1 : o1.getTime().equals(o2.getTime()) ? 0 : -1);
            Long totalTime = 0L;
            for (TraceLink traceLink : traceLinks) {
                System.out.println("调用链：" + traceLink.getTraceId() + "  总共耗时：" + traceLink.getTime());
                totalTime += traceLink.getTime();
            }

            System.out.println("共调用了：" + traceLinks.size() + " 次，平均耗时：" + (totalTime / traceLinks.size()));


            for (Map.Entry<String, List<Long>> stringListEntry : stepPerMap.entrySet()) {
                Long total = 0L;
                for (Long aLong : stringListEntry.getValue()) {
                    total += aLong;
                }
                System.out.println("步骤：" + stringListEntry.getKey() + " 平均耗时：" + total / stringListEntry.getValue().size());
            }
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
