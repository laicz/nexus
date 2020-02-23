package com.zhou.haizhi.nexus.gremlin.arango;

import com.arangodb.tinkerpop.gremlin.utils.ArangoDBConfigurationBuilder;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.tinkerpop.gremlin.groovy.engine.GremlinExecutor;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by zhoumingbing on 2019-12-16
 */
public class ArangoShellDemo {
    private final BasicThreadFactory testingThreadFactory = new BasicThreadFactory.Builder().namingPattern("test-gremlin-executor-%d").build();
    private GraphTraversalSource gts;

    @Before
    public void connect() {
        ArangoDBConfigurationBuilder configurationBuilder = new ArangoDBConfigurationBuilder();
        configurationBuilder.arangoHosts("192.168.1.176:8529")
                .arangoUser("dmp_manager")
                .arangoPassword("dmp_manager@2019");
        configurationBuilder.dataBase("cdh514_dev");
        configurationBuilder.graph("");
        configurationBuilder.shouldPrefixCollectionNamesWithGraphName(true);
//        HashSet<String> verteics = new HashSet<>();
//        verteics.add("company");
//        verteics.add("person");
        configurationBuilder.withVertexCollection("vertex");
        configurationBuilder.withVertexCollection("software");
        configurationBuilder.withEdgeCollection("edge");
        BaseConfiguration config = configurationBuilder.build();
        Graph graph = GraphFactory.open(config);
        gts = new GraphTraversalSource(graph);
    }

    @Test
    public void shell() {
        GraphTraversalSource g = gts.clone();
        final ExecutorService evalExecutor = Executors.newSingleThreadExecutor(testingThreadFactory);
        final GremlinExecutor gremlinExecutor = GremlinExecutor.build()
                .afterSuccess(b -> {
                    final GraphTraversalSource ig = (GraphTraversalSource) b.get("g");
                    if (ig.getGraph().features().graph().supportsTransactions())
                        ig.tx().commit();
                })
                .executorService(evalExecutor).create();
        final Map<String, Object> bindings = new HashMap<>();
        bindings.put("g", g);

        final AtomicInteger vertexCount = new AtomicInteger(0);

        final ExecutorService iterationExecutor = Executors.newSingleThreadExecutor(testingThreadFactory);
        gremlinExecutor.eval("g.V().has(\"vertex\", \"name\", \"lop\")", bindings).thenAcceptAsync(o -> {
            final Iterator itty = (Iterator) o;
            itty.forEachRemaining(v -> vertexCount.incrementAndGet());
        }, iterationExecutor).join();
        System.out.println(vertexCount.get());
    }

    @Test
    public void javaMatch() {
        GraphTraversalSource g = gts.clone();
        GraphTraversal<Vertex, Vertex> v = g.V().has("vertex", "name", "lop");
        int count = 0;
        while (v.hasNext()) {
            v.next();
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void javaMatchEdge() {
        GraphTraversalSource g = gts.clone();
        GraphTraversal<Vertex, Edge> v = g.V().has("vertex", "name", "lop").outE("edge");
        int count = 0;
        while (v.hasNext()) {
            v.next();
            count++;
        }
        System.out.println(count);
    }
}
