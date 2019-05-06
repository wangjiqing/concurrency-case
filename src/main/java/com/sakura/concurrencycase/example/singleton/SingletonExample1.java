package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.NotThreadSafe;

/**
 * 懒汉式单例模式：单例实例会在第一次调用的时候创建
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造方法
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
