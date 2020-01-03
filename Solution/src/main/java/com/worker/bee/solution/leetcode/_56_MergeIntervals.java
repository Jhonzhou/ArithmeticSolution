package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目标题:
 * 56. Merge Intervals
 * <p>
 * &emsp;&emsp;给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * Related Topics 排序 数组
 */
public class _56_MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new _56_MergeIntervals().new Solution();
        int[][] intervals = new int[][]{
//                {1, 4},
//                {1, 4},


//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18},


                {2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}
        };
        int[][] merge = solution.merge(intervals);
        if (merge.length > 0) {
            for (int[] ints : merge) {
                PrintUtils.println(Arrays.toString(ints));
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            //数组排序
            int[] temp;
//            for (int x = 0; x < intervals.length; x++) {
//                for (int y = x + 1; y < intervals.length; y++) {
//                    if (intervals[x][0] > intervals[y][0]) {
//                        temp = intervals[y];
//                        intervals[y] = intervals[x];
//                        intervals[x] = temp;
//                    }
//                }
//            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            temp = intervals[0];
            int preEnd = 1;

            for (int x = 1; x < intervals.length; x++) {
                if (temp[1] >= intervals[x][0]) {
                    //合并
                    if (temp[1] < intervals[x][1]) {
                        temp[1] = intervals[x][1];
                    }
                } else {
                    intervals[preEnd] = intervals[x];
                    temp = intervals[x];
                    preEnd++;
                }
            }
            return Arrays.copyOf(intervals, preEnd);
        }

        public int[][] merge222(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            //数组排序
            int[] temp;
//            for (int x = 0; x < intervals.length; x++) {
//                for (int y = x + 1; y < intervals.length; y++) {
//                    if (intervals[x][0] > intervals[y][0]) {
//                        temp = intervals[y];
//                        intervals[y] = intervals[x];
//                        intervals[x] = temp;
//                    }
//                }
//            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            temp = intervals[0];
            int preIndex = 0;
            for (int index = 1; index < intervals.length; index++) {
                if (intervals[index][0] <= intervals[preIndex][1]) {
                    //合并
                    if (intervals[index][1]> intervals[preIndex][1]) {
                        intervals[preIndex][1] = intervals[index][1];
                    }
                } else {
                    preIndex++;
                    intervals[preIndex] = intervals[index];
                }
            }
            return Arrays.copyOf(intervals, preIndex+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}