package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个包含 n 个整数的数组 nums 和一个目标值 target
 * ，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * Related Topics 数组 哈希表 双指针
 */
public class _18_FourSum {
    @Test
    public void test() {
        int[] numbers = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        int target = -9;
        List<List<Integer>> lists = fourSum(numbers, target);
        PrintUtils.println(Arrays.toString(lists.toArray()));
    }

    /**
     * 极限值判断非常有必要，添加后运行时间从36ms直降4ms
     */
    private List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        //9个数
        int sum;
        for (int first = 0; first < length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if (nums[first] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            for (int second = first + 1; second < length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if (nums[first] + nums[second] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                int start = second + 1;
                int end = length - 1;
                while (start < end) {
                    sum = nums[first] + nums[second] + nums[start] + nums[end];
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        resultList.add(Arrays.asList(nums[first], nums[second], nums[start], nums[end]));
                        while ((start > second + 1) && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (end > start && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                        start++;
                    }
                }
            }
        }
        return resultList;
    }

    public List<List<Integer>> fourSumServer4(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4) return res;
        Arrays.sort(nums);
        for (int LE = 0; LE < len - 3; LE++) {
            if (LE > 0 && nums[LE] == nums[LE - 1]) continue;
            if (nums[LE] + nums[LE + 1] + nums[LE + 2] + nums[LE + 3] > target) break;
            if (nums[LE] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            for (int HI = LE + 1; HI < len - 2; HI++) {
                if (HI > LE + 1 && nums[HI] == nums[HI - 1]) continue;
                int le = HI + 1;
                int hi = len - 1;
                int min = nums[LE] + nums[HI] + nums[le] + nums[le + 1];
                if (min > target) break;
                int max = nums[LE] + nums[HI] + nums[hi - 1] + nums[hi];
                if (max < target) continue;
                while (le < hi) {
                    int sum = nums[LE] + nums[HI] + nums[le] + nums[hi];
                    if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        le++;
                    } else {
                        res.add(Arrays.asList(nums[LE], nums[HI], nums[le], nums[hi]));
                        while (hi > le && nums[hi] == nums[hi - 1]) hi--;
                        while (le > HI + 1 && nums[le] == nums[le - 1]) le++;
                        hi--;
                        le++;
                    }
                }
            }
        }
        return res;
    }
}
