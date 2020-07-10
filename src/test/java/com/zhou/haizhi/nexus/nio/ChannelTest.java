package com.zhou.haizhi.nexus.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by zhoumingbing on 2020-03-27
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/haizhi/Desktop/test_mock.json", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        //分配一个缓存区域
        ByteBuffer buffer = ByteBuffer.allocate(200);
        int read = channel.read(buffer);
        while (read != -1) {
            System.out.println("Read:" + read);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        channel.close();
        randomAccessFile.close();
    }
}
