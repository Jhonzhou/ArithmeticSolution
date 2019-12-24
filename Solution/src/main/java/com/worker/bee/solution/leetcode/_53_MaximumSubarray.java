package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 53. Maximum Subarray
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * Related Topics 数组 分治算法 动态规划
 */
public class _53_MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new _53_MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PrintUtils.println(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length<=0){
                return 0;
            }
            int preResult = nums[0];
            int result = 0;
            for (int index = 0; index < nums.length; index++) {
                if (preResult < 0) {
                    preResult = 0;
                }
                preResult = preResult + nums[index];
                result = Math.max(result, preResult);

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}