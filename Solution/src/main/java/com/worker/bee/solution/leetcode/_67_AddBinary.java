package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 67. Add Binary
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定两个二进制字符串，返回他们的和（用二进制表示）
 * <p>
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * Related Topics 数学 字符串
 */
public class _67_AddBinary {

    public static void main(String[] args) {
        Solution solution = new _67_AddBinary().new Solution();
        String a = "1010";
        String b = "1011";
        PrintUtils.println(solution.addBinary(a, b));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a == null || a.length() <= 0) {
                return b;
            }
            if (b == null || b.length() <= 0) {
                return a;
            }
            int aLength = a.length();
            int bLength = b.length();
            int temp = 0;
            StringBuilder result = new StringBuilder();
            int currentIndex = 1;
            while (currentIndex <= aLength
                    && currentIndex <= bLength) {
                char aChar = a.charAt(aLength - currentIndex);
                char bChar = b.charAt(bLength - currentIndex);
                int aaa = aChar - '0' + bChar - '0' + temp;
                temp = aaa / 2;
                result.append(aaa % 2);
                currentIndex++;
            }
            while (currentIndex <= aLength) {
                char aChar = a.charAt(aLength - currentIndex);
                int aaa = aChar - '0' + temp;
                temp = aaa / 2;
                result.append(aaa % 2);
                currentIndex++;
            }
            while (currentIndex <= bLength) {
                char bChar = b.charAt(bLength - currentIndex);
                int aaa = bChar - '0' + temp;
                temp = aaa / 2;
                result.append(aaa % 2);
                currentIndex++;
            }
            if (temp > 0) {
                result.append(temp);
            }
            return result.reverse().toString();
        }

        public String addBinarySelf(String a, String b) {
            if (a == null || a.length() <= 0) {
                return b;
            }
            if (b == null || b.length() <= 0) {
                return a;
            }
            int aLength = a.length();
            int bLength = b.length();
            int temp = 0;
            StringBuilder result = new StringBuilder();
            int currentIndex = 1;
            while (currentIndex <= aLength
                    && currentIndex <= bLength) {
                char aChar = a.charAt(aLength - currentIndex);
                char bChar = b.charAt(bLength - currentIndex);
                int aaa = aChar - '0' + bChar - '0' + temp;
                temp = aaa / 2;
                result.insert(0, aaa % 2);
                currentIndex++;
            }
            while (currentIndex <= aLength) {
                char aChar = a.charAt(aLength - currentIndex);
                int aaa = aChar - '0' + temp;
                temp = aaa / 2;
                result.insert(0, aaa % 2);
                currentIndex++;
            }
            while (currentIndex <= bLength) {
                char bChar = b.charAt(bLength - currentIndex);
                int aaa = bChar - '0' + temp;
                temp = aaa / 2;
                result.insert(0, aaa % 2);
                currentIndex++;
            }
            if (temp > 0) {
                result.insert(0, temp);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}