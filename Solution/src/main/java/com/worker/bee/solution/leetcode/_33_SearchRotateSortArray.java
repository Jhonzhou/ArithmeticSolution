package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 * 题目描述：
 * <p>
 * &emsp;&emsp;假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class _33_SearchRotateSortArray {
    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = -1;
        PrintUtils.println(search(nums, target));
    }


    public int searchServer(int[] nums, int target) {
        //二分查找，哪边有序，就砍掉另外一半
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                //左边是有序的
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //有边是有序的
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int reverse = 1;
        while (reverse < length) {
            if (nums[reverse - 1] > nums[reverse]) {
                reverse = reverse - 1;
                break;
            }
            reverse++;
        }
        if (reverse >= length) {
            reverse = length - 1;
        }

        if (nums[reverse] == target) {
            return reverse;
        }

        if (reverse + 1 < length && nums[reverse + 1] <= target && nums[length - 1] >= target) {
            return find(nums, reverse + 1, nums.length, target);
        }
        if (nums[0] <= target && nums[reverse] >= target) {
            return find(nums, 0, reverse, target);
        }
        return -1;
    }

    private int find(int[] nums, int start, int end, int target) {
        if (start >= nums.length || end < 0) {
            return -1;
        }
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
        return -1;
    }
}
