package com.zhou.haizhi.nexus.gremlin.arango;

import com.arangodb.tinkerpop.gremlin.utils.ArangoDBConfigurationBuilder;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * Create by zhoumingbing on 2019-12-14
 */
public class ArangoDemo {

    //    @Test
//    public void connection(){
//        DriverRemoteConnection remoteConnection = DriverRemoteConnection.using("localhost", 8182);
//        GraphTraversalSource graph = traversal().withRemote(remoteConnection);
//        graph.get
//    }
    private GraphTraversalSource gts;

    @Before
    public void connect() {
        ArangoDBConfigurationBuilder configurationBuilder = new ArangoDBConfigurationBuilder();
        configurationBuilder
                .dataBase("cdh514_dev")
                .graph("test")
//                .withVertexCollection("edge")
                .withVertexCollection("software")
                .withVertexCollection("vertex")
//                .withVertexCollection("company")
                .withEdgeCollection("edge")
                .configureEdge("edge", "vertex", "software");

        //
        configurationBuilder.arangoHosts("192.168.1.176:8529")
                .arangoUser("dmp_manager")
                .arangoPassword("dmp_manager@2019");

        BaseConfiguration configuration = configurationBuilder.build();
        Graph graph = GraphFactory.open(configuration);
        gts = new GraphTraversalSource(graph);
    }

    @Test
    public void query() {
        GraphTraversalSource g = gts.clone();
        GraphTraversal<Vertex, Vertex> v = g.V();
        while (v.hasNext()) {
            System.out.println(v.next().value("name").toString());
        }
    }

    @Test
    public void addVertex() {
        GraphTraversalSource g = gts.clone();
        g.addV("vertex").property(T.id, "5")
                .property("name", "lop")
                .property("age", 27).next();

    }

    @Test
    public void addVertex1() {
        GraphTraversalSource g = gts.clone();
        g.addV("software").property(T.id, "6").property("name", "lop").property("lang", "java").next();

    }
    @Test
    public void addEdge() {
        GraphTraversalSource g = gts.clone();
//        Vertex v1 = g.addV("vertex").property(T.id, 6).property("name", "marko").property("age", 29).next();
        GraphTraversal<Vertex, Vertex> v1 = g.V().has("vertex", "name", "lop");
//        if (v1.hasNext()){
//            System.out.println("-----------------------");
//            System.out.println(v1.next());
//        }
        GraphTraversal<Vertex, Vertex> v2 = g.V().has("software", "name", "lop");
//        if (v2.hasNext()){
//            System.out.println(v2.next());
////        g.addV("software").property(T.id, 1).property("name", "lop").property("lang", "java")
//        };
        g = gts.clone();
        g.addE("edge").from(v1.next()).to(v2.next()).property(T.id, "7").next();
    }

    @Test
    public void filter() {
        GraphTraversalSource g = gts.clone();
        GraphTraversal<Vertex, Vertex> vertex = g.V("1").values("name");
        while (vertex.hasNext()) {
            System.out.println(vertex.next().property("name").label());
        }
    }
}
