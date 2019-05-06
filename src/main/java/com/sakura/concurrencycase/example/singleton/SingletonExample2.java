package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.ThreadSafe;

/**
 * 饿汉式单例模式：单例实例会在类装载的时候创建
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造方法
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
