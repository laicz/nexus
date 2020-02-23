package com.zhou.haizhi.nexus.gremlin.arango;

import com.arangodb.tinkerpop.gremlin.utils.ArangoDBConfigurationBuilder;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * 会生成符合规则的表，才能使用
 * Create by zhoumingbing on 2019-12-14
 */
public class ArangoDemo2 {

    private GraphTraversalSource gts;

    @Before
    public void connect() {
        ArangoDBConfigurationBuilder configurationBuilder = new ArangoDBConfigurationBuilder();
        configurationBuilder.arangoHosts("192.168.1.176:8529")
                .arangoUser("dmp_manager")
                .arangoPassword("dmp_manager@2019");
        configurationBuilder.dataBase("cdh514_dev");
        configurationBuilder.graph("");
        configurationBuilder.shouldPrefixCollectionNamesWithGraphName(false);
//        HashSet<String> verteics = new HashSet<>();
//        verteics.add("company");
//        verteics.add("person");
//        configurationBuilder.withVertexCollection("company");
        configurationBuilder.withVertexCollection("person");
        BaseConfiguration config = configurationBuilder.build();
        Graph graph = GraphFactory.open(config);
        gts = new GraphTraversalSource(graph);
    }

    @Test
    public void query() {
        GraphTraversalSource g = gts.clone();
        GraphTraversal<Vertex, Vertex> vertex = g.V();
        while (vertex.hasNext()) {
            System.out.println(vertex.next());
        }
    }
}
