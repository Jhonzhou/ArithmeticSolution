package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 90. Subsets II
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * Related Topics 数组 回溯算法
 */
public class _90_SubsetsIi {

    public static void main(String[] args) {
        Solution solution = new _90_SubsetsIi().new Solution();
        int nums[] = {1, 2, 2};
        PrintUtils.printDoubleList(solution.subsetsWithDup(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            append(0, nums, new ArrayList<Integer>(), result);
            return result;
        }

        private void append(int start, int[] nums, ArrayList<Integer> tempList, List<List<Integer>> resultList) {
            resultList.add(new ArrayList<>(tempList));
            for (int index = start; index < nums.length; index++) {
                if (index > start && nums[index] == nums[index - 1]) {
                    continue;
                }
                tempList.add(nums[index]);
                append(index+1, nums, tempList, resultList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    class SolutionSelf {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            append(0, nums, new ArrayList<Integer>(), result);
            result.add(Collections.<Integer>emptyList());
            return result;
        }

        public void append(int start, int[] nums, List<Integer> tempList, List<List<Integer>> resultList) {
            if (start == nums.length - 1) {
                ArrayList<Integer> integers = new ArrayList<>(tempList);
                integers.add(nums[start]);
                resultList.add(integers);
                return;
            }
            for (int index = start; index < nums.length; index++) {
                if (index > start && nums[index] == nums[index - 1]) {
                    continue;
                }
                tempList.add(nums[index]);
                resultList.add(new ArrayList<>(tempList));
                append(index + 1, nums, tempList, resultList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}