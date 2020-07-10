package com.zhou.haizhi.nexus.haizhi;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Create by zhoumingbing on 2020-05-07
 */
public class DataFileGenerator {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/haizhi/Desktop/Person.json";
        File file = new File(filePath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
        for (int i = 0; i < 10000000; i++) {
            String sign = String.valueOf(i);
            Person person = new Person("key" + sign, "name" + sign, "address" + sign, i, "remark" + sign);
            bufferedOutputStream.write((JSON.toJSONString(person) + "\n").getBytes());
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static class Person implements Serializable {
        private String object_key;
        private String name;
        private String address;
        private int age;
        private String remark;

        public Person(String objectKey, String name, String address, int age, String remark) {
            this.object_key = objectKey;
            this.name = name;
            this.address = address;
            this.age = age;
            this.remark = remark;
        }

        public String getObject_key() {
            return object_key;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public int getAge() {
            return age;
        }

        public String getRemark() {
            return remark;
        }
    }
}
