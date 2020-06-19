package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.HashMap;

/**
 * 两数之和
 */
public class _1_TheSumOfTwoNumbers {

    public void questions() {
        /*
        题目：
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
        解题
        1、弄清楚是否否有序整数数组
        给出有序情况答案和无序情况答案
        */
    }

    @Test
    public void testUnOrder() {
//        int[] nums = new int[]{3, 2, 4};
//        int target = 6;
        int[] nums = new int[]{1, 3, 6, 7, 12, 13, 15};
        int target = 14;
        int[] solution = unOrder(nums, target);
        printResult(nums, solution);
    }

    @Test
    public void testOrder() {
        int[] nums = new int[]{1, 3, 6, 7, 12, 13, 15};
        int target = 14;
        int[] solution = orderedSolution(nums, target);
        printResult(nums, solution);
    }

    /**
     * 当数组为无序数组时，使用此结果
     */
    public int[] unOrder(int[] nums, int target) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (tempMap.containsKey(nums[i])) {
                return new int[]{tempMap.get(nums[i]), i};
            }
            tempMap.put(target - nums[i], i);
        }
        return null;
    }

    /**
     * 如果给定数组是有序的使用此解决方案
     */
    private int[] orderedSolution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int temp;
        while (start < end) {
            temp = nums[start] + nums[end];
            if (temp == target) {
                return new int[]{start, end};
            } else if (temp < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }

    private void printResult(int[] nums, int[] solution) {
        if (solution == null) {
            PrintUtils.println("no fount the result");
        } else {
            PrintUtils.println("the first index is : " + solution[0] + " content is : " + nums[solution[0]]);
            PrintUtils.println("the second index is : " + solution[1] + " content is : " + nums[solution[1]]);
        }
    }
}
