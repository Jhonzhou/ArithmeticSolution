package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目标题:
 * 127. Word Ladder
 */
public class _127_WordLadder {

    public static void main(String[] args) {
        Solution solution = new _127_WordLadder().new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
//        "hot","dot","dog","lot","log","cog"
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        PrintUtils.println(solution.ladderLength(beginWord, endWord, wordList));
    }
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.isEmpty()) {
                return 0;
            }
            if (beginWord == null || endWord == null) {
                return 0;
            }
            if (!wordList.contains(endWord)) {
                return 0;
            }

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int count = 0;
            while (!queue.isEmpty()) {
                for (String s : queue) {
                    wordList.remove(s);
                }
                int size = queue.size();
                count++;
                for (int index = 0; index < size; index++) {
                    String poll = queue.poll();
                    if (poll.equals(endWord)) {
                        return count;
                    }
                    for (String s : wordList) {
                        if (isOnlyOneDifferentIndex(poll, s)) {
                            queue.offer(s);
                        }
                    }
                }

            }
            return 0;
        }

        /**
         * 两个字符串是否只有一个字符不相同
         */
        private boolean isOnlyOneDifferentIndex(String first, String second) {
            if (first.length() != second.length()) {
                return false;
            }
            int count = 0;
            for (int index = 0; index < first.length(); index++) {
                if (first.charAt(index) != second.charAt(index)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return count == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}