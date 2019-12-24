package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 48. Rotate Image
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 *  将图像顺时针旋转 90 度。
 *
 *  说明：
 *
 *  你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 *  示例 1:
 *
 *  给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 *  示例 2:
 *
 *  给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 *  Related Topics 数组
 */
public class _48_RotateImage {

    public static void main(String[] args) {
        Solution solution = new _48_RotateImage().new Solution();
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(nums);
        for (int[] num : nums) {
            PrintUtils.println(Arrays.toString(num));
        }
    }


    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];
        int length = temp.length - 1;
        for (int x = 0; x <= length; x++) {
            for (int y = 0; y <= length; y++) {
                temp[y][length - x] = matrix[x][y];
            }
        }
        for (int x = 0; x <= length; x++) {
            for (int y = 0; y <= length; y++) {
                matrix[x][y] = temp[x][y];
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int length = matrix.length;
            rotate(matrix);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}