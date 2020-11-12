package com.tiger.offer2.treeandgraph;

/**
 * 难度 midium
 */
public class 二叉树最近公共祖先 {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        System.out.println("root=" + (root != null ? root.val : "null") +
                " left:" + (left != null ? left.val : "null") + " right:" +
                (right != null ? right.val : "null"));

        TreeNode result = null;
        if (left == null && right == null) result = null;

        else if (left != null && right != null) result = root;

        else result = left == null ? right : left;
        System.out.println("结果："+(result!=null?result.val:"null"));
        return result;
    }

    public static void main(String[] args) {
        TreeNode s = new 二叉树最近公共祖先().
                lowestCommonAncestor(TreeNodeTestCase.A, new TreeNode(4), new TreeNode(5));
        System.out.println(s.val);
    }
}
