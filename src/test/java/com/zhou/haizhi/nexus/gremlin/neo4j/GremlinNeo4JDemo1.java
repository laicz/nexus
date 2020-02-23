package com.zhou.haizhi.nexus.gremlin.neo4j;

import com.steelbridgelabs.oss.neo4j.structure.Neo4JGraph;
import com.steelbridgelabs.oss.neo4j.structure.providers.Neo4JNativeElementIdProvider;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.io.graphson.GraphSONIo;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.driver.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * blot协议下可以执行cypher,需要自行搭建Neo4j
 * Create by zhoumingbing on 2019-12-18
 */
public class GremlinNeo4JDemo1 {

    private Driver driver;

    private String database = "Neo4j1";

    /**
     * 使用blot连接协议连接gremlin
     */
    @Before
    public void driver() {
        driver = GraphDatabase.driver("bolt://60.205.176.135:7687", AuthTokens.basic("neo4j", "123456"));
//        DatabaseSequenceElementIdProvider provider = new DatabaseSequenceElementIdProvider(driver);
    }

    /**
     * Cypher查询存在的数据
     */
    @Test
    public void findGraphByCypher() {
        Neo4JNativeElementIdProvider vertexIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JNativeElementIdProvider edgeIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JGraph graph = new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider);
        String cql = String.format("match data=(n)-[*1]-(m) return data ");
        Result execute = graph.execute(cql);
        List<Record> list = execute.list();
        AtomicInteger count = new AtomicInteger();
        list.forEach(record -> {
            count.incrementAndGet();
            System.out.println(record);
        });
        System.out.println(count.get());
    }

    @Test
    public void findGraphByGremlin(){
        Neo4JNativeElementIdProvider vertexIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JNativeElementIdProvider edgeIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JGraph graph = new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider);
//        String nql = String.format("match data=(n)-[*1]-(m) return data ");
    }

    @Test
    public void addVertex() {
        Neo4JNativeElementIdProvider vertexIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JNativeElementIdProvider edgeIdProvider = new Neo4JNativeElementIdProvider();
        Neo4JGraph graph = new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider);
        graph.addVertex(T.label, "person");
        GraphTraversalSource g = graph.traversal();
        g.V();
    }

}
