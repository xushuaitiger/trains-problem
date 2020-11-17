package com.tiger.offer2.treeandgraph;

public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {

        new 二叉树的深度().maxDepth(TreeNodeTestCase.B);
        //String s = "";
        //testString(s);
        //System.out.println("haha:"+s);
    }
}
