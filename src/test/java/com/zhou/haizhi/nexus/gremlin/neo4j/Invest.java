package com.zhou.haizhi.nexus.gremlin.neo4j;

/**
 * Create by zhoumingbing on 2019-12-20
 */
public class Invest {

    private String key;

    private String name;

    private String date;

    private String fromKey;

    private String toKey;

    private Integer amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromKey() {
        return fromKey;
    }

    public void setFromKey(String fromKey) {
        this.fromKey = fromKey;
    }

    public String getToKey() {
        return toKey;
    }

    public void setToKey(String toKey) {
        this.toKey = toKey;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
