package com.winsion.net.bootstrap.common;

/**
 * Created by zhoucong on 16/5/26
 */
public abstract class ThreadLocalUtilHolder<T> {
    private ThreadLocal<T> holder = new ThreadLocal<>();

    public T get() {
        T inst = holder.get();
        if (inst == null) {
            inst = newInstance();
            holder.set(inst);
        }
        return inst;
    }

    protected abstract T newInstance();
}
