package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目标题:
 * 120. Triangle
 */
public class _120_Triangle {

    public static void main(String[] args) {
        Solution solution = new _120_Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[] test1;
        test1 = new Integer[]{2};
        triangle.add(Arrays.asList(test1));
        test1 = new Integer[]{3, 4};
        triangle.add(Arrays.asList(test1));
        test1 = new Integer[]{6, 5, 7};
        triangle.add(Arrays.asList(test1));
        test1 = new Integer[]{4, 1, 8, 3};
        triangle.add(Arrays.asList(test1));
        PrintUtils.print(solution.minimumTotal(triangle));
    }
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }
            int result = Integer.MAX_VALUE;
            int rows = triangle.size();
            ArrayList<Integer> tempResult = new ArrayList<>(triangle.get(rows - 1).size());
            for (int index = 0; index < rows; index++) {
                List<Integer> integers = triangle.get(index);
                int length = integers.size();

                for (int i = length - 1; i >= 0; i--) {
                    int prePre = 0;
                    if (tempResult.size() > 0) {
                        if (i == 0) {
                            prePre = tempResult.get(0);
                        } else if (i == length - 1) {
                            prePre = tempResult.get(tempResult.size() - 1);
                        } else {
                            prePre = Math.min(tempResult.get(i), tempResult.get(i - 1));
                        }
                    }
                    int temp = prePre + integers.get(i);
                    if (i >= tempResult.size()) {
                        tempResult.add(temp);
                    } else {
                        tempResult.set(i, temp);
                    }

                    if (index==rows-1){
                        result=Math.min(temp,result);
                    }
                }
            }
            return result;
        }


    }

    class SolutionSelf2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }
            int result = Integer.MAX_VALUE;
            int rows = triangle.size();
            ArrayList<Integer> tempResult = new ArrayList<>(triangle.get(rows - 1).size());
            for (int index = 0; index < rows; index++) {
                List<Integer> integers = triangle.get(index);
                int length = integers.size();

                for (int i = length - 1; i >= 0; i--) {
                    int prePre = 0;
                    if (tempResult.size() > 0) {
                        if (i == 0) {
                            prePre = tempResult.get(0);
                        } else if (i == length - 1) {
                            prePre = tempResult.get(tempResult.size() - 1);
                        } else {
                            prePre = Math.min(tempResult.get(i), tempResult.get(i - 1));
                        }
                    }
                    int temp = prePre + integers.get(i);
                    if (i >= tempResult.size()) {
                        tempResult.add(temp);
                    } else {
                        tempResult.set(i, temp);
                    }

                    if (index==rows-1){
                        result=Math.min(temp,result);
                    }
                }
            }
            return result;
        }


    }
    /**
     * 超时
     */
    class SolutionSelf {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }

            return helper(triangle, 1, 0, triangle.get(0).get(0));
        }

        public int helper(List<List<Integer>> triangle, int currentLevel, int preIndex, int currentResult) {
            if (currentLevel >= triangle.size()) {
                return currentResult;
            }
            int current = helper(triangle, currentLevel + 1, preIndex, currentResult + triangle.get(currentLevel).get(preIndex));
//            if (preIndex+1>triangle.get(currentLevel))
            int next = helper(triangle, currentLevel + 1, preIndex + 1, currentResult + triangle.get(currentLevel).get(preIndex + 1));
            return Math.min(current, next);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}