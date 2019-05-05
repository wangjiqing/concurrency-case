package com.sakura.concurrencycase.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    /* synchronized 修饰代码快 */
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    /* synchronized 修饰方法 */
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        /* 1. 修饰静态方法：整个静态方法，作用于所有对象，运行结果是先执行 test2 1 - [0, 9] 然后再执行 test2 2 - [0, 9] */
//        executorService.execute(() -> example1.test2(1));
//        executorService.execute(() -> example2.test2(2));

        /* 1. 修饰类：括号括起来的部分，作用于所有对象，运行结果是先执行 test1 1 - [0, 9] 然后再执行 test1 2 - [0, 9] */
        executorService.execute(() -> example1.test1(1));
        executorService.execute(() -> example2.test1(2));

        executorService.shutdown();
    }
}
