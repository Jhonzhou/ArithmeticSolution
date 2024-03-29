package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 75. Sort Colors
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * Related Topics 排序 数组 双指针
 */
public class _75_SortColors {

    public static void main(String[] args) {
        Solution solution = new _75_SortColors().new Solution();
        int[] nums = new int[]{2, 0, 1};
        solution.sortColors(nums);
//        solution.sortColorsServer(nums);
        PrintUtils.println(Arrays.toString(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums.length <= 0) {
                return;
            }
            int redEnd = 0;
            int blueStart = nums.length - 1;
            int temp;
            int current = 0;
            //2, 0, 2, 1, 1, 0
            while (current <= blueStart) {
                if (nums[current] == 0) {
                    temp = nums[redEnd];
                    nums[redEnd] = nums[current];
                    nums[current] = temp;
                    redEnd++;
                    current++;
                } else if (nums[current] == 1) {
                    current++;
                } else if (nums[current] == 2) {
                    temp = nums[blueStart];
                    nums[blueStart] = nums[current];
                    nums[current] = temp;
                    blueStart--;
                }
            }
        }

        public void sortColorsServer(int[] nums) {
            // 对于所有 idx < i : nums[idx < i] = 0
            // j是当前考虑元素的下标
            int p0 = 0, curr = 0;
            // 对于所有 idx > k : nums[idx > k] = 2
            int p2 = nums.length - 1;

            int tmp;
            while (curr <= p2) {
                if (nums[curr] == 0) {
                    // 交换第 p0个和第curr个元素
                    // i++，j++
                    tmp = nums[p0];
                    nums[p0++] = nums[curr];
                    nums[curr++] = tmp;
                } else if (nums[curr] == 2) {
                    // 交换第k个和第curr个元素
                    // p2--
                    tmp = nums[curr];
                    nums[curr] = nums[p2];
                    nums[p2--] = tmp;
                } else curr++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}