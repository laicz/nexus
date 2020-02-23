package com.zhou.haizhi.nexus.gremlin.arango;

import com.google.common.collect.ImmutableList;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-12-16
 */
public class LocalhostClusterDemo {

    private Cluster cluster;

    @Before
    public void cluster() {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("192.168.1.36"));
        cluster = Cluster.open();
    }

    /**
     * 在启动时生成的vertex和edge表中导入数据，能使用并能查询到数据
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void simpleQuery() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        Map<String, Object> params = new HashMap<>();
        params.put("name", "marko");
        List<Result> list = client.submit("g.V().has('person','name',name).out('knows')", params).all().get();
        list.forEach(result -> {
            System.out.println(result);
        });
    }

    /**
     * 数据进行遍历
     */
    @Test
    public void values() {
        Client client = cluster.connect();
        ResultSet resultSet = client.submit("g.V().values('name')");
        Iterator<Result> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 边查询
     */
    @Test
    public void edge() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().has('name','marko').out('created').values('name')").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
    }

    @Test
    public void countEdge() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.E().label().groupCount()").all().get();
        for (Result result : results) {
            System.out.println(result);
        }
    }

}
