package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目标题:
 * 77. Combinations
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Related Topics 回溯算法
 */
public class _77_Combinations {

    public static void main(String[] args) {
        Solution solution = new _77_Combinations().new Solution();
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = solution.combine(n, k);
        PrintUtils.printDoubleList(combine);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (k <= 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> resultList = new ArrayList<>();
            /**
             * 1、固定一个起点开始添加数据
             * 2、当添加到K个的时候返回，
             * 3、移除最后一个数据，
             * 4、如果后面还有数据继续 2、3
             * 5、起点+1 继续1、2、3、4
             */
            append(n, k, 1, new ArrayList<Integer>(), resultList);
            return resultList;
        }

        public void append(int n, int k, int start, List<Integer> tempList, List<List<Integer>> resultList) {
            if (tempList.size() == k) {
                resultList.add(new ArrayList<>(tempList));
                return;
            }
            for (int current = start; current <= n; current++) {
                tempList.add(current);
                append(n, k, current + 1, tempList, resultList);
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution11 {
        List<List<Integer>> output = new LinkedList();
        int n;
        int k;

        public void backtrack(int first, LinkedList<Integer> curr) {
            // if the combination is done
            if (curr.size() == k) {
                output.add(new LinkedList(curr));
            }

            for (int i = first; i < n + 1; ++i) {
                // add i into the current combination
                curr.add(i);
                // use next integers to complete the combination
                backtrack(i + 1, curr);
                // backtrack
                curr.removeLast();
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1, new LinkedList<Integer>());
            return output;
        }
    }
}