package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 题目描述：
 * <p>
 * &emsp;&emsp;实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    @Test
    public void test() {
        int[] nums = new int[]{0, 2, 5, 3, 2, 1};
//        [2,1,3]
        nextPermutation(nums);
        PrintUtils.println(Arrays.toString(nums));
    }

    private void nextPermutation(int[] nums) {
        /**
         * 思路：
         * 1、从后往前找到数字大小下降的位置i（同时i之后的数字是之后数组中最大的组合）
         * 2、从后往前找到j的位置，使得 nums[j]刚好大于nums[i]
         * 3、然后将i和j的位置互换，
         * 4、因为j之后的数字是i之后能组成的最大数字所以将其反转既得到后续中最小值
         * 终得结果
         */
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void nextPermutationMy(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int smallerEnd = -1;
        for (int index = nums.length - 1; index >= 1; index--) {
            if (nums[index] > nums[index - 1]) {
                smallerEnd = index - 1;
                break;
            }
        }
        //则为最大值
        if (smallerEnd == -1) {
            reverse(nums);
            return;
        }
        int min = Integer.MAX_VALUE;
        int bigerEnd = smallerEnd;

        for (int index = smallerEnd + 1; index < nums.length; index++) {
            int temp = nums[index] - nums[smallerEnd];
            if (temp > 0 && min >= temp) {
                min = temp;
                bigerEnd = index;
            }
        }
        swap(nums, smallerEnd, bigerEnd);
        smallerEnd = smallerEnd + 1;

        for (int index = smallerEnd; index <= bigerEnd; index++) {
            for (int x = index + 1; x <= bigerEnd; x++) {
                if (nums[smallerEnd] > nums[bigerEnd]) {
                    swap(nums, smallerEnd, bigerEnd);
                }
            }
        }
    }

    private void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tempInt = nums[y];
        nums[y] = nums[x];
        nums[x] = tempInt;
    }
}
