package com.tiger.offer.arrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xz7dgg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer39 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : nums) {
            if (cache.get(i) == null) {
                cache.put(i, 1);
            } else if(cache.containsKey(i)){
                cache.put(i, cache.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> num : cache.entrySet()) {
            if (num.getValue() > nums.length/2) {
                return num.getKey();
            }
        }

        return 0;
    }
}
