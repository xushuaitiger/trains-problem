package com.tiger.leetcode.cuncurrent;

import com.tiger.offer2.treeandgraph.TreeNode;
import com.tiger.offer2.treeandgraph.TreeNodeTestCase;

public class CuncurrentTest {
    TreeNode a ;

    public void test(){
        this.a = new TreeNode(1);
    }

    public static void main(String[] args) {
        CuncurrentTest test = new CuncurrentTest();
        test.test();
        for(int i=0;i<100;i++){
            Thread t = new Thread(new Work(test.a),"threanname: "+i);
            t.start();
        }
    }

    static class Work implements Runnable {
        private TreeNode a;

        public Work(TreeNode a) {
            this.a = a;
        }

        @Override
        public void run() {
            a.val++;
           System.out.println(Thread.currentThread().getName()+"-"+a.hashCode()+"值："+a.val);
        }
    }
}

