package com.tiger.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 * <p>
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 */
public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long pre = (long) lower - 1;    // 防止 lower 就是 int 最小值，减一就直接溢出了
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - pre == 2) {
                ans.add(String.valueOf(pre + 1));
            } else if (nums[i] - pre >= 3) {
                ans.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i]; // 'int' to 'long'
        }
        if (upper - pre == 1) {
            ans.add(String.valueOf(pre + 1));
        } else if (upper - pre >= 2) {
            ans.add((pre + 1) + "->" + upper);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] test = new int[]{-1};
        int lower = -2, upper = -1;
        new FindMissingRanges().findMissingRanges(test, lower, upper);
    }
}
