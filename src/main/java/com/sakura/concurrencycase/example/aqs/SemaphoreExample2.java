package com.sakura.concurrencycase.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 执行结果可以看到 程序是 一段一段的执行的，
 * 由于线程执行的时候一次获取了两个许可，归还的时候一次归还两个许可，所以一次最多有一次执行结果
 */
@Slf4j
public class SemaphoreExample2 {

    private static final int threadCount = 200;

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(2);   // 流控控制，每次只能允许最多两个线程执行

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(2);    // 获取2个许可
                    test(threadNum);
                    semaphore.release(2);    // 释放2个许可
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
