package com.allen.thread.group;

/**
 *
 * @Author: lingfeng
 * @Date: 2020/3/29 14:03
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {
        // 获取当前的线程组名字
        String name = Thread.currentThread().getThreadGroup().getName();
        // 复制线程组
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        ThreadGroup threadGroup = new ThreadGroup("test");
        threadGroup.enumerate(threads);

    }
}
