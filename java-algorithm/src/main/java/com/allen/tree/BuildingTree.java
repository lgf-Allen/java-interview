package com.allen.tree;

/**
 * @author ligenfeng
 * @date 2020/8/30 3:55 下午
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildingTree {

    public static void main(String[] args) {
        BuildingTree buildingTree = new BuildingTree();
        int[] preorder = new int[]{28, 16, 13, 22, 30, 29, 43};
        int[] inorder = new int[]{13, 16, 22, 28, 29, 30, 43};
        buildingTree.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        // 将中序数组的值和对应的角标缓存起来
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1, 0, valueToIndex);
    }

    private TreeNode createTree(int[] preorder, int preStart, int preEnd, int inStart, Map<Integer, Integer> valueToIndex) {
        //递归停止条件
        if (preStart > preEnd) return null;

        // 前序数组的第一个元素是根节点
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        // 在中序数组中，找到根节点对应的下标
        Integer rootIndex = valueToIndex.get(rootValue);

        // 在中序数组中，根节点的下标减去左节点的起始下标，就是左节点的长度
        int leftLength = rootIndex - inStart;

        // 递归调用
        // 构建左树时，左树的元素是从前序数组的第二个元素起到上一步算出来的数组长度为止
        root.left = createTree(preorder, preStart + 1, preStart + leftLength, inStart, valueToIndex);
        // 构建右树时，右树的元素是从前序数组的第二个元素到左树元素结束的下一个元素起到前序数组的最后一个元素止
        root.right = createTree(preorder, preStart + leftLength + 1, preEnd, rootIndex + 1, valueToIndex);

        return root;
    }
}
