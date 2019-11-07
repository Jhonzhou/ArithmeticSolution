package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 35. 搜索插入位置
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * ```
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * ```
 */
public class SearchLocationToInsert {
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        PrintUtils.println(searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
