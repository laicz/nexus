package com.zhou.haizhi.nexus.gremlin.neo4j;

import com.google.common.collect.ImmutableList;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.neo4j.structure.Neo4jGraph;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.strategy.decoration.ElementIdStrategy;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.io.graphson.GraphSONIo;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by zhoumingbing on 2019-12-18
 */
public class Neo4jGraphTest {

    @Test
    public void findGraphByCypher() {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("127.0.0.1"));
        configuration.addProperty("gremlin.neo4j.directory", "/tmp/neo4j2");
        Neo4jGraph neo4jGraph = Neo4jGraph.open(configuration);
        GraphTraversal<Object, Object> cypher = neo4jGraph.cypher("MATCH (a {name:\"zhou\"}) RETURN a").values("name");
        while (cypher.hasNext()) {
            System.out.println(cypher.next());
        }
    }

    @Test
    public void findGraphByGremlin() throws Exception {
        Configuration configuration = new BaseConfiguration();
//        configuration.addProperty("hosts", ImmutableList.of("127.0.0.1"));
        configuration.addProperty("gremlin.neo4j.directory", "/tmp/neo4j2");
        Neo4jGraph neo4jGraph = Neo4jGraph.open(configuration);
//        GraphTraversal<Object, Object> cypher = neo4jGraph.cypher("CREATE INDEX ON :person(name)");
//        neo4jGraph.tx().commit();
        GraphTraversalSource g = neo4jGraph.traversal();
        g.addV("person1").property("name", "zhou").next();

//        g.addV("dog").property("name", "puppy").next();
        GraphTraversal<Vertex, Object> values = g.V().hasLabel("person1").has("name", "zhou").values("name");
//        g.addE().from().to()

        while (values.hasNext()) {
            System.out.println(values.next());
        }
        neo4jGraph.close();
//        GraphTraversalSource g = neo4jGraph.traversal();
//        g.addE()
    }

    @Test
    public void demo() throws Exception {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("127.0.0.1"));
        configuration.addProperty("gremlin.neo4j.directory", "/tmp/neo4j1");
        Neo4jGraph graph = Neo4jGraph.open(configuration);
        graph.io(GraphSONIo.build()).readGraph("/Users/haizhi/Desktop/gremlin_io.json");
//        GraphTraversalSource g = neo4jGraph.traversal();
//        GraphTraversalSource g = neo4jGraph.traversal().withStrategies(ElementIdStrategy.build().create());
//        GraphTraversal<Vertex, Object> id = g.addV().property(T.id, "42a").id();
//        System.out.println(id);
//        g.wi
    }

    /**
     * 通过cluster的方式能够执行gremlin语法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void cluster() throws ExecutionException, InterruptedException {
        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("127.0.0.1"));
//        configuration.addProperty("gremlin.neo4j.directory", "/tmp/neo4j2");

        Cluster cluster = Cluster.open(configuration);
        Client client = cluster.connect();
        List<Result> results = client.submit("g.V().hasLabel('person').has('name','zhou').values('name')").all().get();
        AtomicInteger count = new AtomicInteger();
        results.stream().forEach(result -> {
            count.incrementAndGet();
            System.out.println(result);
        });
        System.out.println(count.get());
    }
}
