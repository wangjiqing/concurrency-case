package com.sakura.concurrencycase.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    /* synchronized 修饰代码快 */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    /* synchronized 修饰方法 */
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        /* 1. 修饰代码块：大括号括起来的代码，作用于调用的对象，运行结果是先执行 test1 1 - * 执行完成后再执行 test1 2 - * */
//        executorService.execute(() -> example1.test1(1));
//        executorService.execute(() -> example1.test1(2));

        /* 2. 修饰代码块：大括号括起来的代码，作用于调用的对象，不同的调用对象之间相互不影响运行 运行结果是 test1 1 和 test 1 2 交叉执行 */
//        executorService.execute(() -> example1.test1(1));
//        executorService.execute(() -> example2.test1(2));

        /* 3. 修饰方法：整个方法，作用于调用的对象，运行结果同 1 相似（非相同，由于CPU调度的顺序可能不同，导致 test2 1 和 test 2 2执行顺序不同） */
//        executorService.execute(() -> example1.test2(1));
//        executorService.execute(() -> example1.test2(2));

        /* 4. 修饰方法：整个方法，作用于调用的对象，运行结果同 2 相似 */
        executorService.execute(() -> example1.test2(1));
        executorService.execute(() -> example2.test2(2));

        executorService.shutdown();
    }
}
