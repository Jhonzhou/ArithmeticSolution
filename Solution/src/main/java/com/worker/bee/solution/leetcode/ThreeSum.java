package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    @Test
    public void test() {
//        int[] ints = new int[]{-4, -1, -1, 0, 1, 2};
        int[] ints = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> result = threeSum(ints);
        if (result != null) {
            for (List<Integer> integers : result) {
                PrintUtils.println(Arrays.toString(integers.toArray()));
            }
        }
    }

    private List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        //将给定集合排序
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int current = 0;
        int left, right;
        int endTarget = length - 2;
        while (current < endTarget) {
            if (nums[current] > 0) {
                break;
            }
            if (current > 0 && nums[current] == nums[current - 1]) {
                //去重
                current++;
                continue;
            }
            //只从该节点向后查找，否则会重复
            left = current + 1;
            right = length - 1;
            while (left < right) {
                int sum = nums[current] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    continue;
                } else if (sum < 0) {
                    left++;
                    continue;
                }
                if (left > 0 && nums[left] == nums[left - 1]
                        && right < length - 1 && nums[right] == nums[right + 1]) {
                    left++;
                    right--;
                    continue;
                }
                result.add(Arrays.asList(nums[current], nums[left], nums[right]));
                left++;
                right--;
            }
            current++;
        }

        return result;
    }

}
