package com.tiger.offer2.treeandgraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root ==null) return 0;
        if(root.children == null || root.children.isEmpty()) return 1;
        List<Integer> heights = new LinkedList<>();
        for (Node item : root.children) {
            heights.add(maxDepth(item));
        }
        return Collections.max(heights) + 1;
    }

}
