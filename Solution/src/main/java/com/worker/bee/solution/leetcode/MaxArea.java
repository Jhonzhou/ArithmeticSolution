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
public class MaxArea {
    @Test
    public void test() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        PrintUtils.println(maxArea(height));
    }

    private int maxArea(int[] height) {
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
