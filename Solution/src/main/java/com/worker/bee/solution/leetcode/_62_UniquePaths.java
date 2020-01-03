package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 62. Unique Paths
 * 题目描述：
 * &emsp;&emsp;一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * Related Topics 数组 动态规划
 */
public class _62_UniquePaths {

    public static void main(String[] args) {
        Solution solution = new _62_UniquePaths().new Solution();
        int m = 7;
        int n = 3;
        PrintUtils.println(solution.uniquePaths(m, n));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1、改题解法就是f(m,n)=f(m-1,n)+f(m,n-1)
         * 2、但是递归会超时，所以使用动态规划
         * 3、动态规划就是保存此前递归的状态减少递归次数
         */

        public int uniquePaths(int m, int n) {

            if (m == 1 || n == 1) {
                return 1;
            }
            int[][] tempArray = new int[m][n];
            for (int mIndex = 0; mIndex < m; mIndex++) {
                tempArray[mIndex][0] = 1;
            }

            for (int nIndex = 0; nIndex < n; nIndex++) {
                tempArray[0][nIndex] = 1;
            }
            for (int mIndex = 1; mIndex < m; mIndex++) {
                for (int nIndex = 1; nIndex < n; nIndex++) {
                    tempArray[mIndex][nIndex] = tempArray[mIndex - 1][nIndex]
                            + tempArray[mIndex][nIndex - 1];
                }
            }
            return tempArray[m - 1][n - 1];
        }

        public int uniquePathsServer(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) dp[0][i] = 1;
            for (int i = 0; i < m; i++) dp[i][0] = 1;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

        /**
         * 此种 递归方法会超时
         * //改题解法就是f(m,n)=f(m-1,n)+f(m,n-1)
         */
        public int uniquePathsError(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }
            return uniquePaths(m - 1, n) +
                    uniquePaths(m, n - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}