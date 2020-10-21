package com.tiger.interview.ringcentral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 *
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 */
public class MergeRange {

    public int[][] merge(int[][] intervals) {
        if(intervals ==null || intervals.length<1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>cur[1]){
                res.add(cur);
                cur = intervals[i];
            }else{
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }
        }
        res.add(cur);
        int[][] ans = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
