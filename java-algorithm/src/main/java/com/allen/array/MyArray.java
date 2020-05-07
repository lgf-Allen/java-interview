package com.allen.array;

/**
 * @Author: lingfeng
 * @Date: 2020/5/4 16:58
 */

/**
 * 1. 定义: 有限个相同类型的变量所组成的有序集合
 * 2. 数组在内存中是顺序存储
 * 3. 数组中的元素在内存中是连接存储的
 * 4. 例子：
 * int[] sample = new int[]{8, 7, 5, 3, 6, 6};
 * Data:  8--7--5--3--6--6
 * Index: 0--1--2--3--4--5
 */
public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
