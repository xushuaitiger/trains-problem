package com.tiger.offer.arrayAndString;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，
 * 数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/55wprc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer11 {

    /**
     * 我的题解
     * @param numbers
     * @return
     */
    public int myＭinArray(int[] numbers) {
       int minimum = numbers[0];
       for(int i=0;i<numbers.length;i++){
           if(minimum>numbers[i]){
               minimum = numbers[i];
           }
       }
       return minimum;
    }

    /**
     * 最优解
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right --;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args){
        int[] source = new int[]{1,2,3,6,7};
        int[] test = new int[]{3,6,7,1,2};
        System.out.println("haha:"+minArray(test));
    }
}
