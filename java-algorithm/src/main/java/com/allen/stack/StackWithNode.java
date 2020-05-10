package com.allen.stack;

/**
 * @Author: lingfeng
 * @Date: 2020/5/8 21:41
 */

import com.allen.linkedlist.Node;

/**
 * 结构特点: FILO
 * 栈只能从从栈顶操作,也就是只能影响最后一个元素
 * 出栈和入栈的时间复杂度为O(1)
 * <p>
 * 使用单向链表实现栈
 */
public class StackWithNode<E> {

    // 栈顶
    private Node<E> headNode;

    private int size;

    public StackWithNode() {
        this(null);
    }

    public StackWithNode(E e) {
        this.headNode = new Node<E>(e);
    }

    /**
     * 返回栈顶元素, 但不删除
     *
     * @return
     */
    public E peek() {
        if (isEmpty())
            return null;
        return headNode.getData();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        if (headNode == null) {
            return true;
        }
        return false;
    }

    /**
     * 压栈
     *
     * @param e
     */
    public void push(E e) {
        if (this.headNode == null) {
            headNode = new Node<>(e);
        } else if (this.headNode.getData() == null) {
            headNode.setData(e);
        } else {
            Node<E> newNode = new Node<>(e);
            newNode.setNext(this.headNode);
            this.headNode = newNode;
        }
    }

    /**
     * 弹栈
     *
     * @return
     */
    public E pop() {
        E data = peek();
        headNode = headNode.getNext();
        return data;
    }


    public static void main(String[] args) {
        StackWithNode<String> stackWithNode = new StackWithNode<>();

        if (stackWithNode.isEmpty()) {
            return;
        }
        stackWithNode.push("node");
        String pop = stackWithNode.pop();
        System.out.println(pop);
    }


}
