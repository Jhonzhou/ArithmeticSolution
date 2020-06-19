package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 11. 盛最多水的容器
 * 题目描述：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 */
public class _11_ContainerWithMostWater {
    @Test
    public void test() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        PrintUtils.println(maxArea(height));
    }

    // 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针

    /**
     * 双指针法
     */
    private int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        int tempArea = 0;
        while (left < right) {
            tempArea = Math.min(height[left] , height[right]) * (right - left);
            maxArea = Math.max(tempArea, maxArea);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    /**
     * 暴力破解
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int length = height.length;
        int maxArea = 0, tempArea = 0;
        int xLength = 0;
        int yLength = 0;
        for (int x = 0; x < length; x++) {
            for (int y = x; y < length; y++) {
                xLength = y - x;
                yLength = Math.min(height[y], height[x]);
                tempArea = xLength * yLength;
                if (maxArea < tempArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }
}
