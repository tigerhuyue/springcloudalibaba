package com.winsion.net.bootstrap.common;

import java.util.Random;

/**
 * Created by zhoucong on 16/4/20
 */
public class RandomUtil extends ThreadLocalUtilHolder<Random> {
    private static class RandomUtilSingletonHolder {
        static RandomUtil instance = new RandomUtil();
    }

    public static Random getRandom(){
        return RandomUtilSingletonHolder.instance.get();
    }

    @Override
    protected Random newInstance() {
        return new Random();
    }
}
