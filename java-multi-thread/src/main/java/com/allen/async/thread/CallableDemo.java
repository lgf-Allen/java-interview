package com.allen.async.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTask能够在高并发环境下确保任务只执行一次,{@link FutureTask},内部使用CAS
 * FutureTask的状态流转可能流程：
 * <p>
 * NEW—>COMPLETING—>NORMAL（任务执行正常）
 * <p>
 * NEW—>COMPLETING—>EXCEPTIONAL（任务执行异常）
 * <p>
 * NEW—>CANCELLED（不允许执行中的取消）
 * <p>
 * NEW—>INTERRUPTING—>INTERRUPTED（允许执行中的取消）
 *
 * @Author: lingfeng
 * @Date: 2020/3/29 13:05
 */

public class CallableDemo {
    // 自定义Callable
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 模拟计算需要一秒
            Thread.sleep(5000);
            return 2;
        }

        public static void main(String args[]) throws ExecutionException, InterruptedException {
            // 使用
            ExecutorService executor = Executors.newCachedThreadPool();
            // 使用实现Callable接口的Task
            Task task = new Task();
            // TODO 调用executor.submit(Callabel<T> call),返回Future<T>
            Future<Integer> result = executor.submit(task);
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println(result.get());

            FutureTask<Integer> futureTask = new FutureTask<>(new Task());
            // TODO 调用executor.submit(Runnable run),调用成功返回null
            Future submit = executor.submit(futureTask);
            // 返回null
            System.out.println("submit get: " + submit.get());
            // TODO futureTask.get()才是实际的返回值
            System.out.println("FutureTask return: " + futureTask.get());
            executor.shutdown();
        }
    }
}
