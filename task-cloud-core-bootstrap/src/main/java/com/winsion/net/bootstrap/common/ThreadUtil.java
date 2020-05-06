package com.winsion.net.bootstrap.common;

import java.util.UUID;

public class ThreadUtil {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public static void daemonRun(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("daemon-worker-" + UUID.randomUUID().toString());
        thread.setDaemon(true);
        thread.start();
    }
}
