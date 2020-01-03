package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 55. JumpGame
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * Related Topics 贪心算法 数组
 */
public class _55_JumpGame {

    public static void main(String[] args) {
        Solution solution = new _55_JumpGame().new Solution();
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{2, 3, 1, 1, 4};
        PrintUtils.println(solution.canJumpServer(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJumpServer(int[] nums) {
            int endIndex = nums.length - 1;
            for (int index = endIndex; index >= 0; index--) {
                if (index + nums[index] >= endIndex) {
                    endIndex = index;
                }
            }
            return endIndex == 0;
        }

        public boolean canJump(int[] nums) {
            int length = nums.length;
            if (length <= 0) {
                return false;
            }
            if (length == 1) {
                return nums[0] >= 0;
            }
            int maxIndex = 0;
            int endIndex = length - 1;
            for (int index = 0; index < endIndex; index++) {
                if (nums[index] <= 0) {
                    if (maxIndex <= index) {
                        return false;
                    } else {
                        continue;
                    }
                }
                maxIndex = Math.max(maxIndex, index + nums[index]);
                if (maxIndex >= endIndex) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}