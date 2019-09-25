package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.TreeMap;

/**
 * 整数反转(7)
 * <p>
 * 题目描述
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class ReverseInt {
    @Test
    public void test() {
        int source = -123;
        PrintUtils.println(reverseIntByString(source));
    }

    private int reverseIntByString(int source) {
        String string = Integer.toString(source);
        StringBuilder temp;
        boolean isLower = false;
        if (string.startsWith("-")) {
            temp = new StringBuilder(string.substring(1));
            isLower = true;
        } else {
            temp = new StringBuilder(string);
        }
        temp.reverse();
        StringBuilder resultString=new StringBuilder();
        if (isLower) {
            resultString.append("-");
        }
        resultString.append(temp);
        int result = 0;
        try {
            result = Integer.parseInt(resultString.toString());
        } catch (NumberFormatException e) {

        }
        return result;
    }

    /**
     * 主要考虑int超出范围问题
     */
    private int reverseInt(int source) {
        int result = 0;
        int temp;
//        int MIN_VALUE = -2147483648;
//        int MAX_VALUE = 2147483647;
        while (source != 0) {
            temp = source % 10;//取余
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            source = source / 10;//取商
            result = result * 10 + temp;

        }
        return result;
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

}
