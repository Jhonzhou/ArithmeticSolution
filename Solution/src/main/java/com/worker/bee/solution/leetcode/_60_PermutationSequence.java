package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 60. Permutation Sequence
 * 题目描述：
 * <p>
 * &emsp;&emsp;给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1, n!]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * Related Topics 数学 回溯算法
 */
public class _60_PermutationSequence {

    public static void main(String[] args) {
        Solution solution = new _60_PermutationSequence().new Solution();
        int n = 3;
        int k = 3;
        PrintUtils.println(solution.getPermutation(n, k));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            StringBuilder result = new StringBuilder();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                tempList.add(i);
            }
            while (tempList.size() > 1) {
                int factorial = getFactorial(tempList.size() - 1);
                int index = (int) Math.ceil(k / (float) factorial) - 1;
                k=k-index*factorial;
                result.append(tempList.get(index));
                tempList.remove(index);
            }
            result.append(tempList.get(0));
            return result.toString();
        }

        private int getFactorial(int n) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}