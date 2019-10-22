package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 27. 移除元素
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    @Test
    public void test() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int length = removeElement(nums, val);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            if (index == 0) {
                result.append("[").append(nums[index]);
            } else if (index == length - 1) {
                result.append(",").append(nums[index]).append("]");
            } else {
                result.append(",").append(nums[index]);
            }
        }
        PrintUtils.println("length is :" + length + " " + result.toString());
    }

    private int removeElement(int[] nums, int val) {
        if (nums.length <= 0) {
            return 0;
        }
        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            if (val != nums[index]) {
                nums[result] = nums[index];
                result++;
            }
        }
        return result;
    }

    /**
     * 复杂
     */
    private int removeElementMe(int[] nums, int val) {
        int valSize = 0;
        for (int index = 0; index < nums.length; index++) {
            if (val == nums[index]) {
                valSize++;
            } else {
                nums[index - valSize] = nums[index];
            }
        }
        return nums.length - valSize;
    }
}
