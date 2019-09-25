package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长子序列(524)
 * <p>
 * 题目描述：
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串
 */
public class FindLongestWord {
    @Test
    public void test() {
        String s = "abpcplea";
        String[] strings = {"ale", "apple", "monkey", "plea"};

        List<String> d = Arrays.asList(strings);
        String longestWord = findLongestWord(s, d);
        PrintUtils.println(longestWord + " longestWord : " + longestWord.length());
    }

    /**
     * 思路：
     * 1、遍历字符串数组
     * 2、将每个数组的字符在给定的字符串中查找，每次查找的起点是上一个查找结果坐标
     * 3、给定的查找的起点为-1；每次查找是index+1开始(indexOf()查找是含有起点的，如果不+1，当遇见连续重复字符是则会出差)
     * 4、如果查找到最后index部位-1则成功
     */
    private String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        if (d == null || d.size() <= 0) {
            return "";
        }
        char[] temp;
        int index = -1;
        String result = "";
        for (String s1 : d) {
            temp = s1.toCharArray();
            for (char c : temp) {
                index = s.indexOf(c, index + 1);
                if (index == -1) {
                    break;
                }
            }
            if (index != -1) {
                if (s1.length() > result.length()) {
                    result = s1;
                } else if (s1.length() == result.length()) {
                    if (s1.compareTo(result) < 0) {
                        result = s1;
                    }
                }
            }
            index = -1;
        }
        return result;
    }
}
