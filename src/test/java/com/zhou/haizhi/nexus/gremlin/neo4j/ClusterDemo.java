package com.zhou.haizhi.nexus.gremlin.neo4j;

import com.google.common.collect.Lists;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Create by zhoumingbing on 2019-12-19
 */
public class ClusterDemo {
    Cluster cluster;

    /**
     * 连接gremlin-server
     */
    @Before
    public void connect() {

        //remote gremlin server
        cluster = remote();
//        cluster = Cluster.open(configuration);

        //local gremlin server
//        cluster = Cluster.open();
    }

    private Cluster remote() {
        String url = "192.168.1.16:18182";
        List<String> hosts = Lists.newArrayList();
        int port = 0;
        String[] hostArray = url.split(",");
        for (String host : hostArray) {
            String[] ipPort = host.split(":");
            hosts.add(ipPort[0]);
            port = Integer.valueOf(ipPort[1]);
        }

        cluster = Cluster.build()
                .addContactPoints(hosts.toArray(new String[]{}))
                .port(port)
                .credentials("haizhi", "haizhi2020")
                .maxContentLength(1048576)
                .create();

        return cluster;
    }

    /**
     * 创建图
     */
    @Test
    public void createGraph(){
        Client connect = cluster.connect();
        StringBuilder gql = new StringBuilder();
        gql.append("map = new HashMap<String, Object>();");
        gql.append("map.put(\"storage.backend\", \"hbase\");");
        gql.append("map.put(\"storage.hostname\", \"192.168.1.244\");");
        gql.append("map.put(\"graph.graphname\", \"zmb008\");");
        gql.append("ConfiguredGraphFactory.createConfiguration(new MapConfiguration(map));");
        gql.append("zmb008 = ConfiguredGraphFactory.open(\"zmb008\");");
        gql.append("zmb008.addVertex(\"person\").property(\"name\",\"zmb008\");");
        gql.append("zmb008.tx().commit();");
        connect.submit(gql.toString());
    }

    /**
     * 删除图
     */
    @Test
    public void dropGraph() {
        Client connect = cluster.connect();
        StringBuilder gql = new StringBuilder();
        gql.append("ConfiguredGraphFactory.drop(\"zmb008\");");
        connect.submit(gql.toString());
    }

    @Test
    public void testConnect() {
        Client client = cluster.connect();
        Cluster cluster = client.getCluster();
        client.submit("g.V()");
        System.out.println(client.isClosing());
    }

