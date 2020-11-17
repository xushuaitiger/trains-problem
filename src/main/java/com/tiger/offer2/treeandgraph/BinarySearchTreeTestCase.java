package com.tiger.offer2.treeandgraph;

/**
 *                    56
 *                   /   \
*                   2 3   9 8
 *                  / \   / \
 *                 12 54  67 99
 *                 */
public class BinarySearchTreeTestCase {
    public static TreeNode BINARY_SEARCH = new TreeNode(56);
    static{
        TreeNode treeNode23 = new TreeNode(23);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode54 = new TreeNode(54);
        TreeNode treeNode98 = new TreeNode(98);
        TreeNode treeNode67 = new TreeNode(67);
        TreeNode treeNode69 = new TreeNode(69);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode99 = new TreeNode(99);

        BINARY_SEARCH.left = treeNode23;
        BINARY_SEARCH.right = treeNode98;

        treeNode23.left = treeNode12;
        treeNode23.right = treeNode54;

        treeNode98.left = treeNode67;
        treeNode98.right = treeNode99;

    }
}
