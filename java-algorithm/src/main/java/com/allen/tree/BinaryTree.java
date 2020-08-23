package com.allen.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ligenfeng
 * @date 2020/8/23 11:07 上午
 */

/**
 * 二叉树的遍历方式：
 * 从节点之间位置关系来分：
 * 1. 前序遍历
 * 2. 中序遍历
 * 3. 后序遍历
 * 4. 层序遍历
 * 宏观角度来分：深度优先算法和广度优先算法
 */
public class BinaryTree {

    public static TreeNode createTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.size() == 0) {
            return null;
        }
        TreeNode node = null;
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftNode = createTree(inputList);
            node.rightNode = createTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftNode);
        preOrderTraveral(node.rightNode);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftNode);
        System.out.println(node.data);
        inOrderTraveral(node.rightNode);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftNode);
        postOrderTraveral(node.rightNode);
        System.out.println(node.data);
    }

    /**
     * 使用栈实现前序遍历
     *
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.leftNode;
            }
            // 如果节点没有左孩子，则弹出栈顶元素，访问节点右孩子
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightNode;
            }
        }
    }


    /**
     * 层序遍历
     *
     * @param node
     */
    public static void levelOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.data);
            TreeNode leftNode = poll.leftNode;
            if (leftNode != null) {
                queue.offer(leftNode);
            }
            TreeNode rightNode = poll.rightNode;
            if (rightNode != null) {
                queue.offer(rightNode);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays
                .asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode node = createTree(inputList);

        System.out.println("前序遍历：");
        preOrderTraveral(node);
        System.out.println("中序遍历：");
        inOrderTraveral(node);
        System.out.println("后序遍历：");
        postOrderTraveral(node);
        System.out.println("使用栈实现前序遍历:");
        preOrderTraveralWithStack(node);
        System.out.println("层序遍历：");
        levelOrderTraveral(node);
    }


}
