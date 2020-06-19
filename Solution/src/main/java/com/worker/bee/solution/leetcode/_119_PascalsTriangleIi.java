package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 119. Pascal's Triangle II
 */
public class _119_PascalsTriangleIi {

    public static void main(String[] args) {
        Solution solution = new _119_PascalsTriangleIi().new Solution();
        PrintUtils.printList(solution.getRow(3));
    }
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex == 0) {
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>(rowIndex + 1);
            for (int index = 0; index <= rowIndex; index++) {
                int size = result.size();
                for (int i = size - 1; i > 0; i--) {
                    result.set(i, result.get(i - 1) + result.get(i));
                }
                result.add(1);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}