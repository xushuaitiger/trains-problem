package com.tiger.offer2.treeandgraph;

import java.util.LinkedList;

/**
 * 广度优先二叉树序列化和反序列化
 */
public class 二叉树的序列化和反序列化广度优先 {

    // 序列化
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(String.valueOf(t.val) + ",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();

            if (t == null)
                continue;

            if (!arr[i].equals("#")) {
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.left);

            } else {
                t.left = null;
                queue.offer(null);







            }
            i++;

            if (!arr[i].equals("#")) {
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.right);

            } else {
                t.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }
}

