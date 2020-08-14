package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;


/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class _34_SearchRangeFirstAndEnd {
    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 5;
        PrintUtils.println(Arrays.toString(searchRange(nums, target)));
    }

    private int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                //查找前后锚点
                start = end = middle;
                while (start >= 0) {
                    if (nums[start] == target) {
                        start--;
                    } else {
                        break;
                    }
                }
                while (end < nums.length) {
                    if (nums[end] == target) {
                        end++;
                    } else {
                        break;
                    }
                }
                result[0] = start + 1;
                result[1] = end - 1;
                break;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return result;
    }

    private class Server {
        private int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);

            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

            return targetRange;
        }

    }
}
