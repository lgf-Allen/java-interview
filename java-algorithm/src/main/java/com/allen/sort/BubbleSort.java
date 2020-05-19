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

    public static void advancedSort(int[] array) {
        int length = array.length;
        boolean flag = true;
        for (int i = 1; i < length && flag; i++) {
            flag = false;
            for (int j = length - 1; j >= i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 1, 7, 9};
        basicSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{44, 5, 21, 7, 9};
        advancedSort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
