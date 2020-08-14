package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class _41_FirstMissingPositive {
    @Test
    public void test() {
//        int[] nums = new int[]{1, 0, 2};
        int[] nums = new int[]{3, 4, -1, 1};
//        PrintUtils.println(firstMissingPositive(nums));
        PrintUtils.println(new SolutionServer1().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (current < 0) {
                current = -1;
                continue;
            }
            if (current <= length) {

                while (nums[current] <= length) {
                    nums[current] = current;
                    current = nums[current];
                }

            }

        }
        return result;
    }

    /**
     * 暴力办法
     */
    public int firstMissingPositiveSelf(int[] nums) {
        int result = 1;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] <= 0) {
                continue;
            }
            if (nums[index] == result) {
                result++;
            }
        }
        return result;
    }

    class SolutionServer1 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; ++i) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }

    public class Server {

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // 基本情况
            int contains = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    contains++;
                    break;
                }
            }
            if (contains == 0) {
                return 1;
            }

            // nums = [1]
            if (n == 1) {
                return 2;
            }

            // 用 1 替换负数，0，和大于 n 的数
            // 在转换以后，nums 只会包含正数
            for (int i = 0; i < n; i++) {
                if ((nums[i] <= 0) || (nums[i] > n)) {
                    nums[i] = 1;
                }
            }

            // 使用索引和数字符号作为检查器
            // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
            // 如果 nums[2] 是正数 表示数字 2 没有出现
            for (int i = 0; i < n; i++) {
                int a = Math.abs(nums[i]);
                // 如果发现了一个数字 a - 改变第 a 个元素的符号
                // 注意重复元素只需操作一次
                if (a == n) {
                    nums[0] = -Math.abs(nums[0]);
                } else {
                    nums[a] = -Math.abs(nums[a]);
                }
            }

            // 现在第一个正数的下标
            // 就是第一个缺失的数
            for (int i = 1; i < n; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }

            if (nums[0] > 0) {
                return n;
            }
            return n + 1;
        }
    }
}
