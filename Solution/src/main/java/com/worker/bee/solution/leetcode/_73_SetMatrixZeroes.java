package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目标题:
 * 73. Set Matrix Zeroes
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * <p>
 * 进阶:
 * <p>
 * <p>
 * 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * <p>
 * Related Topics 数组
 */
public class _73_SetMatrixZeroes {

    public static void main(String[] args) {
        Solution solution = new _73_SetMatrixZeroes().new Solution();
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);
        for (int[] ints : matrix) {
            PrintUtils.println(Arrays.toString(ints));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length <= 0
                    || matrix[0].length <= 0) {
                return;
            }
            int y = matrix.length;
            int x = matrix[0].length;
            List<Integer> rowZeros = new ArrayList<>();
            List<Integer> columnsZeros = new ArrayList<>();
            for (int row = 0; row < y; row++) {
                for (int column = 0; column < x; column++) {
                    if (matrix[row][column] == 0) {
                        rowZeros.add(row);
                        columnsZeros.add(column);
                    }
                }
            }
            for (Integer columnsZero : columnsZeros) {
                for (int index = 0; index < y; index++) {
                    matrix[index][columnsZero] = 0;
                }
            }
            for (Integer rowZero : rowZeros) {
                matrix[rowZero] = new int[x];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}