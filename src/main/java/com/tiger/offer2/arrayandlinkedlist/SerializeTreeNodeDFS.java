package com.tiger.offer2.arrayandlinkedlist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可
 * 以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 */
public class SerializeTreeNodeDFS {
    //serialize use dfs
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }

    public String serializeHelper(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
            return s;
        }
        s += root.val+",";
        s = serializeHelper(root.left, s);
        s = serializeHelper(root.right, s);
        return s;
    }

    public TreeNode deSerializer(String data) {
        String[] strArray = data.split(",");
        List<String> stringList = Arrays.asList(strArray);
        if (stringList == null) {
            return null;
        }
        return deSerializeHelper(new ArrayList(stringList));
    }

    public TreeNode deSerializeHelper(List<String> list) {
        if (list.size() < 1 || list.get(0).equals("null")) {
            list.remove(0);
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left = deSerializeHelper(list);
            node.right = deSerializeHelper(list);
            return node;
        }
    }

    public static void main(String[] args) {
        String s = new SerializeTreeNodeDFS().serialize(TreeNodeTestCase.A);
        System.out.println(s);
        new SerializeTreeNodeDFS().deSerializer(s);
    }
}



