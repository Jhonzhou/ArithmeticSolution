package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 118. Pascal's Triangle
 */
public class _118_PascalsTriangle {

    public static void main(String[] args) {
        Solution solution = new _118_PascalsTriangle().new Solution();
        PrintUtils.printDoubleList(solution.generate(5));
    }
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();

            for (int index = 0; index < numRows; index++) {
                ArrayList<Integer> currentList = new ArrayList<>(index + 1);
                result.add(currentList);
                if (index == 0) {
                    currentList.add(1);
                } else {
                    List<Integer> preList = result.get(index - 1);
                    for (int i = 0; i <= index; i++) {
                        if (i == 0 || i == index) {
                            currentList.add(1);
                        } else {
                            currentList.add(preList.get(i) + preList.get(i - 1));
                        }
                    }
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}