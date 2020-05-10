package com.allen.linkedlist;

/**
 * @Author: lingfeng
 * @Date: 2020/5/5 21:52
 */

/**
 * 链表是一种在物理上非连续、非顺序的数据结构, 由若干节点所组成
 * <p>
 * 单向链表: 单向链表的每一个节点包含两部分: 一部分是存放数据的变量data, 另一部分是指向下一节点的指针next
 * 查找: 只能顺序查找, 所以时间复杂度为O(n)
 * 更新: 若不考虑查找节点的过程,链表的更新会像数组一样简单, 时间复杂度为O(1)
 * 如果不考虑插入、删除操作之前查找元素的过程, 只考虑纯粹的插入和删除操作, 时间复杂度为O(1)
 */

public class Node<E> {

    E data;
    Node next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        String input = ";";
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
