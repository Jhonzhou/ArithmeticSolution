package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 * 题目描述：
 * &emsp;&emsp;编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPrefix {
    @Test
    public void test() {
        String[] strings = {"a"};
        PrintUtils.println(longestCommonPrefix(strings));
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        int length = strs[0].length();
        int arrayLength = strs.length;
        int index = 0;
        char currentChar;
        String temp;
        result:while (index < length) {
            currentChar = strs[0].charAt(index);
            for (int m = 1; m < arrayLength; m++) {
                temp = strs[m];
                if (temp.length() <= index) {
                    break result;
                }
                if (temp.charAt(index) != currentChar) {
                    break result;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}