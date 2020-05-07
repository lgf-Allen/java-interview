package com.allen.linkedlist;

/**
 * @Author: lingfeng
 * @Date: 2020/5/7 23:01
 */

public class MyLinkedList {
    // 头节点指针
    private Node head;
    // 尾节点指针
    private Node last;
    // 链表实际长度
    private int size;

    /**
     * 插入元素
     *
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node insertNode = new Node(data);
        // 空链表
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            // 插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            // 插入中间
            Node prev = get(index - 1);
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
    }

    /**
     * 查找元素
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode = null;
        if (index == 0) {
            // 删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node preNode = get(index - 1);
            removeNode = last;
            preNode.next = null;
            last = preNode;
        } else {
            // 删除中间节点
            Node preNode = get(index - 1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println("while loop result:" + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.size = 5;
        list.insert(3,0);
        list.insert(7,1);
        list.insert(9,2);
        list.insert(5,3);
        list.insert(6,1);
        list.remove(0);
        list.output();
    }

}
