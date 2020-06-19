package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 最长回文子串
 * 回文字符串即正着读和反着读都一样
 * <p>
 * 题目描述：
 * &emsp;&emsp;给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * // Related Topics 字符串 动态规划
 */
public class _5_LongestPalindrome {
    @Test
    public void test() {
        String source = "c";
//        PrintUtils.println(isPalindromeString(source));
        PrintUtils.println(longestPalindrome(source));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 反转字符串
     */
    private String reverseString(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 是否为回文字符串
     */
    private boolean isPalindromeString(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}
