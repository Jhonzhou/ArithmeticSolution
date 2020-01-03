package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 65. Valid Number
 * 题目描述：
 * <p>
 * &emsp;&emsp;验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3 " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * <p>
 * <p>
 * 当然，在输入中，这些字符的上下文也很重要。
 * <p>
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * Related Topics 数学 字符串
 */
public class _65_ValidNumber {

    public static void main(String[] args) {
        Solution solution = new _65_ValidNumber().new Solution();
        String s = "3.";
        PrintUtils.println(solution.isNumber(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 规则
         * 只能以 +、-和数组开头
         * <p>
         * e之后只能含有1~9和-号
         */
        public boolean isNumber(String s) {

            return true;
        }

        public boolean isNumber(char c) {
            int temp = c - '0';
            return temp >= 0 && temp <= 9;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}