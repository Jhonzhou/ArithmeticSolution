package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 80. Remove Duplicates from Sorted Array II
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * Related Topics 数组 双指针
 */
public class _80_RemoveDuplicatesFromSortedArrayIi {

    public static void main(String[] args) {
        Solution solution = new _80_RemoveDuplicatesFromSortedArrayIi().new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        //7
        PrintUtils.println(solution.removeDuplicates(nums));
        PrintUtils.println(Arrays.toString(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 0) {
                return 0;
            }
            int preCount = 1;
            int currentIndex = 0;
            for (int index = 1; index < nums.length; index++) {

                if (nums[index] == nums[currentIndex]) {
                    if (preCount == 2) {
                        continue;
                    }
                    preCount++;
                } else {
                    preCount = 1;
                }
                currentIndex++;
                nums[currentIndex] = nums[index];

            }
            return currentIndex + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}