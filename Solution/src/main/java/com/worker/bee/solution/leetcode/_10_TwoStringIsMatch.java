package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 10. 正则表达式匹配
 * <p>
 * 题目描述：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class _10_TwoStringIsMatch {
    @Test
    public void test() {
//        String s = "aab";
//        String p = "c*a*b";
        String s = "mississippi";
        String p = "mis*is*ip*.";
//        String s = "aaa";
//        String p = "aaaa";
//        String s = "aaa";
//        String p = ".*";
        PrintUtils.println(isMath(s, p));
    }

    //error
    private boolean isMath(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
