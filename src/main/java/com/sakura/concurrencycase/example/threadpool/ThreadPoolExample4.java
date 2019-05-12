package com.sakura.concurrencycase.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // 延迟三秒执行任务
//        scheduledExecutorService.schedule(() -> log.info("schedule job"), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

        // （使用3个线程）初始化延迟3秒后，每隔2秒执行任务，与Timer类似，可以实现定时任务的功能
        scheduledExecutorService.scheduleAtFixedRate(() -> log.info("schedule job"), 3, 2, TimeUnit.SECONDS);

        // 初始化1秒后执行，每隔2秒中执行一次
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                log.info("timer run");
//            }
//        }, 1 * 1000, 2 * 1000);
    }
}
