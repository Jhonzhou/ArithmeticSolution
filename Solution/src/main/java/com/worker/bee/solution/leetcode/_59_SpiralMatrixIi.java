package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 59. Spiral Matrix II
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * Related Topics 数组
 */
public class _59_SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new _59_SpiralMatrixIi().new Solution();
        int n = 3;
        int[][] ints = solution.generateMatrix(n);
        for (int[] anInt : ints) {
            PrintUtils.println(Arrays.toString(anInt));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int maxRows = n - 1;
            int maxColumn = n - 1;
            int currentRows = 0;
            int currentColumn = 0;
            int content = 1;
            int count = n / 2;
            while (count >= 0) {
                count--;
                for (int index = currentColumn; index <= maxColumn; index++) {
                    result[currentRows][index] = content++;
                }
                ++currentRows;
//                if (++currentRows > maxRows) {
//                    break;
//                }
                for (int index = currentRows; index <= maxRows; index++) {
                    result[index][maxColumn] = content++;
                }
                --maxColumn;
//                if (--maxColumn < currentColumn) {
//                    break;
//                }
                for (int index = maxColumn; index >= currentColumn; index--) {
                    result[maxRows][index] = content++;
                }
                --maxRows;
//                if (--maxRows < currentRows) {
//                    break;
//                }
                for (int index = maxRows; index >= currentRows; index--) {
                    result[index][currentColumn] = content++;
                }
                ++currentColumn;
//                if (++currentColumn > maxColumn) {
//                    break;
//                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}