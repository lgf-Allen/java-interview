package com.allen.sort;

import java.util.Arrays;

/**
 * @author ligenfeng
 * @date 2020/5/19 10:08 下午
 */
public class BubbleSort {

    /**
     * 从小到大冒泡排序.
     *
     * @param array
     */
    public static void basicSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void updateSort(int[] array) {
        int length = array.length;
        // 添加一个标示,后续元素有序不再进行遍历比较
        boolean flag = true;
        int time = 0;
        for (int i = 1; i < length && flag; i++) {
            flag = false;
            for (int j = length - 1; j >= i; j--) {
                time++;
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
        }
        System.out.printf("advancedSort time: %s", time);
    }

    private static void advancedSort(int[] array) {
        int length = array.length;
        boolean exchangeFlag = true;

        int firstExchangeIndex = 0;
        int border = length - 1;
        int time = 0;
        for (int i = 1; i < length && exchangeFlag; i++) {
            exchangeFlag = false;
            boolean firstExchangeFlag = true;
            for (int j = border; j >= i; j--) {
                time++;
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    exchangeFlag = true;
                    // 判断初次进行交换的位置，减少对有序元素的遍历
                    if (firstExchangeFlag) {
                        firstExchangeIndex = j;
                        firstExchangeFlag = false;
                    }
                }
            }
            border = firstExchangeIndex;
        }
        System.out.printf("mostSort time: %s", time);
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 1, 7, 9};
        basicSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{2, 5, 4, 3, 6, 7, 8, 9};
        updateSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[]{2, 5, 4, 3, 6, 7, 8, 9};
        advancedSort(array3);
        System.out.println(Arrays.toString(array3));
    }
}
