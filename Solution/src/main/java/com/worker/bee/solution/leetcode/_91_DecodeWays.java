package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 91. Decode Ways
 * 题目描述：
 * <p>
 * &emsp;&emsp;一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 1 2
 * 12
 * <p>
 * * 输入: "122"
 * 1 2 2
 * 12 2
 * 1 22
 * <p>
 * 输入: "1226"
 * 1 2 2 6
 * 1 2 26
 * 12 2 6
 * 12 26
 * 1 22 6
 * <p>
 * * 输入: "12269"
 * 1 2 2 6 9
 * 1 2 26 9
 * 12 2 6 9
 * 12 26 9
 * <p>
 * <p>
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * Related Topics 字符串 动态规划
 */
public class _91_DecodeWays {

    public static void main(String[] args) {
        Solution solution = new _91_DecodeWays().new Solution();
        String s = "226";
        PrintUtils.println(solution.numDecodings(s));
    }


    class Solution {
        public int numDecodings(String s) {
            if (s == null) {
                return 0;
            }
            if (s.charAt(0) == '0') {
                return 0;
            }

            int len = s.length();
            int []dp = new int[len];
            dp[0] = 1;

            String subStr;
            int tempNum;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == '0') {
                    if (s.charAt(i-1) == '0') {
                        return 0;
                    } else if(s.charAt(i-1) > '2') {
                        return 0;
                    }else {
                        dp[i]= i-2 < 0 ? 1 : dp[i-2];
                    }
                } else {
                    subStr = s.substring(i - 1, i + 1);
                    tempNum = Integer.valueOf(subStr);
                    if (s.charAt(i-1) == '0'){
                        dp[i] =  dp[i-1];
                    }else if (tempNum <= 26) {
                        dp[i]=(i-2)<0 ? 2:(dp[i-1]+dp[i-2]);
                    } else {
                        dp[i] =  dp[i-1];
                    }
                }
            }

            return dp[len - 1];
        }
//        public int numDecodings(String s) {
//            int sLength = s.length();
//            int[] results = new int[sLength];
//            if (s.charAt(sLength - 1) == '0') {
//                if (sLength == 1 || s.charAt(sLength - 2) < '1' || s.charAt(sLength - 2) > '2') {
//                    return 0;
//                }
//                results[sLength - 1] = 0;
//            } else {
//                results[sLength - 1] = 1;
//            }
//            if (sLength == 1) {
//                return results[0];
//            }
//            if (s.charAt(sLength - 2) == '0') {
//                if ((sLength - 3 < 0) || (s.charAt(sLength - 3) < '1') || (s.charAt(sLength - 3) > '2')) {
//                    return 0;
//                }
//                results[sLength - 2] = results[sLength - 1];
//                results[sLength - 3] = results[sLength - 1];
//            } else if (s.charAt(sLength - 2) == '1' || ((s.charAt(sLength - 2) == '2') && s.charAt(sLength - 1) <= '6')) {
//                results[sLength - 2] = 1 + results[sLength - 1];
//            } else {
//                results[sLength - 2] = results[sLength - 1];
//            }
//            for (int i = sLength - 3; i >= 0; --i) {
//                if (results[i] != 0) {
//                    continue;
//                }
//                if (s.charAt(i) == '0') {
//                    if (i == 0 || (s.charAt(i - 1) < '1') || (s.charAt(i - 1) > '2')) {
//                        return 0;
//                    }
//                    results[i] = results[i + 1];
//                    results[i - 1] = results[i + 1];
//                } else if (s.charAt(i) == '1' || ((s.charAt(i) == '2') && s.charAt(i + 1) <= '6')) {
//                    results[i] = results[i + 1] + results[i + 2];
//                } else {
//                    results[i] = results[i + 1];
//                }
//            }
//            return results[0];
//        }

        /**
         * 动态规划从头计算，分开计算之前计算的结尾状态
         * 分为 单字母结尾和两个字母结尾，
         */
        public int numDecodingsMy(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            if (s.startsWith("0")) {
                return 0;
            }
            if (s.length() == 1) {

                return 1;
            }
            int endTwo = 0;
            int endSingle = 1;
            char[] chars = s.toCharArray();
            for (int index = 1; index < chars.length; index++) {
                char currentChar = chars[index];
                char preChar = chars[index - 1];
                if (currentChar == '0') {
                    if (preChar == '0' || preChar >= '3') {
                        return 0;
                    }
                    endTwo = endSingle;
                    endSingle = 0;
                    continue;
                }
                if (preChar == '0') {
                    endSingle = endSingle + endTwo;
                    endTwo = 0;
                } else if (preChar <= '1') {
                    int temp = endTwo;
                    endTwo = endSingle;
                    endSingle = endSingle + temp;
                } else if (preChar == '2') {
                    if (currentChar <= '6') {
                        int temp = endTwo;
                        endTwo = endSingle;
                        endSingle = endSingle + temp;
                    } else {
                        endSingle = endSingle + endTwo;
                        endTwo = 0;
                    }
                } else {
                    endSingle = endSingle + endTwo;
                    endTwo = 0;
                }
            }

            return endSingle + endTwo;
        }


    }

}