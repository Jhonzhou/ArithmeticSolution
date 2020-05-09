package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 68. Text Justification
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * Related Topics 字符串
 */
public class _68_TextJustification {

    public static void main(String[] args) {
        Solution solution = new _68_TextJustification().new Solution();
        String[] words = new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        };
        int maxWidth = 20;
        PrintUtils.printList(solution.fullJustify(words, maxWidth));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            if (words == null || words.length <= 0) {
                return Collections.emptyList();
            }
            List<String> resultList = new ArrayList<>();
//            int start = 0;
//            int end = 0;
//            int tempLength = 0;
//            for (int index = 0; index < words.length; index++) {
//                tempLength = tempLength + 1 + words[index].length();
//                if (start == index) {
//                    tempLength = words[start].length();
//                    continue;
//                }
//                if (tempLength == maxWidth) {
//                    end = index;
//                    resultList.add(appendString(words, start, end, maxWidth));
//                    start = index + 1;
//                    if (index + 1 == words.length) {
//                        break;
//                    }
//                } else if (tempLength > maxWidth) {
//                    end = index - 1;
//                    resultList.add(appendString(words, start, end, maxWidth));
//                    start = index;
//                    tempLength = words[index].length();
//                }
//            }
//            if (end != words.length - 1) {
//                StringBuilder builder =new StringBuilder();
//                builder.append(words[end+1]);
//                for (int index = end+2; index < words.length; index++) {
//                    builder.append(" ");
//                    builder.append(words[index]);
//                }
//                resultList.add(builder.toString());
//            }
            return resultList;
        }

        public String appendString(String[] words, int start, int end, int maxWidth) {
            StringBuilder builder = new StringBuilder();
            builder.append(words[start]);
            int tempCount = 0;
            for (int index = start + 1; index <= end; index++) {
                tempCount++;
                builder.append("#");
                builder.append(" ").append(words[index]);
            }
            String result = builder.toString();
            int tempMaxWidth = maxWidth + tempCount;

            if (result.length() == tempCount) {
                return result.replace("#", "");
            } else {
                while (result.length() < tempMaxWidth) {
                    result = result.replace("#", "# ");
                }
                while (tempCount > 0) {
                    result = result.replaceFirst("#", "");
                    tempCount--;
                    if (maxWidth == result.length()) {
                        break;
                    }
                }
                return result.replace("#", "");
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}