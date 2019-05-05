package com.sakura.concurrencycase.example.atomic;

import com.sakura.concurrencycase.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();

        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success 120, {}", atomicExample5.getCount());  // 执行
        }

        if (updater.compareAndSet(atomicExample5, 100, 130)) {  // 不执行
            log.info("update success 130, {}", atomicExample5.getCount());
        } else {
            log.error("update failed 130, {}", atomicExample5.getCount());  // 执行
        }
    }
}
