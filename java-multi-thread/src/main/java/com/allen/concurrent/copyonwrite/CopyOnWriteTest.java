package com.allen.concurrent.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: lingfeng
 * @Date: 2020/4/22 21:28
 */

/**
 * CopyOnWriteArrayList 基于{@link java.util.concurrent.locks.ReentrantLock}实现写时复制
 * CopyOnWrite容器有数据一致性的问题，它只能保证最终数据一致性;
 * 如果我们希望写入的数据马上能准确地读取，请不要使用CopyOnWrite容器
 *
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.remove(2);
    }
}
