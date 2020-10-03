package com.tiger.offer.arrayAndString;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *         在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *         示例:
 *
 *         现有矩阵 matrix 如下：
 *
 *         [
 *         [1,   4,  7, 11, 15],
 *         [2,   5,  8, 12, 19],
 *         [3,   6,  9, 16, 22],
 *         [10, 13, 14, 17, 24],
 *         [18, 21, 23, 26, 30]
 *         ]
 *         给定 target = 5，返回 true。
 *
 *         给定 target = 20，返回 false。
 *
 *          
 *
 *         限制：
 *
 *         0 <= n <= 1000
 *
 *         0 <= m <= 1000
 *
 *          
 *
 *         注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 *         作者：画手大鹏
 *         链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xs5w4d/
 *         来源：力扣（LeetCode）
 *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer04 {
    /**
     * 我的题解 双循环整个二维数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean myindNumberIn2DArray(int[][] matrix, int target) {
      for(int i=0;i<matrix.length;i++){
          for(int m =0;m<matrix[i].length;m++){
              if (target == matrix[i][m]){
                      return true;
              }
          }
      }
      return false;
    }

    /**
     * 解题方案
     * 思路
     * 标签：数组遍历
     * 从矩阵的左下角看，上方的数字都比其小，右方的数字都比其大，
     * 所以依据该规律去判断数字是否存在
     * 设当前数字为 cur，目标数字为 target，当 target < cur 时，cur 更新为其上面的数字，当 target > cur 时，cur 更新为其右侧的数字，直到相等则返回 true，否则到了矩阵边界返回 false
     * 时间复杂度：O(m+n)O(m+n)
     *
     * 作者：画手大鹏
     * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xz2hh7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;

        int x = 0;
        int y = matrix.length - 1;

        while(x < matrix[0].length && y >= 0){
            if(matrix[y][x] > target) {
                y--;
            } else if(matrix[y][x] < target) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }


}
