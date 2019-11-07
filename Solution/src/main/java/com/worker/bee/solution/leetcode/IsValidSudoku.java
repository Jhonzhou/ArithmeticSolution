package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 36. 有效的数独
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
public class IsValidSudoku {
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
        PrintUtils.println(isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null
                || board.length < 9
                || board[0].length < 9) {
            return false;
        }
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];
        int temp;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }
                temp = board[row][column] - '0';
                int index = temp - 1;
                if (rows[row][index] == temp) {
                    return false;
                } else {
                    rows[row][index] = temp;
                }
                if (columns[column][index] == temp) {
                    return false;
                } else {
                    columns[column][index] = temp;
                }
                int boxIndex = row / 3 * 3 +  column / 3;
                if (boxes[boxIndex][index] == temp) {
                    return false;
                } else {
                    boxes[boxIndex][index] = temp;
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuFirst(char[][] board) {
        if (board == null
                || board.length < 9
                || board[0].length < 9) {
            return false;
        }
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        int temp;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }
                temp = 9 - board[row][column];
                if (!rows[row].add(temp)) {
                    return false;
                }

                if (!columns[column].add(temp)) {
                    return false;
                }

                int boxRow = row / 3;
                int boxColumn = column / 3;
                int boxIndex = boxRow * 3 + boxColumn;
                if (!boxes[boxIndex].add(temp)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku111(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

}
