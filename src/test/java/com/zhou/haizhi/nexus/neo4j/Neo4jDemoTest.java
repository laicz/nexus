package com.zhou.haizhi.nexus.neo4j;

import org.junit.Test;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Create by zhoumingbing on 2019-12-19
 */
public class Neo4jDemoTest {

    @Test
    public void createSmallGraph() {
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("/tmp/neo4j2"));
        Transaction transaction = graphDb.beginTx();
//        ResourceIterator<Node> person = graphDb.findNodes(Label.label("Person"));
        ResourceIterator<Node> iterator = graphDb.getAllNodes().iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            Iterable<String> propertyKeys = node.getPropertyKeys();
            propertyKeys.forEach(key -> {
                System.out.print("[" + key + " -> " + node.getProperty(key) + "] ");
            });
            System.out.println();
        }
        transaction.close();
    }
}
