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
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-12-16
 */
public class ClusterDemo {

    private Cluster cluster;

    @Before
    public void cluster() {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("192.168.1.36"));
        cluster = Cluster.open(configuration);
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
        HashMap<String, Object> params = new HashMap<>();
//        params.put("name", "lop");
        List<Result> results = client.submit("g.V().values(\"name\")", params).all().get();
        results.forEach(result -> System.out.println(result.getVertex()));
    }

    /**
     * ①：查询已经存在的表和数据能够找到对应的id,但是无法找到对应的字段属性
     * ②：由gremline写入的数据的属性能够查到
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void tbGraph() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().values('name')").all().get();
        for (Result result : results) {
            System.out.println(result);
        }
    }

    /**
     * 获取所有的实体ID
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void tbIds() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V()").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
    }

    /**
     * 指定id
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void tbSpecialId() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V('tb_user/2')").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
    }

    /**
     * 通过gremlin添加数据
     */
    @Test
    public void addTestVertex() {
        Client client = cluster.connect();
        String script = "g.addV(\"user\").property(T.id, \"4\").property(\"name\", \"lop\").property(\"age\", \"24\").next()";
        ResultSet resultSet = client.submit(script);
        System.out.println(resultSet);
    }

}
