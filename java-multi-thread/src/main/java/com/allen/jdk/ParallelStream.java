package com.allen.jdk;

import java.util.stream.Stream;

/**
 * @Author: lingfeng
 * @Date: 2020/4/22 22:59
 */

public class ParallelStream {

    public static void main(String[] args) {
        // 串行计算
//        serialStream();

        // 并行计算
        parallelStream();
    }

    private static void serialStream() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                })
                .ifPresent(System.out::println);
    }

    private static void parallelStream() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel()
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                })
                .ifPresent(System.out::println);
    }
}
