package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * ```
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * ```
 * Related Topics 数组 回溯算法
 */
public class _39_CombinationSum {
    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            PrintUtils.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);

        findResult(target, 0, candidates, resultList, null);
        return resultList;
    }

    private void findResult(int target, int start, int[] candidates, List<List<Integer>> resultList, List<Integer> preResult) {
        int current;

        if (preResult != null) {
            preResult = new ArrayList<>(preResult);
        } else {
            preResult = new ArrayList<>();
        }
        for (int index = start; index < candidates.length; index++) {
            current = candidates[index];
            if (current > target) {
                return;
            }
            if (current == target) {
                preResult.add(current);
                resultList.add(new ArrayList<>(preResult));
                preResult.remove(preResult.size() - 1);
                break;
            }

            preResult.add(current);
            findResult(target - current, index, candidates, resultList, preResult);
            preResult.remove(preResult.size() - 1);
        }
    }

    public static class Server111 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, res, 0, new ArrayList<Integer>());
            return res;
        }

        private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
            if (target < 0) return;
            if (target == 0) {
                res.add(new ArrayList<>(tmp_list));
                return;
            }
            for (int start = i; start < candidates.length; start++) {
                if (target < candidates[start]) break;
                tmp_list.add(candidates[start]);
                backtrack(candidates, target - candidates[start], res, start, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
            }
        }
    }

    public static class Server {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] candidates;
        private int len;

        private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
            if (residue == 0) {
                // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
                res.add(new ArrayList<>(pre));
                return;
            }
            // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
            // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
            // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
            for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
                pre.add(candidates[i]);
                // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
                findCombinationSum(residue - candidates[i], i, pre);
                pre.pop();
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            if (len == 0) {
                return res;
            }
            // 优化添加的代码1：先对数组排序，可以提前终止判断
            Arrays.sort(candidates);
            this.len = len;
            this.candidates = candidates;
            findCombinationSum(target, 0, new Stack<Integer>());
            return res;
        }

    }
}
