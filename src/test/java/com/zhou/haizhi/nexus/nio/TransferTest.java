package com.zhou.haizhi.nexus.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Create by zhoumingbing on 2020-03-28
 */
public class TransferTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/haizhi/Desktop/test_mock.json", "rw");
        FileChannel fromChannel = randomAccessFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/Users/haizhi/Desktop/test_channel.json", "rw");
        FileChannel toChannel = toFile.getChannel();

        long l = fromChannel.transferTo(0, fromChannel.size(), toChannel);
        System.out.println(l);
    }
}
