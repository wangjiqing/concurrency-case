package com.sakura.concurrencycase.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 执行场景：20个线程中同时执行，控制一次执行时只能执行最多10个线程，结果时只有10个线程执行，其余线程全部被丢弃
 */
@Slf4j
public class SemaphoreExample3 {

    private static final int threadCount = 20;

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(10);   // 流控控制，每次只能允许最多10个线程执行

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) {     // 尝试获取许可，可以尝试获取多个许可，也可以尝试获取许可的时候设置等待时间
                        test(threadNum);
                        semaphore.release();    // 释放一个许可
                    }
                } catch (InterruptedException e) {
                    log.error("exception", e);
                } finally {

                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);     // 每隔 1s sleep
    }
}
