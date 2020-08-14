package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class _40_CombinationSum2 {
    @Test
    public void test() {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            PrintUtils.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        findResult(target, 0, candidates, resultList, new ArrayList<Integer>());
        return resultList;
    }

    private void findResult(int target, int start, int[] candidates, List<List<Integer>> resultList, List<Integer> preResult) {
        int current;
        for (int index = start; index < candidates.length; index++) {
            if (index > start && candidates[index - 1] == candidates[index]) {
                continue;
            }
            current = candidates[index];
            if (current > target) {
                break;
            } else if (current == target) {
                preResult.add(current);
                resultList.add(new ArrayList<>(preResult));
                preResult.remove(preResult.size() - 1);
                break;
            }
            preResult.add(current);
            findResult(target - current, index + 1, candidates, resultList, preResult);
            preResult.remove(preResult.size() - 1);
        }
    }
}
