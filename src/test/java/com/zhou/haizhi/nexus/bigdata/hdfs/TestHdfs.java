package com.zhou.haizhi.nexus.bigdata.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create by zhoumingbing on 2020-07-04
 */
public class TestHdfs {

    private Configuration conf = null;
    private FileSystem fileSystem = null;


    @Before
    public void conn() throws IOException {
        conf = new Configuration(true);
        //通过配置文件获取fileSystem
        /**
         * 参考core-site.xml文件中的该配置项，如果配置的是hdfs，则创建的对象是DistributedFileSystem
         *     <property>
         *         <name>fs.defaultFS</name>
         *         <value>hdfs://localhost:9000</value>
         *     </property>
         */
        fileSystem = FileSystem.get(conf);
    }

    /**
     * 创建目录
     * @throws IOException
     */
    @Test
    public void mkdir() throws IOException {
        Path path = new Path("/hdfs/api/test");
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        fileSystem.mkdirs(path);
    }

    /**
     * 上传文件
     */
    @Test
    public void upload() throws IOException {
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/hdfs/api/test/hdfs-core.xml"));
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/haizhi/Idea/own/nexus/src/main/resources/hdfs-site.xml"));
        int copy = IOUtils.copy(fileInputStream, fsDataOutputStream);
        fsDataOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 文件block信息
     * 能拿到文件的每个block信息，这样就能够计算向数据移动，同时并行运行
     */
    @Test
    public void block() throws IOException {
        Path path = new Path("/book/hadoop/001.hadoop-大数据启蒙-初识HDFS.vep");
        FileStatus fileStatus = fileSystem.getFileStatus(path);
        BlockLocation[] fileBlockLocations = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation fileBlockLocation : fileBlockLocations) {
            System.out.println(fileBlockLocation);
        }

        FSDataInputStream fsDataInputStream = fileSystem.open(path);
        //只有支持这个方法，才能支持计算向数据移动，读取自己想要的数据，具备距离的概念，优先读取当前节点的DataNode的数据，框架默认的距离概念
        fsDataInputStream.seek(1);
    }



    @After
    public void close() throws IOException {
        if (fileSystem != null) {
            fileSystem.close();
        }
    }

}
