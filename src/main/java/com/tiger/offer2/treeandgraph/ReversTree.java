package com.tiger.offer2.treeandgraph;

/**
 * 翻转二叉树
 * 难度等级 EASY
 */
public class ReversTree {

    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
