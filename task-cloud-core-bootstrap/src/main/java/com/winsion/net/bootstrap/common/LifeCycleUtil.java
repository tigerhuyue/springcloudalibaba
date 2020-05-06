package com.winsion.net.bootstrap.common;

public class LifeCycleUtil {
    private static volatile boolean APPLICATION_RUN_SIGNAL = true;

    public static void applicationStart() {
        APPLICATION_RUN_SIGNAL = true;
    }

    public static void applicationStop() {
        APPLICATION_RUN_SIGNAL = false;
    }

    public static boolean isApplicationRun() {
        return APPLICATION_RUN_SIGNAL;
    }
}
