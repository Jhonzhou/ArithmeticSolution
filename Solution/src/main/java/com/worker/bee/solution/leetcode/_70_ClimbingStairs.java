package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 70. Climbing Stairs
 * 题目描述：
 * <p>
 * &emsp;&emsp;假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * Related Topics 动态规划
 */
public class _70_ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new _70_ClimbingStairs().new Solution();
        int n = 3;
        PrintUtils.println(solution.climbStairs(n));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }
            int pre2 = 1;
            int pre1 = 2;
            int current = 0;
            for (int index = 3; index <= n; index++) {
                current = pre1 + pre2;
                pre2 = pre1;
                pre1 = current;
            }
            return current;
        }

        public int climbStairs11(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }
            int result = 0;
            int[] temp = new int[n];
            temp[0] = 1;
            temp[1] = 2;
            for (int index = 2; index < n; index++) {
                temp[index] = temp[index - 1] + temp[index - 2];
            }
            return temp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}