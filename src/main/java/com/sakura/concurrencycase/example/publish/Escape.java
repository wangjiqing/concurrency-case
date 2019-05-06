package com.sakura.concurrencycase.example.publish;

import com.sakura.concurrencycase.annotation.NotRecommend;
import com.sakura.concurrencycase.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        // 执行的时候调用主类的构造方法，此时主类的对象还没有构造完成 即打印了 内部类中的 log，表示对象逸出
        new Escape();
    }
}
