package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()
 */
public class LongestValidParentheses {
    @Test
    public void test() {
        String s = "()))";
        PrintUtils.println(longestValidParenthesesServer(s));
//        PrintUtils.println(longestValidParentheses(s));

    }

    /**
     * 前后遍历解决问题
     */
    public int longestValidParentheses111(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            //)(
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }


    /**
     * 入栈 出栈解决问题
     */
    private int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int validLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
//        "()()"
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    validLength = Math.max(validLength, i - stack.peek());
                }
            }
        }

        return validLength;
    }

    /**
     * 动态规划
     * 时间复杂度O(n)遍历一次字符串
     * 控件复杂度O(n)创建一个长度为n的数组
     * 1、dp[]的数组保存以改节点为尾的有效字符串的长度
     * 2、如果i和i-1为()则长度为dp[i-2]的长度加2，否则为2例如：()()这种并列情况
     * 3、确保当前节点为')'如果之前节点为尾的节点有效字符串之前的为'('则有效长度加2例如：((()))这种嵌套的情况
     */
    private int longestValidParenthesesServer(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0
                        && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] +
                            ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0)
                            + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 暴力破解(方法超时)
     * 1、从起点开始每次增加2判断是否为有效结果
     * 2、对比选择最大的长度
     */
    private class Test1 {

        private int longestValidParentheses(String s) {
            if (s == null || s.length() <= 1) {
                return 0;
            }
            int validLength = 0;
            char[] chars = s.toCharArray();
            for (int index = 0; index < chars.length; index++) {
                for (int end = index + 1; end < chars.length; end = end + 2) {
                    if (isValid(chars, index, end)) {
                        validLength = validLength > (end - index + 1) ? validLength : (end - index + 1);
                    }
                }
            }
            return validLength;
        }

        public boolean isValid(char[] chars, int start, int end) {
            int pre = 0;
            for (int index = start; index <= end; index++) {
                if (chars[index] == '(') {
                    pre++;
                } else {
                    pre--;
                }
                if (pre < 0) {
                    return false;
                }
            }
            return pre == 0;
        }

    }
}
