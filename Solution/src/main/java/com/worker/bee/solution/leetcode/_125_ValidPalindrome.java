package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 125. Valid Palindrome
 */
public class _125_ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new _125_ValidPalindrome().new Solution();
        String s = "A man, a plan, a canal: Panama";
        PrintUtils.println(solution.isPalindrome(s));
    }
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() <= 0) {
                return false;
            }
            String s1 = s.toLowerCase();
            char[] chars = s1.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left <= right) {
                if (!isNumberOrWord(chars[left])) {
                    left++;
                    continue;
                }
                if (!isNumberOrWord(chars[right])) {
                    right--;
                    continue;
                }
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;

            }
            return true;
        }

        private boolean isNumberOrWord(char c) {
            return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}