package com.allen.thread.communication;

/**
 * 线程同步的方式：
 * 1. 加锁 {@link ObjectLock}
 * 2. 等待和唤醒机制 {@link WaitAndNotify},
 * Java多线程的等待/通知机制是基于Object类的wait()方法和notify(), notifyAll()方法来实现的。
 * 3. 信号量 {@link Signal}
 *
 * @Author: lingfeng
 * @Date: 2020/3/29 21:16
 */

public class ObjectLock {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

}
