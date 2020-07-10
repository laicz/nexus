package com.zhou.haizhi.nexus.mybatis;

/**
 * Create by zhoumingbing on 2020-06-01
 */
public interface BlobMapper {

    Blob findOne(Long id);

    void insert(Blob blob);
}
