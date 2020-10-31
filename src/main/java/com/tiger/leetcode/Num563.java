package com.tiger.leetcode;

import javax.swing.tree.TreeNode;

public class Num563 {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode temp = root;
        int sumLeft = 0, sumRight = 0;
        while (root.left != null) {
            int val = root.left == null ? 0 : root.left.val;
            sumLeft += val;
            root = root.left;
        }

        while (temp.right != null) {
            int val = temp.right == null ? 0 : temp.right.val;
            sumRight += val;
            temp = temp.right;
        }
        return sumLeft - sumRight > 0 ? sumLeft - sumRight : sumRight - sumLeft;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
