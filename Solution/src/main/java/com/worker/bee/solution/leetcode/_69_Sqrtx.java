package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 69. Sqrt(x)
 * 题目描述：
 * <p>
 * &emsp;&emsp;实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * Related Topics 数学 二分查找
 */
public class _69_Sqrtx {

    public static void main(String[] args) {
        Solution solution = new _69_Sqrtx().new Solution();
        int x = 8;
        PrintUtils.println(solution.mySqrt(x));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            long start = 0;
            long end = x;
            long temp;
            long middle;
            while (start < end) {
                middle = (start + end + 1) >>> 1;
                temp = middle * middle;
                if (temp < x) {
                    start = middle;
                } else if (temp > x) {
                    end = middle - 1;
                } else {
                    return (int) middle;
                }
            }
            return (int) start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}