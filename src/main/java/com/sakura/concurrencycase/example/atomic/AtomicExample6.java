package com.sakura.concurrencycase.example.atomic;

import com.sakura.concurrencycase.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLongArray;

@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicLongArray atomicLongArray = new AtomicLongArray(10);

    public static void main(String[] args) {
        // 给数组下标为1的数组赋值为2
        atomicLongArray.addAndGet(1, 2);
        if (atomicLongArray.compareAndSet(1, 2, 3)) {
            log.info("数组中的下标为1的元素值由 2 -> 3");
        }

        if (atomicLongArray.compareAndSet(1, 2, 4)) {
            log.info("该行不执行！"); // 此行由于CAS代码不执行
        }

        if (atomicLongArray.compareAndSet(1, 3, 4)) {
            log.info("数组中的下标为1的元素值由 3 -> 4");
        }
    }
}
