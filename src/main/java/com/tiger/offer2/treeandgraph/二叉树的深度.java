package com.tiger.offer2.treeandgraph;

public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        System.out.println("当前节点="+root.val);
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        System.out.println("当前节点="+root.val+",left="+left+",right="+right);
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
/**
 *                    56
 *                   /   \
 *                   2 3   9 8
 *                  / \   / \
 *                 12 54  67 99
 *                 */
        new 二叉树的深度().maxDepth(BinarySearchTreeTestCase.BINARY_SEARCH);
        //String s = "";
        //testString(s);
        //System.out.println("haha:"+s);
    }
}
