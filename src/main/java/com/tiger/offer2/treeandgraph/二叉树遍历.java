package com.tiger.offer2.treeandgraph;
/**
 *                    56
 *                   /   \
 *                   2 3   9 8
 *                  / \   / \
 *                 12 54  67 99
 *                 */
public class 二叉树遍历 {
    //中序遍历
    public static void inOrderTraversal(TreeNode root){
        if(root ==null) return;
        if(root !=null){
            inOrderTraversal(root.left);
            System.out.println(root.val); //中序遍历 访问树结点
            inOrderTraversal(root.right);
        }
    }

    //前序遍历
    public static void preOrderTraversal(TreeNode root){
        if(root ==null) return;
        if(root !=null){
            System.out.println(root.val); //前序遍历 访问树结点
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    //后序遍历
    public static void afterOrderTraversal(TreeNode root){
        if(root ==null) return;
        if(root !=null){
            afterOrderTraversal(root.left);
            afterOrderTraversal(root.right);
            System.out.println(root.val); //后序遍历 访问树结点
        }
    }

    public static void main(String[] args){
        TreeNode t = BinarySearchTreeTestCase.BINARY_SEARCH;
        //preOrderTraversal(t);
        //inOrderTraversal(t);
        afterOrderTraversal(t);
    }
}
