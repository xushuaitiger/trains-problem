package com.tiger.offer2.treeandgraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的序列化与反序列化深度优先 {
    // 序列化
    public String serialize(TreeNode root) {
        String s =  serializeHelper(root, "");
        return s.substring(0,s.length()-1);
    }

    private String serializeHelper(TreeNode root, String str) {
        //递归出口条件
        if(root == null) {
            str +="null,";
            return str;
        }
        str +=root.val+",";//前序遍历
        str = serializeHelper(root.left,str);//递归左子树
        str = serializeHelper(root.right,str);//递归右子树
        return str;
    }

    //反序列化
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return deserializeHelper(data_list);
    }

    private TreeNode deserializeHelper(List<String> l) {
        // 递归处理，从字符串首元素开始处理
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);

        root.left = deserializeHelper(l);
        root.right = deserializeHelper(l);

        return root;
    }

    public static void main(String[] args) {
        TreeNode test = TreeNodeTestCase.A;
        System.out.println(new 二叉树的序列化与反序列化深度优先().serialize(test));
    }
}

