package com.allen.array;

/**
 * @Author: lingfeng
 * @Date: 2020/5/4 17:03
 */

/**
 * 数组的操作方式: 增删改查
 * <p>
 * 数组适合读操作多，写操作少的场景
 * <p>
 * 数组的查找和修改操作时间复杂度为O(1)
 * <p>
 * 数组的增加和删除涉及元素移位操作，时间复杂度为O(n)
 */
public class MyArrayOperation {

    public static void insertLast(MyArray array, int index, int element) {
        int[] arr = array.getArray();
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("超过数组实际长度");
        }
        arr[index] = element;
        int size = array.getSize();
        size++;
    }

    public static void insertMiddle(MyArray array, int index, int element) {
        int[] arr = array.getArray();
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("超过数组实际长度");
        }
        int size = array.getSize();
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    public static void insertMoreCapacity(MyArray array, int index, int element) {
        int[] arr = array.getArray();
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("超过数组实际长度");
        }
        if (index >= arr.length) {
            resize(array);
        }
        int size = array.getSize();
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    private static void resize(MyArray array) {
        int[] array1 = array.getArray();
        int[] newArray = new int[array1.length * 2];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        array.setArray(newArray);
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(10);
        int[] array1 = array.getArray();
        array1[0] = 1;
        array1[1] = 1;
        array1[2] = 1;
        array1[3] = 1;
        array1[4] = 1;
        array.setSize(5);

//        insertLast(array, 6, 6);
        insertMiddle(array, 2, 2);
    }
}
