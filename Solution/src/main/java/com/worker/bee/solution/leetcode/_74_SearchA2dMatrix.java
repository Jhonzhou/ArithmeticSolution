package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 74. Search a 2D Matrix
 * 题目描述：
 * <p>
 * &emsp;&emsp;编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * Related Topics 数组 二分查找
 */
public class _74_SearchA2dMatrix {

    public static void main(String[] args) {
        Solution solution = new _74_SearchA2dMatrix().new Solution();
        int[][] matrix = new int[][]{
//                {1, 3},
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 13;
        PrintUtils.println(solution.searchMatrix(matrix, target));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length <= 0 || matrix[0].length <= 0) {
                return false;
            }
            int y = matrix.length;
            int x = matrix[0].length;
            int end = x * y - 1;
            int start = 0;
            while (start <= end) {
                int middle = (start + end) / 2;
                int temp = matrix[middle / x][middle % x];
                if (temp > target) {
                    end = middle - 1;
                } else if (temp < target) {
                    start = middle + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}