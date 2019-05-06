package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.NotRecommend;
import com.sakura.concurrencycase.annotation.ThreadSafe;

/**
 * 懒汉式单例模式：单例实例会在第一次调用的时候创建
 * 不推荐的改造
 */
@NotRecommend
@ThreadSafe
public class SingletonExample3 {

    // 私有构造方法
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态工厂方法
    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
