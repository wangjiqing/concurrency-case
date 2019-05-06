package com.sakura.concurrencycase.example.immutable;

import com.google.common.collect.Maps;
import com.sakura.concurrencycase.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        // 编译不通过
//        a = 2;
//        b = "b";
//        map = Maps.newHashMap();

        // 引用类型变量表示指向对象不可变，但是对象中的内容是可以改变的
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    public void test(final int a) {
        // 编译不通过
//        a = 6;
    }
}
