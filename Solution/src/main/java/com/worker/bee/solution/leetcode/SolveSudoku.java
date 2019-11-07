package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 37. 解数独
 * 题目描述：
 * <p>
 * &emsp;&emsp;判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 说明：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class SolveSudoku {
    @Test
    public void test() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        for (int index = 0; index < 9; index++) {
            PrintUtils.println(Arrays.toString(board[index]));
        }
    }

    private void solveSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {
                    continue;
                }
                for (int target = 1; target < 10; target++) {
                    if (isMath(board, row, column, target)) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 在row行column列插入target是否满足条件
     *
     * @return true 满足，false不满足
     */
    private boolean isMath(char[][] board, int row, int column, int target) {
        for (int index = 0; index < 9; index++) {
            if ((board[row][index] - '0') == target) {
                return false;
            }
            if ((board[index][column] - '0') == target) {
                return false;
            }
            int boxIndex = row / 3 * 3 + column / 3;
            int boxRow = boxIndex + index / 3 - 1;
            int boxColumn = boxIndex + index % 3 - 1;
            if ((board[boxRow][boxColumn] - '0') == target) {
                return false;
            }
        }
        return true;
    }

    private class Server {
        // box size
        int n = 3;
        // row size
        int N = n * n;

        int[][] rows = new int[N][N + 1];
        int[][] columns = new int[N][N + 1];
        int[][] boxes = new int[N][N + 1];

        char[][] board;

        boolean sudokuSolved = false;

        public boolean couldPlace(int d, int row, int col) {
            /*Check if one could place a number d in (row, col) cell
             */
            int idx = (row / n) * n + col / n;
            return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
        }

        public void placeNumber(int d, int row, int col) {
            /*Place a number d in (row, col) cell
             */
            int idx = (row / n) * n + col / n;

            rows[row][d]++;
            columns[col][d]++;
            boxes[idx][d]++;
            board[row][col] = (char) (d + '0');
        }

        public void removeNumber(int d, int row, int col) {
            /*Remove a number which didn't lead to a solution
             */
            int idx = (row / n) * n + col / n;
            rows[row][d]--;
            columns[col][d]--;
            boxes[idx][d]--;
            board[row][col] = '.';
        }

        public void placeNextNumbers(int row, int col) {
            /*Call backtrack function in recursion to continue to place numbers till the moment we have a solution
             */
            // if we're in the last cell
            // that means we have the solution
            if ((col == N - 1) && (row == N - 1)) {
                sudokuSolved = true;
            }
            // if not yet
            else {
                // if we're in the end of the row
                // go to the next row
                if (col == N - 1) {
                    // go to the next column
                    backtrack(row + 1, 0);
                } else {
                    backtrack(row, col + 1);
                }
            }
        }
//        Puppy老师非常喜欢和朋友们一起玩。
//        Puppy老师有n个朋友当前在一根数轴上,每个朋友当前在整数x[i]坐标位置。
//        Puppy老师向他们发出一个移动的信号,每个朋友就向左或者向右移动s距离(每个朋友的选择是独立的,都可以选择向左或者向右)。
//        为了在一起玩耍方便，Puppy老师希望移动之后最左边的朋友和最右边的朋友距离最近，Puppy老师想知道最近距离为多少。
        //-1--2--3--4--5--6--7--8--9--10--

        public void backtrack(int row, int col) {
            /*Backtracking
             */
            // if the cell is empty
            if (board[row][col] == '.') {
                // iterate over all numbers from 1 to 9
                for (int d = 1; d < 10; d++) {
                    if (couldPlace(d, row, col)) {
                        placeNumber(d, row, col);
                        placeNextNumbers(row, col);
                        // if sudoku is solved, there is no need to backtrack
                        // since the single unique solution is promised
                        if (!sudokuSolved) {
                            removeNumber(d, row, col);
                        }
                    }
                }
            } else {
                placeNextNumbers(row, col);
            }
        }

        public void solveSudoku(char[][] board) {
            this.board = board;

            // init rows, columns and boxes
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        int d = Character.getNumericValue(num);
                        placeNumber(d, i, j);
                    }
                }
            }
            backtrack(0, 0);
        }
    }

}
