package com.tiger.offer.arrayAndString;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzdt4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer21 {
    public int[] myExchange(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        int[] resultInt = new int[nums.length];
        for (int i : nums) {
            if (i % 2 == 1) {
                result.add(i);
            }else{
                odds.add(i);
            }
        }

        result.addAll(odds);
        for(int i =0;i<result.size();i++){
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }

    /**
     * 最优解
     * 解题方案
     * 思路
     * 标签：双指针
     * 整体思路：首先指定前指针 start 和后指针 end，然后前指针定位偶数，
     * 后指针定位奇数，定位到之后将两个值互换，直到数组遍历完成
     * 时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
     * 算法流程
     * 初始化前指针 start = 0，后指针 end = nums.length - 1
     * 当 start < end 时表示该数组还未遍历完成，则继续进行奇数和偶数的交换
     * 当 nums[start] 为奇数时，则 start++，直到找到不为奇数的下标为止
     * 当 nums[end] 为偶数时，则 end--，直到找到不为偶数的下标为止
     * 交换 nums[start] 和 nums[end]，继续下一轮交换
     * 返回 nums，即为交换后的结果
     *
     * 作者：画手大鹏
     * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xz0lse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            while(start < end && (nums[start] % 2) == 1) {
                start++;
            }
            while(start < end && (nums[end] % 2) == 0) {
                end--;
            }
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] s = new int[]{1,3,2,5,6,8,9};
        new Offer21().exchange(s);
    }

}
