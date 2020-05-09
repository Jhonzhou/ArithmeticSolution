package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 81. Search in Rotated Sorted Array II
 * 题目描述：
 * <p>
 * &emsp;&emsp;假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * <p>
 * 进阶:
 * <p>
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * Related Topics 数组 二分查找
 */
public class _81_SearchInRotatedSortedArrayIi {

    public static void main(String[] args) {
        Solution solution = new _81_SearchInRotatedSortedArrayIi().new Solution();
        int nums[] = new int[]{3, 1, 1};
        int target = 0;
        PrintUtils.println(solution.search(nums, target));
        PrintUtils.println(Arrays.toString(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[start] == nums[mid]) {
                    start++;
                    continue;
                }
                //前半部分有序
                if (nums[start] < nums[mid]) {
                    //target在前半部分
                    if (nums[mid] > target && nums[start] <= target) {
                        end = mid - 1;
                    } else {  //否则，去后半部分找
                        start = mid + 1;
                    }
                } else {
                    //后半部分有序
                    //target在后半部分
                    if (nums[mid] < target && nums[end] >= target) {
                        start = mid + 1;
                    } else {  //否则，去后半部分找
                        end = mid - 1;

                    }
                }
            }
            //一直没找到，返回false
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}