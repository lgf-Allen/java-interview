package com.allen.stack;

/**
 * @Author: lingfeng
 * @Date: 2020/5/10 10:12
 */

/**
 * 使用数组实现栈,因为数组没法实现动态扩容，所以此处需要考虑数组空扩容
 */
public class StackWithArray<E> {

    private Object[] elementData;

    protected int elementCount;
}

