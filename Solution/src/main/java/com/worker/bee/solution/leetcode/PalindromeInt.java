package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 回文数(9)
 * 题目描述：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class PalindromeInt {
    @Test
    public void test() {
        int x = 10;
        PrintUtils.println(isPalindromeInt(x));
    }

    private boolean isPalindromeInt(int x) {
        if (x < 0) {
            return false;
        }
        //采用字符串转的情况，需要额外的内存空间完成
        int reverseInt = 0;//反转数字
        int temp = x;
        while (temp > 0) {
            reverseInt = reverseInt * 10 + temp % 10;
            temp = temp / 10;
        }

        return x == reverseInt;
    }

}
