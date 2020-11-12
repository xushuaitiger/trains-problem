package com.tiger.offer2.dynamicprogramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 */
public class 打家劫舍 {
    public int rob(int[] nums){
        if(nums ==null || nums.length ==0) return 0;
        if(nums.length ==1) return nums[0];

        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args){
        int[] test = new int[]{2,5,7,1,3};
        new 打家劫舍().rob(test);
    }
}
