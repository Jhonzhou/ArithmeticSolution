package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目标题:
 * 57. Insert Interval
 * 题目描述：
 * <p>
 * &emsp;&emsp;给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * Related Topics 排序 数组
 */
public class _57_InsertInterval {

    public static void main(String[] args) {
        Solution solution = new _57_InsertInterval().new Solution();
        int[][] intervals = new int[][]{
//                {1, 4},
//                {1, 4},


//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18},


                {2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}
        };
        int[] newInterval = new int[]{1, 3};
        int[][] insert = solution.insert(intervals, newInterval);
        for (int[] ints : insert) {
            PrintUtils.println(Arrays.toString(ints));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] tempOriginal = new int[intervals.length + 1][2];
            for (int i = 0; i < intervals.length; i++) {
                tempOriginal[i] = intervals[i];
            }
            tempOriginal[tempOriginal.length - 1] = newInterval;
            intervals = tempOriginal;
            if (intervals.length > 1) {
                Arrays.sort(intervals, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] ints, int[] t1) {
                        return ints[0] - t1[0];
                    }
                });
                int[] temp = intervals[0];
                int preIndex = 1;

                for (int index = 1; index < intervals.length; index++) {
                    if (temp[1] >= intervals[index][0]) {
                        if (temp[1] < intervals[index][1]) {
                            temp[1] = intervals[index][1];
                        }
                    } else {
                        intervals[preIndex] = intervals[index];
                        temp = intervals[index];
                        preIndex++;
                    }
                }
                intervals = Arrays.copyOf(intervals, preIndex);
            }
            return intervals;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}