package com.sakura.concurrencycase.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample4 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                log.info("wait signal...");     // 1
                condition.await();
            } catch (InterruptedException e) {
                log.warn("exception", e);
            } finally {
                lock.unlock();
            }
            log.info("get signal");             // 4
        }).start();

        new Thread(() -> {
            lock.lock();
            log.info("get lock");               // 2
            try {
                Thread.sleep(3000);
                condition.signalAll();
                log.info("send signal ~ ");     // 3
            } catch (InterruptedException e) {
                log.warn("exception", e);
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
