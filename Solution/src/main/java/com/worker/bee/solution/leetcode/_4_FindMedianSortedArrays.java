package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 寻找两个有序数组的中位数
 * <p>
 * 题目描述：
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class _4_FindMedianSortedArrays {
    @Test
    public void test() {
        int[] nums1 ={1,2};
        int[] nums2 = {3,4};
        double arrays = findMedianSortedArrays(nums1, nums2);
        PrintUtils.println(arrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] temp = new int[size1 + size2];
        int i = 0, j = 0, index = 0;
        while (i < size1 || j < size2) {
            if (i >= size1) {
                temp[index] = nums2[j];
                j++;
            } else if (j >= size2) {
                temp[index] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                temp[index] = nums1[i];
                i++;
            } else {
                temp[index] = nums2[j];
                j++;
            }
            index++;
        }
        double m = (size1 + size2-1) / 2d;
        return (temp[(int) Math.floor(m)] + temp[(int) Math.ceil(m)]) / 2d;
    }
}