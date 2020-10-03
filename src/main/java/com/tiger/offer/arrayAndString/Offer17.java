package com.tiger.offer.arrayAndString;

/**
 * 剑指 Offer 17. 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzvgc2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer17 {
    /**
     * 算法流程 1
     * 初始化 sum = 1
     * 循环遍历乘 10 让 sum 变为边界值
     * 新建 res 数组，大小为 sum-1
     * 从 1 开始打印，直到 sum-1 为止
     *
     * 作者：画手大鹏
     * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzwq1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= 10;
        }
        int[] res = new int[sum - 1];
        for(int i = 0; i < sum - 1; i++){
            res[i] = i + 1;
        }
        return res;
    }

}
