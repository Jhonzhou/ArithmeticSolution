package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 128. Longest Consecutive Sequence
 */
public class _128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new _128_LongestConsecutiveSequence().new Solution();
        int[] temp = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
//        int[] temp = new int[]{100, 4, 200, 1, 3, 2};
        PrintUtils.println(solution.longestConsecutive(temp));
    }
//给定一个未排序的整数数组，找出最长连续序列的长度。
//
// 要求算法的时间复杂度为 O(n)。
//
// 示例:
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// Related Topics 并查集 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length <= 0) {
                return 0;
            }
            int maxLength = 1;
            int preLength = 1;
            Arrays.sort(nums);
            int pre = nums[0];
            for (int index = 1; index < nums.length; index++) {
                int result = nums[index] - pre;
                if (result == 0) {
                    continue;
                }
                if (result == 1) {
                    preLength += 1;
                    maxLength = Math.max(preLength, maxLength);
                } else {
                    preLength = 1;
                }
                pre = nums[index];

            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}