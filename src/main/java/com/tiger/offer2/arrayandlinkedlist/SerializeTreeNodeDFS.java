package com.tiger.offer2.arrayandlinkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可
 * 以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 */
public class SerializeTreeNodeDFS {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = serializerHelper(root, "");
        System.out.println(s);
        return s;
    }

    // dfs
    private String serializerHelper(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
            //System.out.println("gg:"+null);
        } else {//前序遍历 深度优先
            //System.out.println("gg:"+root.val);
            str += str.valueOf(root.val) + ",";
            str = serializerHelper(root.left, str);
            str = serializerHelper(root.right, str);
        }
        return str;
    }

    // dfs Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return deserializeHelper(data_list);
    }

    // dfs
    public TreeNode deserializeHelper(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        //递归左树
        root.left = deserializeHelper(l);
        //递归右树
        root.right = deserializeHelper(l);
        return root;
    }


    public static void main(String[] args) {
        String s = new SerializeTreeNodeDFS().serialize(TreeNodeTestCase.A);
        new SerializeTreeNodeDFS().deserialize(s);
    }
}



