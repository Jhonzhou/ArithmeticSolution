package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 58. Length of Last Word
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * Related Topics 字符串
 */
public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        Solution solution = new _58_LengthOfLastWord().new Solution();
        String s = "Hello World   ";
        PrintUtils.println(solution.lengthOfLastWord(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            int result = 0;
            for (int index = s.length() - 1; index >= 0; index--) {
                if (s.charAt(index) != ' ') {
                    result++;
                } else {
                    if (result > 0) {
                        return result;
                    }
                }

            }
            return result;
        }

        public int lengthOfLastWord22(String s) {
            s = s.trim();
            int i = s.lastIndexOf(" ");
            return s.length() - (i + 1);
        }

        public int lengthOfLastWord11(String s) {
            int result = 0;
            if (s == null || s.length() <= 0) {
                return result;
            }
            String[] split = s.split(" ");
            if (split.length <= 0) {
                return result;
            }
            return split[split.length - 1].length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}