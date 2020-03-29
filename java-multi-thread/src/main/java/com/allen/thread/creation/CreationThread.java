package com.allen.thread.creation;

/**
 * 创建Thread主要有两种方式:
 * 1. extends Thread
 * 2. implements Runnable
 * <p>
 * 以上两种方式的区别：
 * 1. 由于Java“单继承，多实现”的特性，Runnable接口使用起来比Thread更灵活
 * 2. Runnable接口出现更符合面向对象，将线程单独进行对象的封装
 * 3. Runnable接口出现，降低了线程对象和线程任务的耦合性
 * 4. 如果使用线程时不需要使用Thread类的诸多方法，显然使用Runnable接口更为轻量
 *
 * @Author: lingfeng
 * @Date: 2020/3/29 11:29
 */
public class CreationThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        // 同一个线程只能调用一次start(),在调用一次start()之后，threadStatus的值会改变（threadStatus !=0）,
        // 多次调用会抛出IllegalThreadStateException();
        //myThread.start();

        /**
         * 匿名内部类+lambda表达式
         */
        new Thread(() -> {
            System.out.println("Hello, anonymous inner class.");
        }).start();
    }

    private static class MyThread extends Thread {
        @Override
        public synchronized void start() {
            super.start();
            System.out.println("Hello, my thread.");
        }
    }
}
