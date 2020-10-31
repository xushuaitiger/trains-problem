package com.tiger.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PickIndex {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;
        int res = 0;
        for (int n : nums) {
            preSum += n;
            // 查找前面有多少个 preSum[i] 等于 preSum[j] - k
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            // 更新map中 preSum[j] 的个数
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return res;
    }

    public static void main(String[] args){
     int[] test = new int[]{1,3,5,7,9,9,11};
     int k = 21;
     System.out.println(new PickIndex().subarraySum(test,k));
    }
}
