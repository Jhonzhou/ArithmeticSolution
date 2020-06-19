package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 13. 罗马数字转整数
 * 题目描述：
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class _13_RomanToInt {
    @Test
    public void test() {
        String roman = "IV";
        PrintUtils.println(romanToInt(roman));
    }

    /**
     * 简约方法逻辑清晰
     */
    private int romanToInt(String romanString) {
        int result = 0;
        if (romanString == null || romanString.length() <= 0) {
            return 0;
        }
        int tempLength = romanString.length() - 1;
        char[] chars = romanString.toCharArray();
        int currentInt, nextInt = charToInt(chars[0]);

        for (int i = 0; i < tempLength; i++) {
            currentInt = nextInt;
            nextInt = charToInt(chars[i + 1]);
            if (currentInt < nextInt) {
                result = result - currentInt;
            } else {
                result = result + currentInt;
            }
        }
        result += charToInt(chars[tempLength]);
        return result;
    }

    /**
     * 个人土办法
     */
    private int privateRomanToInt(String romanString) {
        if (romanString == null || romanString.length() <= 0) {
            return 0;
        }
        int result = 0;
        char[] chars = romanString.toCharArray();
        int index = romanString.length() - 1;
        char currentChar, preChar;
        int currentInt, preInt;
        while (index >= 0) {
            currentChar = chars[index];
            currentInt = charToInt(currentChar);
            if (index - 1 >= 0) {
                preChar = chars[index - 1];
                preInt = charToInt(preChar);
                if (preInt < currentInt) {
                    result += (currentInt - preInt);
                    index = index - 2;
                    continue;
                }
            }
            result += currentInt;
            index--;
        }
        return result;
    }

    private int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }
    }
}
