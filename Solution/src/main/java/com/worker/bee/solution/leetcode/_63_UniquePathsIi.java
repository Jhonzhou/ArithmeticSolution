package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 63. Unique Paths II
 * 题目描述：
 * <p>
 * &emsp;&emsp;一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * Related Topics 数组 动态规划
 */
public class _63_UniquePathsIi {

    public static void main(String[] args) {
        Solution solution = new _63_UniquePathsIi().new Solution();
        int[][] obstacleGrid = new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

//                {0, 0},
//                {1, 0},
//                {1, 0}

//                {0, 0,0},
//                {0, 1,0},
//                {0, 0,0}
                };
        PrintUtils.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid[0][0] == 1
                    || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
                return 0;
            }
            int rows = obstacleGrid.length;
            int columns = obstacleGrid[0].length;
            int[][] temp = new int[rows][columns];
            temp[0][0] = 1;
            for (int i = 1; i < rows; i++) {
                temp[i][0] = temp[i - 1][0] == 0 || obstacleGrid[i][0] == 1 ? 0 : 1;
            }
            for (int i = 1; i < columns; i++) {
                temp[0][i] = temp[0][i - 1] == 0 || obstacleGrid[0][i] == 1 ? 0 : 1;
            }
            for (int i = 0; i < rows; i++) {
                PrintUtils.println(Arrays.toString(temp[i]));
            }
            PrintUtils.println("--------------");
            for (int x = 1; x < rows; x++) {
                for (int y = 1; y < columns; y++) {
                    if (obstacleGrid[x][y] == 1) {
//                        temp[x][y] = 0;
                        continue;
                    }
                    temp[x][y] = temp[x - 1][y] + temp[x][y - 1];
                }
            }
            for (int i = 0; i < rows; i++) {
                PrintUtils.println(Arrays.toString(temp[i]));
            }
            return temp[rows - 1][columns - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}