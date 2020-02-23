package com.zhou.haizhi.nexus.gremlin.neo4j;

import com.google.common.collect.ImmutableList;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-12-20
 */
public class ClusterGraphsDemo {
    Cluster cluster;

    @Before
    public void connect() {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("192.168.1.57"));
        configuration.addProperty("port", 8182);
        cluster = Cluster.open(configuration);
    }

    @Test
    public void vertexQuery() throws ExecutionException, InterruptedException {
        Client client = cluster.connect("graph1");
        client.submit("g=graph1.traversal()");
        List<Result> results = client.submit("g.V()").all().get();
        System.out.println(results.size());

        Client client1 = cluster.connect("graph");
        client1.submit("g=graph.traversal()");
        List<Result> results1 = client1.submit("g.V()").all().get();
        System.out.println(results1.size());
        client1.submit("g=graph1.traversal()");
        List<Result> results2 = client1.submit("g.V()").all().get();
        System.out.println(results2.size());

        Client client2 = cluster.connect("graph1");
        System.out.println(client2.submit("g.V()").all().get().size());
        client2.close();
    }

    private void print(List<Result> results) {
        results.forEach(result -> {
            System.out.println(result);
        });
    }
}
