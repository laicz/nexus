package com.zhou.haizhi.nexus.design.single;

/**
 * 单例模式 - 双重检查
 *
 * @author zhoumingbing
 * @data 2021/5/1
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {

    }

    /**
     * 获取实例的时候，需要先进行判断，如果需要创建，则对创建对象的过程需要加锁
     * @return
     */
    public static DoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
