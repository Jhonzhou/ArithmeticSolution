package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 无重复字符的最长子串
 * 题目描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class FindTheLongerNoRepeatStringLength {
    @Test
    public void test() {
        String test = "aabaab!bb";
        PrintUtils.println(findTheLongerNoRepeatStringLength(test));
    }

    /**
     * 思路：
     * 1、将遍历过得字符都放入集合
     * 2、(关键) 判断重复字符在集合中的位置，从上一个重复的字符之后开始重新计算长度
     *
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
