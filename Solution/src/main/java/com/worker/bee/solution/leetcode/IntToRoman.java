package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 11. 整数转罗马数字
 * 题目描述：
 * <p>
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
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntToRoman {
    @Test
    public void test() {
        int num = 7;
        PrintUtils.println(intToRoman(num));
    }

    public String intToRoman(int num) {
        if (num > 3999) {
            return "error";
        }
        StringBuilder result = new StringBuilder();
        int temp = num;
        int remainder;
        String[][] array = new String[][]{
                {"I", "V", "X"},
                {"X", "L", "C"},
                {"C", "D", "M"},
                {"M", "M", "M"}
        };
        int index = 0;
        while (temp > 0) {
            remainder = temp % 10;
            result.insert(0, numbToString(remainder, array[index][0], array[index][1], array[index][2]));
            index++;
            temp = temp / 10;
        }
        return result.toString();
    }

    public String numbToString(int num, String pre, String current, String end) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return pre;
            case 2:
                return pre + pre;
            case 3:
                return pre + pre + pre;
            case 4:
                return pre + current;
            case 5:
                return current;
            case 6:
                return current + pre;
            case 7:
                return current + pre + pre;
            case 8:
                return current + pre + pre;
            case 9:
                return pre + end;
            default:
                return "error";
        }
    }
}
