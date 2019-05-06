package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.ThreadSafe;

/**
 * 饿汉式单例模式：单例实例会在类装载的时候创建
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有构造方法
    private SingletonExample6() {

    }

    /*
        放在这里是错误的
        static {
            instance = new SingletonExample6();
        }
    */

    // 单例对象
    private static SingletonExample6 instance;

    // 使用静态代码块改造饿汉式单例模式，静态代码块需放在单例对象后面生命，不可以放在单例对象💰生命
    static {
        instance = new SingletonExample6();
    }

    // 静态工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
