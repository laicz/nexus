package com.zhou.haizhi.nexus.gremlin.neo4j;

import com.google.common.collect.ImmutableList;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 造模拟数据
 * Create by zhoumingbing on 2019-12-20
 */
public class MockDataDemo {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void press() {
        int vertexSize = 100000;
        int edgeSize = 100000;
        long st = System.currentTimeMillis();

        List<Company> companies = new ArrayList<>(vertexSize);
        List<String> vertexShells = new ArrayList<>(vertexSize);
        for (int i = 0; i < vertexSize; i++) {
            Company company = new Company();
            company.setKey("company/id" + i);
            company.setName("公司名称" + 1);
            company.setAddress("公司地址" + 1);

            companies.add(company);
            vertexShells.add("g.addV(\"company\").property(\"key\",\"" + company.getKey() + "\").property(\"name\",\"" + company.getName() + "\").property(\"address\",\"" + company.getAddress() + "\").next();");
        }

//        List<Person> persons = new ArrayList<>();
//        for (int i = 0; i < 30000; i++) {
//            Person person = new Person();
//            person.setKey("person/id" + 1);
//            person.setAge(i);
//            person.setName("人员名称" + i);
//
//            persons.add(person);
//        }

        List<Invest> invests = new ArrayList<>(edgeSize);
        List<String> edgeShells = new ArrayList<>(edgeSize);
        for (int i = 0; i < edgeSize; i++) {
            Invest invest = new Invest();
            invest.setKey("invest/id" + i);
            invest.setName("投资关系" + i);
            invest.setFromKey(companies.get(new Random().nextInt(vertexShells.size())).getKey());
            invest.setToKey(companies.get(new Random().nextInt(vertexShells.size())).getKey());
            invest.setAmount(new Random().nextInt(100000000));
            invest.setDate(sdf.format(new Date()));

            invests.add(invest);
            edgeShells.add("v1 = g.V().hasLabel(\"company\").has(\"key\", \"" + invest.getFromKey() + "\");v2 = g.V().hasLabel(\"company\").has(\"key\", \"" + invest.getToKey() + "\");g.addE(\"invest\").property(\"key\",\"" + invest.getKey() + "\").property(\"name\",\"" + invest.getName() + "\").property(\"date\",\"" + invest.getDate() + "\").property(\"amount\"," + invest.getAmount() + ").from(v1).to(v2).next();");
        }

        Configuration configuration = new BaseConfiguration();
        configuration.addProperty("hosts", ImmutableList.of("192.168.1.57"));
        configuration.addProperty("port", 8182);
        Cluster cluster = Cluster.open(configuration);
        Client client = cluster.connect();
        StringBuilder vertex = new StringBuilder();
        for (int i = 0; i < vertexShells.size(); i++) {
            if (i % 1 == 0 && StringUtils.isNotBlank(vertex)) {
                client.submit(vertex.toString());
                vertex = new StringBuilder();
            }
//
            vertex.append(vertexShells.get(i));
//            System.out.println(vertexShells.get(i));
//            client.submitAsync(vertexShells.get(i));
        }
        if (StringUtils.isNotBlank(vertex)){
            client.submit(vertex.toString());
        }
        System.out.println("-----------------edge------------------");
        StringBuilder edge = new StringBuilder();
        for (int i = 0; i < edgeShells.size(); i++) {
            if (i % 1 == 0 && StringUtils.isNotBlank(edge)) {
                client.submit(edge.toString());
                edge = new StringBuilder();
            }
            edge.append(edgeShells.get(i));
//            System.out.println(edgeShells.get(i));
//            client.submitAsync(edgeShells.get(i));
        }
        if (StringUtils.isNotBlank(edge)){
            client.submit(edge.toString());
        }
        System.out.println("共耗时：" + (System.currentTimeMillis() - st) + " ms");
        client.close();
        cluster.close();
    }

}
