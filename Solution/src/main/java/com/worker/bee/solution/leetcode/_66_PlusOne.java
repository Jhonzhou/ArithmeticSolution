package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.Arrays;

/**
 * 题目标题:
 * 66. Plus One
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * Related Topics 数组
 */
public class _66_PlusOne {

    public static void main(String[] args) {
        Solution solution = new _66_PlusOne().new Solution();
        int[] digits = new int[]{9,9,9};
        PrintUtils.println(Arrays.toString(solution.plusOne(digits)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length <= 0) {
                return digits;
            }
            int length = digits.length;

            for (int index = length - 1; index >= 0; index--) {
                digits[index]++;
                digits[index] = digits[index] % 10;
                if (digits[index] != 0) {
                    return digits;
                }
            }
            //因为进位后只有首位为1其他均为0
            digits = new int[length + 1];
            digits[0] = 1;
            return digits;
        }

        public int[] plusOneSelf(int[] digits) {
            if (digits == null || digits.length <= 0) {
                return digits;
            }
            int pre = 0;
            digits[digits.length - 1] += 1;
            for (int index = digits.length - 1; index >= 0; index--) {
                int temp = digits[index] + pre;
                if (temp >= 10) {
                    pre = 1;
                    digits[index] = temp % 10;
                    if (index == 0) {
                        //需要扩容
                        digits = new int[digits.length + 1];
                        digits[0] = 1;
//                        System.arraycopy(digits, 0, result, 1, digits.length);
//                        digits = result;
                        break;
                    }
                } else {
                    digits[index] = temp;
                    break;
                }
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}