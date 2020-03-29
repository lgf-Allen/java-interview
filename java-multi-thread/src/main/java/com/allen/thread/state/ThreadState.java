package com.allen.thread.state;

/**
 * @Author: lingfeng
 * @Date: 2020/3/29 20:30
 */

public class ThreadState {
    public enum State {
        /**
         * 线程尚未启动，也就是是线程还没调用Thread实例的start()方法
         */
        NEW,

        /**
         * 表示当前线程正在运行中。
         * 处于RUNNABLE状态的线程在Java虚拟机中运行，也有可能在等待其他系统资源（比如I/O）
         */
        RUNNABLE,

        /**
         * 阻塞状态。处于BLOCKED状态的线程正等待锁的释放以进入同步区。
         */
        BLOCKED,

        /**
         * 等待状态。处于等待状态的线程变成RUNNABLE状态需要其他线程唤醒。
         * <p>
         * 调用如下3个方法会使线程进入等待状态：
         * Object.wait()：使当前线程处于等待状态直到另一个线程唤醒它；
         * Thread.join()：等待线程执行完毕，底层调用的是Object实例的wait方法；
         * LockSupport.park()：除非获得调用许可，否则禁用当前线程进行线程调度。
         */
        WAITING,

        /**
         * 超时等待状态。线程等待一个具体的时间，时间到后会被自动唤醒。
         * <p>
         * 调用如下方法会使线程进入超时等待状态：
         * Thread.sleep(long millis)：使当前线程睡眠指定时间；
         * Object.wait(long timeout)：线程休眠指定时间，等待期间可以通过notify()/notifyAll()唤醒；
         * Thread.join(long millis)：等待当前线程最多执行millis毫秒，如果millis为0，则会一直执行；
         * LockSupport.parkNanos(long nanos)： 除非获得调用许可，否则禁用当前线程进行线程调度指定时间；
         * LockSupport.parkUntil(long deadline)：同上，也是禁止线程进行调度指定时间；
         */
        TIMED_WAITING,

        /**
         * 终止状态。此时线程已执行完毕。
         */
        TERMINATED;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        // output: NEW
        System.out.println(thread.getState());

        blockedTest();

    }

    public static void blockedTest() {

        Thread a = new Thread(() -> testMethod(), "a");
        Thread b = new Thread(() -> testMethod(), "b");

        // 线程a启动执行run()需要时间,等到线程b启动的时候锁已经释放，所以都会输出RUNNABLE
        a.start();
        try {
            // 主线程等待1000ms,两个线程刚好进入争抢资源的时候
            // 线程a state:TIMED_WAITING
            // 线程b state:RUNNABLE
            Thread.currentThread().sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }

    // 同步方法争夺锁
    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
