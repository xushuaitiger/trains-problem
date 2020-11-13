package com.tiger.offer2.treeandgraph;

public class 先序遍历构造二叉树 {
    int index =0;
    int[] preorder;
    int n=0;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode helper(int lowerBound,int upperBoud){
        if(n==index) return null;
        int curr = preorder[index];
        index++;
        if(curr<lowerBound || curr>upperBoud) return null;
        TreeNode root = new TreeNode(curr);
        root.left = helper(lowerBound,curr);
        root.right = helper(curr,upperBoud);
        return root;
    }

    public static void main(String[] args){
        int[] test = new int[]{3,2,1};
        new 先序遍历构造二叉树().bstFromPreorder(test);
    }
}
