//package com.zhou.haizhi.nexus.gremlin.janusgraph;
//
//import org.apache.commons.configuration.MapConfiguration;
//import org.apache.tinkerpop.gremlin.structure.Graph;
//import org.janusgraph.core.ConfiguredGraphFactory;
//import org.janusgraph.core.JanusGraph;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Create by zhoumingbing on 2020-02-18
// */
//public class JansuGraphTest {
//
//    @Test
//    public void test(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("storage.backend", "hbase");
//        map.put("storage.hostname", "192.168.1.244,192.168.1.245,192.168.1.246");
//        map.put("graph.graphname", "graphzhou");
//        ConfiguredGraphFactory.createConfiguration(new MapConfiguration(map));
//
//        JanusGraph graphzhou = ConfiguredGraphFactory.open("graphzhou");
//        Graph.Features features = graphzhou.features();
//
//
//    }
//}
