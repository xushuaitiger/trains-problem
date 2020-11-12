package com.tiger.offer2.treeandgraph;

/**
 * delete node of binary tree which equals an given number key
 */
public class 删除二叉搜索树节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //key小于当前节点，则需要删除当前节点的左子树中key对应的值，并保证二叉搜索树的性质不变
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        //当前节点值比key大，则需要删除当前节点的右子树中key对应的值，并保证二叉搜索树的性质不变
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        //当前节点等于key，则需要删除当前节点，并保证二叉搜索树的性质不变
        else {
            //当前节点没有左子树
            if (root.left == null) {
                return root.right;
            }
            //当前节点没有右子树
            else if (root.right == null) {
                return root.left;
            }
            //当前节点既有左子树又有右子树
            else {
                TreeNode node = root.right;
                //找到当前节点右子树最左边的叶子结点
                while (node.left != null) {
                    node = node.left;
                }
                //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        new 删除二叉搜索树节点().deleteNode(node1,2);
    }
}