    /**
     * 指定label及属性进行查询，并返回指定的属性
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void query() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().hasLabel(\"person\").has(\"name\", \"stephen\").values(\"name\")").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
    }

    /**
     * 写入两个实体数据并获取
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void addTwoVertex() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        //写入两条顶点数据
        client.submit("g.addV(\"person\").property(\"name\", \"chengmo\").next();");
        client.submit("g.addV(\"person\").property(\"name\", \"liulu\").next();");
        //查询刚写入的数据
        List<Result> results = client.submit("g.V().hasLabel(\"person\").values(\"name\")").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
        System.out.println("------------------");
        List<Result> ids = client.submit("g.V().values(\"T.id\")").all().get();
        ids.forEach(id -> {
            System.out.println(id);
        });
    }

    /**
     * 获取某个顶点详情
     */
    @Test
    public void vertexDetail() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
//        List<Result> results = client.submit("g.addV(\"company\").property(\"name\", \"haizhi\").property(\"address\",\"南山\").next()").all().get();
        List<Result> results = client.submit("g.V().valueMap(\"name\",\"address\")").all().get();
        print(results);
    }

    /**
     * 暂时发现指定实体ID会出现异常
     * java.util.concurrent.ExecutionException: org.apache.tinkerpop.gremlin.driver.exception.ResponseException: Vertex does not support user supplied identifiers
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void addVertexWithId() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("strategy = ElementIdStrategy.build().create();g = graph.traversal()withStrategies(strategy);g.addV('country').property(T.id,'rrwww').property(\"name\",\"position_id\").next()").all().get();
        print(results);
    }

    /**
     * 删除实体
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void dropVertex() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
//        client.submit("g.addV().property('name','yitao').next()");
//        vertexQuery();
        client.submit("g.V(\"5\").drop()");
        vertexQuery();
    }

    @Test
    public void update() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V('4').property(\"name\",\"new_yitao_new\").next()").all().get();
        print(results);
    }

    /**
     * 添加边
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void addEdge() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("liulu = g.V().hasLabel(\"person\").has(\"name\",\"liulu\")").all().get();
        List<Result> results1 = client.submit("chengmo = g.V().hasLabel(\"person\").has(\"name\",\"chengmo\")").all().get();
//        List<Result> results2 = client.submit("liulu = g.V().hasLabel(\"person\").has(\"name\",\"liulu\");chengmo = g.V().hasLabel(\"person\").has(\"name\",\"chengmo\");g.addE('knows').from(liulu).to(chengmo).next()").all().get();
        List<Result> results2 = client.submit("v1 = g.V().hasLabel(\"company\").has(\"key\", \"company/id5\");v2 = g.V().hasLabel(\"company\").has(\"key\", \"company/id4\");g.addE(\"invest\").property(\"key\",\"invest/id0\").property(\"name\",\"投资关系0\").property(\"date\",\"2019-12-20 14:32:37\").property(\"amount\",60210248).from(v1).to(v2).next()").all().get();
        System.out.println(results2);
    }

    /**
     * 添加实体和边
     */
    @Test
    public void addVertexAndEdge() {
        Client client = cluster.connect();
        client.submit("g.addV(\"xingtu\").property(\"key\",\"xingtu/id1\").property(\"name\",\"用户1\").property(\"age\",20).next()");
        System.out.println("add over");
    }

    @Test
    public void queryXintu() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().hasLabel(\"company\").valueMap(\"key\",\"name\",\"address\")").all().get();
        print(results);
    }

    @Test
    public void vertexProperties() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().valueMap(\"name\")").all().get();
        print(results);
    }

    /**
     * 指定id查询
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void selectVertexById() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V('0').values('name')").all().get();
        print(results);
    }

    /**
     * 图查询
     */
    @Test
    public void graphQuery() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.getGraph()").all().get();
        results.forEach(result -> {
            System.out.println(result);
        });
    }

    /**
     * 查看属性和值
     */
    @Test
    public void property() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().properties()").all().get();
        results.forEach(result -> {
            System.out.println(result.getString());
        });
        System.out.println("----------edge properties--------------");
        List<Result> edgeResults = client.submit("g.E().properties()").all().get();
        edgeResults.forEach(result -> {
            System.out.println(result.getString());
        });
    }

    /**
     * 通过io加载数据
     */
    @Test
    public void ioLoadLargeData() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.io('/Users/haizhi/Desktop/gremlin_io.json').read().iterate()").all().get();
        print(results);
    }

    /**
     * 实体查询
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void vertexQuery() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().values()").all().get();
//        for (int i = 0; i < results.size(); i++) {
//            System.out.println(i);
//            List<Result> results1 = client.submit("g.V('" + (i) + "').values()").all().get();
//            print(results1);
//            System.out.println("-----------------------------");
//        }
        print(results);
    }


    /**
     * 通过io加载数据
     */
    @Test
    public void ioLoad() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("strategy = ElementIdStrategy.build().create();g = graph.traversal().withStrategies(strategy);g.io('/Users/haizhi/Desktop/gremlin_big_data.json').read().iterate()").all().get();
        print(results);
    }

    /**
     * 通过io加载数据(异步执行)
     */
    @Test
    public void ioLoadAsync() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        CompletableFuture<ResultSet> future = client.submitAsync("strategy = ElementIdStrategy.build().create();g = graph.traversal().withStrategies(strategy);g.io('/Users/haizhi/Desktop/gremlin_big_data.json').read().iterate()");
        Thread.sleep(10000);
        vertex();
//        future.cancel(true);
        client.closeAsync();
    }

    @Test
    public void vertex() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V()").all().get();
//        print(results);
        System.out.println(results.size());
    }

    @Test
    public void pointGraphVertex() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("zmb003.traversal().V()").all().get();
        print(results);
        System.out.println(results.size());
    }

    @Test
    public void pointGraphEdge() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g=graph6.traversal();g.E()").all().get();
        print(results);
        System.out.println(results.size());
    }

    @Test
    public void kExpend() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        String gql = "g=graph6.traversal();g.V(0)g.V([0]).repeat(__.bothE().hasLabel('invest').otherV().hasLabel('Company','Person').simplePath()).times(2).emit().path();";
        CompletableFuture<List<Result>> futureResult = client.submit(gql).all();
        List<Result> results = futureResult.join();
        print(results);
        System.out.println(results.size());
    }

    @Test
    public void clearData() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        client.submit("g=graph5.traversal(); g.E().drop(); g.V().drop();");

    }

    /**
     * 边查询
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void edgeQuery() throws ExecutionException, InterruptedException {
        Client client = cluster.connect();
        List<Result> results = client.submit("g.E().valueMap()").all().get();
        print(results);
        System.out.println("edge size :" + results.size());
    }

    @Test
    public void existsTable() {
        try {
            String database = "zmb010", table = "person1";
            Client client = cluster.connect();
            String ql = buildCheckTableQl(database, table);
            List<Result> results = client.submit(ql).all().get();
            System.out.println(results.get(0).getBoolean());
//            print(results);
        } catch (Exception e) {
            e.printStackTrace();
//            LOG.error("check gremlin graph label exist error", e);
//            throw new RuntimeException();
        }
//        return false;
    }

    private String buildCheckTableQl(String database, String table) {
        StringBuilder ql = new StringBuilder();
        ql.append(database).append(".openManagement().containsVertexLabel('").append(table).append("')");
        return ql.toString();
    }


    private void print(List<Result> results) {
        results.forEach(result -> {
            System.out.println(result);
        });
    }
}
