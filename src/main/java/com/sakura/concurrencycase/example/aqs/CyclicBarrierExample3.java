package com.sakura.concurrencycase.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CyclicBarrierExample3 {

    // 设置 5 个线程互相等待之后 同时执行，同时执行前执行一段代码
    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> log.info("线程准备就绪，开始执行...."));

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
                } catch (BrokenBarrierException e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        // 此处调用等待，当线程数为 5 的时候一起向下执行
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
