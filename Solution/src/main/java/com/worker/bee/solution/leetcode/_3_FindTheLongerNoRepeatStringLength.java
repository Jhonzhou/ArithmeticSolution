package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 题目描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class _3_FindTheLongerNoRepeatStringLength {
    @Test
    public void test() {
        String test = "aabaab!bb";
        PrintUtils.println(lengthOfLongestSubstring(test));
        PrintUtils.println(findTheLongerNoRepeatStringLength(test));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 思路：
     * 1、将遍历过得字符都放入集合
     * 2、(关键) 判断重复字符在集合中的位置，从上一个重复的字符之后开始重新计算长度
     * <p>
     * 3、注意 后续重复字符的index小于之前重复之前的index
     */
    private long findTheLongerNoRepeatStringLength(String string) {
        if (string == null || string.length() == 0) {
            return 0L;
        }
        ArrayList<Character> characters = new ArrayList<>();

        int result = 0;
        int size = string.length();
        char currentChar;
        int startIndex = 0;
        for (int i = 0; i < size; i++) {
            currentChar = string.charAt(i);
            if (characters.contains(currentChar)) {
                //处理后面重复的字符在之前之前重复的字符之前
                if (characters.lastIndexOf(currentChar) + 1 > startIndex) {
                    startIndex = characters.lastIndexOf(currentChar) + 1;
                }
            }
            characters.add(currentChar);
            int temp = characters.size() - startIndex;
            if (result < temp) {
                result = temp;
            }
        }

        return result;
    }
}
