package com.zhou.haizhi.nexus.guava;

import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Create by zhoumingbing on 2020-02-20
 */
public class Md5ToLongTest {

    @Test
    public void md5ToLong(){
        String str =  "faifhdskhfugafioiorweiourhiqwjrkewf";
        System.out.println(Hashing.md5().hashString(str, Charset.defaultCharset()).asLong());
    }

    @Test
    public void test(){
        System.out.println(Long.toBinaryString(36028797018963968L));
        System.out.println(Long.toBinaryString(1L << 55));

    }
}
