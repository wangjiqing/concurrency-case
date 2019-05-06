package com.sakura.concurrencycase.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 此场景描述的是例如 在指定的时间内让多个线程执行一个任务，
 * 超过该时间后剩下的线程执行情况丢弃，但是剩下的线程依旧会继续执行
 */
@Slf4j
public class CountDownLatchExample2 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();
        // 创建一个闭锁，计数器 200
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown(); // 调用此方法，计数器 -1
                }
            });
        }
        // 调用此方法会一直阻塞当前线程，直到计数器的值为0，除非线程被中断。主线程通过await方法，恢复自己的任务
        countDownLatch.await(10, TimeUnit.MILLISECONDS);    // 阻塞10ms时间就通过
        log.info("finish!");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);  // 单个线程执行方法时等待100ms
        log.info("{}", threadNum);
    }
}
