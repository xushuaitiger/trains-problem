package com.tiger.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数 {
    public int fib(int N) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(memo, N);
    }

    public int helper(Map memo, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.get(n) != null) return (Integer) memo.get(n);
        int value = helper(memo, n - 1) + helper(memo, n - 2);
        memo.put(n, value);
        return value;
    }

   public int fib2(int n){
        if(n<1) return 0;
        if(n==1 || n==2) return 1;
        //记录上次值和这次值
        int prev=1, curr =1;
        for(int i=3;i<=n;i++){
            //这次函数值等于上上次加上次
            int sum = curr+ prev;
            prev = curr;
            curr = sum;
        }
        return curr;
   }

    public static void main(String[] args) {
        System.out.println(new 斐波那契数().fib2(7));
    }
}
