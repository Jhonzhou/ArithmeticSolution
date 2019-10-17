package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    @Test
    public void test() {
        String number = "23";
        PrintUtils.println(Arrays.toString(letterCombinations(number).toArray()));
    }

    private List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return Collections.emptyList();
        }
        char[][] source = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},

        };
        List<String> resultList = new ArrayList<>();
        char[] chars = digits.toCharArray();
        int length = chars.length;
        char tempChar;
        for (int index = 0; index < length; index++) {

            tempChar = chars[index];
            if (tempChar < '2' || tempChar > '9') {
                continue;
            }
            char[] temp = source[tempChar - '2'];
            resultList = appendString(temp, resultList);
        }
        return resultList;
    }

    private List<String> appendString(char[] chars, List<String> source) {
        List<String> resultList = new ArrayList<>();
        for (int index = 0; index < chars.length; index++) {
            if (source.size() <= 0) {
                resultList.add(String.valueOf(chars[index]));
            } else {
                for (int i = 0; i < source.size(); i++) {
                    resultList.add(source.get(i) + chars[index]);
                }
            }
        }
        return resultList;
    }

    /**
     * 网络题解
     */
    public List<String> letterCombinationsServer(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        String temp = "";
        int index = 0;
        findCombination(digits, map, res, temp, index);
        return res;
    }

    public void findCombination(String digits, Map<Integer, String> map, List<String> res, String temp, int index) {
        if (temp.length() == digits.length()) {
            res.add(temp);
            return;
        }
        Character c = digits.charAt(index);
        String str = map.get(c - '0');
        for (int i = 0; i < str.length(); i++) {
            findCombination(digits, map, res, temp + str.charAt(i), index + 1);
        }
    }
}
