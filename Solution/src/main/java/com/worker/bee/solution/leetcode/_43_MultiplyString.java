package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.Arrays;

/**
 * 43. 字符串相乘
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * ```
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * ```
 * 说明：
 * <p>
 * - num1 和 num2 的长度小于110。
 * - num1 和 num2 只包含数字 0-9。
 * - num1 和 num2 均不以零开头，除非是数字 0 本身。
 * - 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class _43_MultiplyString {
    @Test
    public void test() {
        String num1 = "999";
        String num2 = "999";
        //"998001"
        PrintUtils.println(multiply(num1, num2));
    }

    /**
     * 1、两个数结果的长度最常为长度之和加一
     * 2、拆分两个数相乘abc * def=(a00+b0+c)*def=a*100*def+b*10*def+c*def
     * 3、a*def=a*d*100+a*e*10+a*f
     * 4、以上的10的倍数的相乘则认为不同的数组位置
     */
    private String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        //123*456=
        //------------------
        //123
        //456
        //----------以下为123*6 结果为738------
        //          18
//                 12
//                 6
        //----------以下为123*5 -结果为615-----
//                 15
//                10
//                5
        //----------以下为123*4 -结果我492----
//                12
//                8
//               4
        //----------最终结果为00056088----

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] result = new int[chars1.length + chars2.length];
        for (int first = chars1.length - 1; first >= 0; first--) {
            //乘数
            int multi = Character.getNumericValue(chars1[first]);
            for (int second = chars2.length - 1; second >= 0; second--) {
                int temp = Character.getNumericValue(chars2[second]);
                int tempResult = multi * temp;
                int lastIndex = first + second + 1;
                result[lastIndex] = result[lastIndex] + tempResult;
//                result[lastIndex - 1] = result[lastIndex - 1] + tempResult / 10;
            }
        }

        int pre = 0;
        for (int index = result.length - 1; index >= 0; index--) {
            int temp = result[index] + pre;
            if (temp > 9) {
                result[index] = temp % 10;
                pre = temp / 10;
            } else {
                result[index] = temp;
                pre = 0;
            }
        }
        int startIndex = -1;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < result.length; index++) {
            if (startIndex == -1 && result[index] != 0) {
                startIndex = index;
            }
            if (startIndex != -1) {
                builder.append(result[index]);
            }
        }
        return builder.toString();
    }

    public class Server {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
            char[] ans = new char[l];
            char[] c1 = num1.toCharArray();
            char[] c2 = num2.toCharArray();
            for (int i = l1 - 1; i >= 0; --i) {
                int c = c1[i] - '0';
                for (int j = l2 - 1; j >= 0; --j) {
                    ans[i + j + 1] += c * (c2[j] - '0');
                }
            }
            for (int i = l - 1; i > 0; --i) {
                if (ans[i] > 9) {
                    ans[i - 1] += ans[i] / 10;
                    ans[i] %= 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (; ; ++i) if (ans[i] != 0) break;
            for (; i < ans.length; ++i) sb.append((char) (ans[i] + '0'));
            return sb.toString();
        }
    }

    public class Self {
        /**
         * 普通相乘
         * 按位相乘然后在相加
         * 1、abc * def=(a00+b0+c)*def=a*100*def+b*10*def+c*def
         */
        public String multiply(String num1, String num2) {
            StringBuilder result = new StringBuilder();
            if (num1 == null) {
                return num2;
            }
            if (num2 == null) {
                return num1;
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            String original;
            String temp;
            if (num1.length() > num2.length()) {
                original = num1;
                temp = num2;
            } else {
                original = num2;
                temp = num1;
            }
            char[] chars = original.toCharArray();
            int zeroLength = 0;
            for (int index = chars.length - 1; index >= 0; index--) {
                result = appendString(result.toString(), multiplyString(Character.getNumericValue(chars[index]), temp, zeroLength));
                zeroLength++;
            }

            return result.toString();
        }

        private String multiplyString(int multi, String original, int zeroLength) {
            StringBuilder result = new StringBuilder(original);
            if (multi == 0) {
                return "0";
            }
            for (int index = 1; index < multi; index++) {
                result = appendString(original, result.toString());
            }
            if (!"0".equals(result.toString())) {
                for (int i = 1; i <= zeroLength; i++) {
                    result.append("0");
                }
            }
            return result.toString();
        }

        /**
         * 两个字符串相加
         */
        private StringBuilder appendString(String num1, String num2) {
            StringBuilder builder = new StringBuilder();
            int temp = 0;
            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();
            int size = char1.length > char2.length ? char1.length : char2.length;
            int temp1;
            int temp2;
            for (int index = 1; index <= size; index++) {
                if (index <= char1.length) {
                    temp1 = Character.getNumericValue(char1[char1.length - index]);
                } else {
                    temp1 = 0;
                }
                if (index <= char2.length) {
                    temp2 = Character.getNumericValue(char2[char2.length - index]);
                } else {
                    temp2 = 0;
                }
                int sum = temp1 + temp2 + temp;
                if (sum >= 10) {
                    temp = 1;
                    builder.insert(0, sum % 10);
                } else {
                    temp = 0;
                    builder.insert(0, sum);
                }
            }
            if (temp > 0) {
                builder.insert(0, 1);
            }

            return builder;
        }
    }

    public class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
            char[] ans = new char[l];
            char[] c1 = num1.toCharArray();
            char[] c2 = num2.toCharArray();
            for (int i = l1 - 1; i >= 0; --i) {
                int c = c1[i] - '0';
                for (int j = l2 - 1; j >= 0; --j) {
                    ans[i + j + 1] += c * (c2[j] - '0');
                }
            }
            for (int i = l - 1; i > 0; --i) {
                if (ans[i] > 9) {
                    ans[i - 1] += ans[i] / 10;
                    ans[i] %= 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (; ; ++i) if (ans[i] != 0) break;
            for (; i < ans.length; ++i) sb.append((char) (ans[i] + '0'));
            return sb.toString();
        }
    }
}
