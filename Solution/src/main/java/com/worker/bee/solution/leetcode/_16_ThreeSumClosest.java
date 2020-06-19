package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 题目描述：
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class _16_ThreeSumClosest {
    @Test
    public void test() {
        int[] numbers = new int[]{-1, 2, 1, -4};
        int target = 1;
        Arrays.sort(numbers);
        PrintUtils.println(Arrays.toString(numbers));
        PrintUtils.println(threeSumClosest(numbers, target));

    }


    private int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int dir = -1;
        //排序
        Arrays.sort(nums);
        int length = nums.length;
        int sum;
        int closest = Integer.MAX_VALUE;
        for (int index = 0; index < length; index++) {
            for (int start = index + 1, end = length - 1; start < end; ) {
                sum = nums[index] + nums[start] + nums[end];
//                tempCloses = target - sum;
                if (target == sum) {
                    return sum;
                } else if (target > sum) {
                    if (closest > (target - sum)) {
                        closest = target - sum;
//                        result = sum;
                        dir = -1;
                    }
                    start++;
                } else {
                    if (closest > (sum - target)) {
                        closest = sum - target;
//                        result = sum;
                        dir = 1;
                    }
                    end--;
                }
            }
        }
        return target + dir * closest;
    }

    public int threeSumClosest4Seconds(int[] nums, int target) {
        // 排序
        // 遍历
        // 寻找当前元素后面的最接近的两数之和
        // 		双指针算法，等于就输出，否则就向中间移动直至相遇
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int direction = -1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum) {
                    return sum;
                } else if (target > sum) {
                    if (target - sum < closest) {
                        closest = target - sum;
                        direction = -1;
                    }
                    ++j;
                } else {
                    if (sum - target < closest) {
                        closest = sum - target;
                        direction = 1;
                    }
                    --k;
                }
            }
        }
        return target + direction * closest;
    }

    /**
     * 网络题解
     */
    private int threeSumClosestServer2Seconds(int[] nums, int target) {

        int sum = 0;
        int len = nums.length;
        if (len <= 3) {
            for (int n : nums) {
                sum += n;
            }
            return sum;
        }
        int minSub = Integer.MAX_VALUE;
        int ansSum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = len - 1;
            if (nums[i] + nums[k - 1] + nums[k] < target) {
                sum = nums[i] + nums[k - 1] + nums[k];
                int sub = Math.abs(sum - target);
                if (sub < minSub) {
                    minSub = sub;
                    ansSum = sum;
                }
            } else if (nums[i] + nums[j] + nums[j + 1] > target) {
                sum = nums[i] + nums[j] + nums[j + 1];
                int sub = Math.abs(sum - target);
                if (sub < minSub) {
                    minSub = sub;
                    ansSum = sum;
                }
            } else {
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    }
                    int sub = sum - target;
                    if (sub < 0) {
                        sub = -sub;
                        j++;
                    } else {
                        k--;
                    }
                    if (sub < minSub) {
                        minSub = sub;
                        ansSum = sum;
                    }
                }
            }
        }
        return ansSum;
    }
}
