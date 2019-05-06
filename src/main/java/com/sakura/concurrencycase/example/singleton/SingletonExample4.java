package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.NotThreadSafe;

/**
 * 懒汉式单例模式：单例实例会在第一次调用的时候创建
 * 双重同步锁单例模式
 * 不推荐的改造
 * 由于指令重排序的存在，在多线程环境下还是会出现线程不安全的情况，尽管影响不大
 */
@NotThreadSafe
public class SingletonExample4 {

    // 私有构造方法
    private SingletonExample4() {

    }

    // 单例对象
    private static SingletonExample4 instance = null;

    /**
     单线程条件下指令如下：
        1. memory = allocate() 分配对象的内存空间
        2. ctorInstance() 初始化对象
        3. instance = memory 设置 instance 指向刚分配的内存

     多线程条件下： JVM和CPU的优化，发生指令重排序，指令执行顺序如下：
        1. memory = allocate() 分配对象的内存空间
        2. instance = memory 设置 instance 指向刚分配的内存
        3. ctorInstance() 初始化对象
     */

    // 静态工厂方法
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
