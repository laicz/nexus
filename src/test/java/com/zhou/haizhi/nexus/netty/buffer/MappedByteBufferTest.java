package com.zhou.haizhi.nexus.netty.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用直接内存(堆外内存)
 * Create by zhoumingbing on 2020-06-25
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("/Users/haizhi/Desktop/te_address.json", "rw");
        FileChannel channel = accessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 100);
        mappedByteBuffer.put(0,(byte) 'H');
        mappedByteBuffer.put(2,(byte) 'O');

        accessFile.close();
    }
}
