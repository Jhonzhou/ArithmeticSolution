package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * <p>
 * 题目描述：
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class _6_ZStringConvert {
    @Test
    public void test() {
        String s = "LEETCODEISHIRING";

        String result = "LCIRETOESIIGEDHN";
        int numRows = 3;
        String convert = guangFangConvert(s, numRows);
        PrintUtils.println(convert + " result : " + result.equals(convert));
    }

    /**
     * 官方题解
     */
    private String guangFangConvert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) {
            return "";
        }
        if (numRows==1){
            return s;
        }
        int length = s.length();
        StringBuilder result = new StringBuilder(length);
        List<StringBuilder> tempList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            tempList.add(new StringBuilder());
        }
        int row = 0;
        boolean flag = false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            tempList.get(row).append(aChar);
            if (row == 0 || row == numRows - 1) {
                flag = !flag;
            }
            row += flag ? 1 : -1;
        }
        for (StringBuilder builder : tempList) {
            result.append(builder);
        }
        return result.toString();
    }

    /**
     * 查找每行index的规律(index加减rowNum和每个z的长度取余为0)
     * 时间较长
     */
    private String firstConvert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder result = new StringBuilder();
        int everySize = 2 * numRows - 2;
        int row = 0;
        int index = 0;
        while (row < numRows) {
            while (index < length) {
                if ((index - row) % everySize == 0
                        || (index + row) % everySize == 0) {
                    result.append(s.charAt(index));
                }
                index++;
            }
            index = row;
            row++;
        }
        return result.toString();
    }

}
