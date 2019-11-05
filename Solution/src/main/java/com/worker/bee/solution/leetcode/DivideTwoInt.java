package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 29. 两数相除
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoInt {
    @Test
    public void test() {
        int dividend = 10, divisor = 3;
        PrintUtils.println(dividend + " / " + divisor + " = " + divide(dividend, divisor));
        PrintUtils.println(dividend + " / " + divisor + " = " + divideServer(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("divisor can not be zero");
        }
        boolean resultBoolean = true;
        if (dividend < 0) {
            resultBoolean = false;
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
            resultBoolean = !resultBoolean;
        }

        int result = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            result++;
        }

        return resultBoolean ? result : -result;
    }

    /**
     * 网络题解
     */
    public int divideServer(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }
}
