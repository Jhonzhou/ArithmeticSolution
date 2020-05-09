package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 78. Subsets
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * Related Topics 位运算 数组 回溯算法
 */
public class _78_Subsets {

    public static void main(String[] args) {
        Solution solution = new _78_Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        PrintUtils.printDoubleList(solution.subsets(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length <= 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> resultList = new ArrayList<>();
            add(new ArrayList<Integer>(), 0, nums, resultList);
            return resultList;
        }

        public void add(List<Integer> tempList, int start, int[] nums, List<List<Integer>> resultList) {
            resultList.add(new ArrayList<>(tempList));
            for (int index = start; index < nums.length; index++) {
                tempList.add(nums[index]);
                add(tempList, index + 1, nums, resultList);
                tempList.remove(tempList.size() - 1);
            }
        }


        public List<List<Integer>> subsetsServer(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(0, nums, res, new ArrayList<Integer>());
            return res;

        }

        private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
            res.add(new ArrayList<>(tmp));
            for (int j = i; j < nums.length; j++) {
                tmp.add(nums[j]);
                backtrack(j + 1, nums, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}