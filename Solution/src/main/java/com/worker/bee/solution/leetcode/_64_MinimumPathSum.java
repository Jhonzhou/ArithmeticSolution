package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 64. Minimum Path Sum
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * Related Topics 数组 动态规划
 */
public class _64_MinimumPathSum {

    public static void main(String[] args) {
        Solution solution = new _64_MinimumPathSum().new Solution();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        PrintUtils.println(solution.minPathSum(grid));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int rows = grid.length;
            int columns = grid[0].length;
            for (int i = 1; i < rows; i++) {
                grid[i][0]=grid[i-1][0]+grid[i][0];
            }
            for (int i = 1; i < columns; i++) {
                grid[0][i]=grid[0][i-1]+grid[0][i];
            }
            for (int x = 1; x < rows; x++) {
                for (int y = 1; y < columns; y++) {
                    grid[x][y] = Math.min(grid[x - 1][y], grid[x][y - 1]) + grid[x][y];
                }
            }
            for (int[] ints : grid) {
                PrintUtils.println(Arrays.toString(ints));
            }
            return grid[rows-1][columns-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}