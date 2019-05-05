package com.sakura.concurrencycase.example.atomic;

import com.sakura.concurrencycase.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class AtomicExample7 {

    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    private static AtomicInteger atomicInteger = new AtomicInteger();

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    count();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappend: {}, count: {}", isHappend.get(), atomicInteger.get());
    }

    private static void test() {
        // 线程只执行一次，当 false 变为 true 后，不会重复执行输出 log.info
        if (isHappend.compareAndSet(false, true)) {
            log.info("execute");
        }
    }

    private static void count() {
        atomicInteger.incrementAndGet();
    }
}
