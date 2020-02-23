package com.zhou.haizhi.nexus.gremlin.neo4j;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Create by zhoumingbing on 2020-01-08
 */
public class CreateIoTest {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/haizhi/Desktop/gremlin_big_data.json";
        FileWriter writer = new FileWriter(fileName, true);
        for (int i = 0; i < 100000; i++) {
            String content = "{\"id\":" + i + ",\"label\":\"person\",\"outE\":{\"created\":[{\"id\":9,\"inV\":" + (i + 1) + ",\"properties\":{\"weight\":0.4}}],\"knows\":[{\"id\":7,\"inV\":" + (i + 2) + ",\"properties\":{\"weight\":0.5}},{\"id\":8,\"inV\":" + (i + 3) + ",\"properties\":{\"weight\":1.0}}]},\"properties\":{\"name\":[{\"id\":0,\"value\":\"marko\"}],\"age\":[{\"id\":1,\"value\":29}]}}\n";
            writer.write(content);
        }
        writer.close();

    }

}
