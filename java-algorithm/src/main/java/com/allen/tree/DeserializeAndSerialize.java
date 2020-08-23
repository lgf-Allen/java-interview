package com.allen.tree;

/**
 * @author ligenfeng
 * @date 2020/8/23 9:55 下午
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * leetcode 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 *     1
 *    / \
 *   2   3
 *     /   \
 *    4     5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeserializeAndSerialize {
    private static final String SEP = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        serialize(node, sb);
        return sb.toString();
    }

    public static void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.data).append(SEP);
        TreeNode leftNode = node.leftNode;
        serialize(leftNode, sb);
        TreeNode rightNode = node.rightNode;
        serialize(rightNode, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.leftNode = deserialize(nodes);
        root.rightNode = deserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays
                .asList(new Integer[]{2, 3, 5, null, null, 6, null, null, 4, null, 8, null, null}));
        TreeNode node = BinaryTree.createTree(inputList);
        String nodeString = serialize(node);
        System.out.println(nodeString);
        TreeNode deserialize = deserialize(nodeString);
        System.out.println(deserialize);
    }
}
