package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 38. 报数
 * 题目描述：
 * <p>
 * &emsp;&emsp;报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * <p>
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 题目理解  下一个报上一个的数字个数和顺序
 */
public class CountAndSay {
    @Test
    public void test() {
        int number = 6;
        PrintUtils.println(countAndSay(number));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countString(countAndSay(n - 1));
    }

    public String countString(String pre) {
        if (pre == null || pre.length() <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char[] chars = pre.toCharArray();
        int count = 1;
        char preChar = chars[0];
        if (chars.length == 1) {
            result.append(count).append(preChar);
            return result.toString();
        }
        for (int index = 1; index < chars.length; index++) {
            if (preChar == chars[index]) {
                count++;
            } else {
                result.append(count).append(preChar);
                count = 1;
                preChar = chars[index];
            }
        }
        result.append(count).append(preChar);
        return result.toString();
    }

    public static class Server {
        public String countAndSay(int n) {
            StringBuilder ans = new StringBuilder();
            ans.append("1");
            for (int i = 2; i <= n; i++) {
                //遍历前一个字符串
                String currentStr = new String(ans);
                ans.delete(0, ans.length());
                int num = 0;
                char currentChar = currentStr.charAt(0);
                for (char c : currentStr.toCharArray()) {
                    if (c == currentChar) {
                        num++;
                    } else {
                        ans.append((char) ('0' + num));
                        ans.append(currentChar);
                        currentChar = c;
                        num = 1;
                    }
                }
                ans.append((char) ('0' + num));
                ans.append(currentChar);
            }
            return ans.toString();
        }
    }

}
