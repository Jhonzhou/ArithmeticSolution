package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 两数平方和
 * 题目描述：判断一个数是否为两个数的平方和
 */
public class SumOfSquareNumbers {
    @Test
    public void test() {
        boolean sumOfSquareNumber = isSumOfSquareNumber(17);
        PrintUtils.println("result :"+sumOfSquareNumber);
    }

    private boolean isSumOfSquareNumber(int number) {
        int sqrt = (int) Math.sqrt(number);
        int start = 1;
        int end = sqrt;
        int temp;
        while (start < end) {
            temp = start * start + end * end;
            if (temp == number) {
                PrintUtils.println("start: " + start + " end : " + end);
                return true;
            } else if (temp < number) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
