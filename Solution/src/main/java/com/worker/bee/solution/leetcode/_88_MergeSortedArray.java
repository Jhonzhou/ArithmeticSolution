package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 88. Merge Sorted Array
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * Related Topics 数组 双指针
 */
public class _88_MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new _88_MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int n = 3;
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, m, nums2, n);
        PrintUtils.println(Arrays.toString(nums1));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1 = m - 1;
            int index2 = n - 1;
            int current = m + n - 1;
            while (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] < nums2[index2]) {
                    nums1[current--] = nums2[index2];
                    index2--;
                } else {
                    nums1[current--] = nums1[index1];
                    index1--;
                }
            }
            while (index1 >= 0) {
                nums1[current--] = nums1[index1];
                index1--;
            }
            while (index2 >= 0) {
                nums1[current--] = nums2[index2];
                index2--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}