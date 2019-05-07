package com.sakura.concurrencycase.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);    // 设置 5 个线程互相等待之后 同时执行

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        // 此处调用等待，当线程数为 5 的时候一起向下执行，支持传入等待时间，超出等待时间后直接执行（需要捕获指定的异常）
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException e) {
            log.warn("BrokenBarrierException", e.getMessage());
        } catch (TimeoutException e) {
            log.warn("TimeoutException", e.getMessage());
        }
        log.info("{} continue", threadNum);
    }
}
