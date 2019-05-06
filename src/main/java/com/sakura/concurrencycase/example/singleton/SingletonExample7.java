package com.sakura.concurrencycase.example.singleton;

import com.sakura.concurrencycase.annotation.Recommend;
import com.sakura.concurrencycase.annotation.ThreadSafe;

/**
 * 枚举类实现单例模式（最安全的方式）
 */
@Recommend
@ThreadSafe
public class SingletonExample7 {

    // 私有构造方法
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM绝对保证仅调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

}
