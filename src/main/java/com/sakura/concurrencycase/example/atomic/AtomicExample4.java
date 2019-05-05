package com.sakura.concurrencycase.example.atomic;

import com.sakura.concurrencycase.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);  // 执行
        count.compareAndSet(0, 1);  // 不执行
        count.compareAndSet(1, 3);  // 不执行
        count.compareAndSet(2, 4);  // 执行
        count.compareAndSet(3, 5);  // 不执行
        log.info("count: {}", count.get());
    }
}
