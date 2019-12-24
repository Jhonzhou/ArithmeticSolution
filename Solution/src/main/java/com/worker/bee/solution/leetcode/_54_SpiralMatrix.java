package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 54. Spiral Matrix
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Related Topics 数组
 */
public class _54_SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new _54_SpiralMatrix().new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
        };
        PrintUtils.printList(solution.spiralOrder(matrix));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> spiralOrderServer(int[][] matrix) {
            List<Integer> resultList = new ArrayList<>();
            if (matrix.length <= 0) return resultList; //若数组为空，直接返回答案
            int startRows = 0; //赋值上下左右边界
            int maxRows = matrix.length - 1;
            int startColumn = 0;
            int maxColumns = matrix[0].length - 1;
            while (true) {
                for (int i = startColumn; i <= maxColumns; ++i) resultList.add(matrix[startRows][i]); //向右移动直到最右
                if (++startRows > maxRows) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
                for (int i = startRows; i <= maxRows; ++i) resultList.add(matrix[i][maxColumns]); //向下
                if (--maxColumns < startColumn) break; //重新设定有边界
                for (int i = maxColumns; i >= startColumn; --i) resultList.add(matrix[maxRows][i]); //向左
                if (--maxRows < startRows) break; //重新设定下边界
                for (int i = maxRows; i >= startRows; --i) resultList.add(matrix[i][startColumn]); //向上
                if (++startColumn > maxColumns) break; //重新设定左边界
            }
            return resultList;
        }

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> resultList = new ArrayList<>();
            if (matrix.length <= 0) {
                return resultList;
            }
            int maxRows = matrix.length;
            int maxColumn = matrix[0].length;
            int startRow = 0;
            int startColumn = 0;
            while (true) {
                for (int index = startColumn; index < maxColumn; index++) {
                    resultList.add(matrix[startRow][index]);
                }
                PrintUtils.printList(resultList);
                startRow++;
                if (startRow >= maxRows) {
                    break;
                }
                for (int index = startRow; index < maxRows; index++) {
                    resultList.add(matrix[index][maxColumn - 1]);
                }
                PrintUtils.printList(resultList);
                maxColumn--;
                if (maxColumn <= startColumn) {
                    break;
                }
                for (int index = maxColumn - 1; index >= startColumn; index--) {
                    resultList.add(matrix[maxRows - 1][index]);
                }
                PrintUtils.printList(resultList);
                maxRows--;
                if (maxRows <= startRow) {
                    break;
                }
                for (int index = maxRows - 1; index >= startRow; index--) {
                    resultList.add(matrix[index][startColumn]);
                }
                PrintUtils.printList(resultList);
                startColumn++;
                if (startColumn >= maxColumn) {
                    break;
                }
                PrintUtils.println("---------------");
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}