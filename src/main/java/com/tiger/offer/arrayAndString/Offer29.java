package com.tiger.offer.arrayAndString;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 思路
 * 标签：二维数组
 * 整体思路：循环遍历整个数组，循环中再嵌套四个循环，分别是从左至右，从上至下，从右至左，从下至上这几个方向，按照题意将整个数组遍历完成，控制好边界
 * mm 为行数，nn 为列数，时间复杂度：O(mn)O(mn)，空间复杂度：O(1)O(1)
 * 算法流程
 * 题目中 matrix 有可能为空，直接返回空数组即可
 * 初始化边界 left、right、top、bottom 四个值，初始化结果数组 res 和数组下标 x
 * 按照遍历方向循环取出数字放入结果数组中
 * 从左至右：遍历完成后 ++top，如果 top > bottom​，到达边界循环结束
 * 从上至下：遍历完成后 --right，如果 left > right​，到达边界循环结束
 * 从右至左：遍历完成后 --bottom，如果 top > bottom​，到达边界循环结束
 * 从下至上：遍历完成后 ++left，如果 left > right​，到达边界循环结束
 * <p>
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/55v2m2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer29 {

    /**
     * 左右->上下->右左->下上，好个白鹤亮翅！
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0,
                bottom = matrix.length - 1, x = 0;

        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            //左右
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }

            if (++top > bottom) break;

            //上下
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }

            if (left > --right) break;

            //右左
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }

            if (top > --bottom) break;

            //下上
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }

            if (++left > right) break;
        }
        return res;
    }
}
