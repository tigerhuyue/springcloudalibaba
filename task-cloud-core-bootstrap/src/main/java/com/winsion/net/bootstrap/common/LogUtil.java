package com.winsion.net.bootstrap.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    public static void error(String message, Throwable throwable) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.error(message,throwable);
    }

    public static void error(Throwable throwable) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.error(throwable.getMessage(), throwable);
    }

    public static void trace(String msg) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.trace(msg);
    }

    public static void debug(String msg) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.debug(msg);
    }

    public static void info(String msg) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.info(msg);
    }

    public static void warn(String msg) {
        Logger log = LoggerFactory.getLogger(LogUtil.class);
        log.warn(msg);
    }
}
