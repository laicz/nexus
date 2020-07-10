package com.zhou.haizhi.nexus.mybatis;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 手写一个解析SQL
 * Proxy.newProxyInstance()
 * <p>
 * Create by zhoumingbing on 2020-05-31
 */
public class BaseTest {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(BaseTest.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select selectAnnotation = method.getAnnotation(Select.class);
                String sql = selectAnnotation.value()[0];
                //解析SQL并设置值
                //


                return null;
            }
        });
        userMapper.selectById(5L);

    }
}


interface UserMapper {

    @Select(value = "select * from user where id=#{id}")
    List<User> selectById(Long userId);
}


class User {
    private String name;
}