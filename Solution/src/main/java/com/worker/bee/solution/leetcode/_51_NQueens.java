package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 51. N-Queens
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * Related Topics 回溯算法
 */
public class _51_NQueens {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> lists = solveNQueens(n);
        PrintUtils.printList(lists);
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        for (int index = 0; index < n; index++) {

        }
        return resultList;
    }

    public static List<String> matchQueen(List<String> originalList, int[] rowArray, int[] biasArray) {
        if (originalList == null || originalList.isEmpty()) {
            return null;
        }
        String lastStr = originalList.get(originalList.size() - 1);
        char preIndex = lastStr.charAt('Q');

        return originalList;
    }
}