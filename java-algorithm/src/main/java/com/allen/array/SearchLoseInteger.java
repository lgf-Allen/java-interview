package com.allen.array;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author ligenfeng
 * @date 2020/5/20 10:38 下午
 */
public class SearchLoseInteger {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 5};
        searchOne(input, 5);

        searchLoseNumbers(input, 5);

        int[] input2 = new int[]{1, 2, 3, 5, 7, 9, 10};
        searchLoseNumbers(input2, 10);
    }

    /**
     * 从一个连续的数组中，找到不存在的某个元素
     *
     * @param input
     * @param exceptedSize
     */
    public static void searchOne(int[] input, int exceptedSize) {
        int exceptionSum = exceptedSize * (exceptedSize + 1) / 2;
        int realSum = 0;
        for (int i : input) {
            realSum += i;
        }
        System.out.printf("lose number is %d", exceptionSum - realSum);
    }

    /**
     * 从一个连续的数组中，找出缺失的某些元素
     * 使用BitSet
     *
     * @param input
     * @param count
     */
    public static void searchLoseNumbers(int[] input, int count) {
        int loseNumberSize = count - input.length;
        BitSet bitSet = new BitSet(count);
        for (int num : input) {
            bitSet.set(num - 1);
        }
        System.out.printf("Missing numbers in integer array %s, with total number %d \n",
                Arrays.toString(input), count);

        int lastMissingIndex = 0;
        for (int i = 0; i < loseNumberSize; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println("lose number is " + (++lastMissingIndex));
        }
    }
}
