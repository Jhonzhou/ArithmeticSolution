package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 46. Permutations
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Related Topics 回溯算法
 */
public class _46_Permutations {

    public static void main(String[] args) {
        Solution solution = new _46_Permutations().new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        for (List<Integer> integers : permute) {
            PrintUtils.println(Arrays.toString(integers.toArray()));
        }
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> tempList = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(nums[0]);
            tempList.add(first);
            for (int index = 1; index < nums.length; index++) {
                List<List<Integer>> tempSecond = new ArrayList<>();
                for (List<Integer> integers : tempList) {
                    tempSecond.addAll(appendOne(integers, nums[index]));
                }
                tempList.clear();
                tempList.addAll(tempSecond);
            }
            return tempList;
        }

        public List<List<Integer>> appendOne(List<Integer> originalList, int addData) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (int index = 0; index <= originalList.size(); index++) {
                ArrayList<Integer> temp = new ArrayList<>(originalList);
                temp.add(index, addData);
                tempList.add(temp);
            }
            return tempList;
        }
    }

    class Server {
        void backtrace(int n, List<Integer> nums, List<List<Integer>> res, int first) {
            if (first == n) {
                res.add(new ArrayList<Integer>(nums));
            }
            for (int i = first; i < n; i++) {
                Collections.swap(nums, first, i);
                backtrace(n, nums, res, first + 1);
                Collections.swap(nums, first, i);
            }
        }


        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> nums_lst = new ArrayList<>();
            for (int num : nums) {
                nums_lst.add(num);
            }
            backtrace(nums.length, nums_lst, res, 0);
            return res;
        }
    }
}