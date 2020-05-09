package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 79. Word Search
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * Related Topics 数组 回溯算法
 */
public class _79_WordSearch {

    public static void main(String[] args) {
        Solution solution = new _79_WordSearch().new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCCED";
        PrintUtils.println(solution.exist(board, word));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            if (word == null || word.length() <= 0) {
                return true;
            }
            char[] originalArray = word.toCharArray();
            for (int x = 0; x < board[0].length; x++) {
                for (int y = 0; y < board.length; y++) {
                    if (match(0, x, y, board, originalArray)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * @param index         当前角标
         * @param x             x
         * @param y             y
         * @param board         字符集合
         * @param originalArray 原始字符数组
         */
        public boolean match(int index, int x, int y, char[][] board, char[] originalArray) {
            if (x == board[0].length || x < 0) {
                return false;
            }
            if (y == board.length || y < 0) {
                return false;
            }
            //如果遍历过置为'#'
            if (board[y][x] == '#') {
                return false;
            }
            if (board[y][x] == originalArray[index]) {
                if (index == originalArray.length - 1) {
                    return true;
                }
                index = index + 1;
            } else {
                return false;
            }

            char temp = board[y][x];
            board[y][x] = '#';

            if (match(index, x, y + 1, board, originalArray)) {
                return true;
            }
            if (match(index, x + 1, y, board, originalArray)) {
                return true;
            }
            if (match(index, x - 1, y, board, originalArray)) {
                return true;
            }
            if (match(index, x, y - 1, board, originalArray)) {
                return true;
            }
            board[y][x] = temp;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}