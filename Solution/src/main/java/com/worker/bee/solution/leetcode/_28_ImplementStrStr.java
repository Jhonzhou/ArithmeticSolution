package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 28. 实现 strStr()
 * 题目描述：
 * <p>
 * &emsp;&emsp;实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class _28_ImplementStrStr {

    @Test
    public void test() {
        String haystack = "mississippi";
        String needle = "pi";
        PrintUtils.println(strStr(haystack, needle));
    }

    /**
     * 本地暴力解法
     */
    private int strStr(String haystack, String needle) {
        if (needle == null || needle.length() <= 0) {
            return 0;
        }
        if (haystack == null || haystack.length() <= 0) {
            return -1;
        }
        int result = -1;
        int firstIndex = 0;
        int secondIndex = 0;
        int firstLength = haystack.length();
        int secondLength = needle.length();

        while (firstIndex < firstLength && secondIndex < secondLength) {
            if (haystack.charAt(firstIndex) == needle.charAt(secondIndex)) {
                if (result == -1) {
                    result = firstIndex;
                }
                secondIndex++;
            } else {
                secondIndex = 0;
                if (result != -1) {
                    firstIndex = result;
                }
                if (firstIndex + secondLength >= firstLength) {
                    return -1;
                }
                result = -1;
            }
            firstIndex++;
        }
        if (secondIndex == secondLength) {
            return result;
        } else {
            return -1;
        }
    }

    /**
     * 来自网络解法
     */
    public int strStrFromServer(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (haystack.equals(needle))
            return 0;
        if (len2 == 0)
            return 0;
        else if (len1 == 0)
            return -1;
        else {
            int i = 0;
            while (i <= len1 - len2) {
                if (haystack.substring(i, i + len2).equals(needle))
                    return i;
                i++;
            }
            return -1;
        }
    }
}
