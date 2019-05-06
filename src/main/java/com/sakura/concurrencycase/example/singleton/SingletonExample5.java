package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.ThreadSafe;

/**
 * 懒汉式单例模式：单例实例会在第一次调用的时候创建
 * 双重同步锁单例模式
 * volatile 禁止指令重排序保证线程安全性
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造方法
    private SingletonExample5() {

    }

    // 单例对象
    /* 使用 volatile 修饰禁止指令重排序，保证全程安全性 */
    private volatile static SingletonExample5 instance = null;

    /*
        1. memory = allocate() 分配对象的内存空间
        2. ctorInstance() 初始化对象
        3. instance = memory 设置 instance 指向刚分配的内存
    */

    // 静态工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
