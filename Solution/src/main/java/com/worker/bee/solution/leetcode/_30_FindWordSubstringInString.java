package com.worker.bee.solution.leetcode;


import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _30_FindWordSubstringInString {
    @Test
    public void test() {
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar", "foo", "the"};
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> result = findSubstring(s, words);
        if (result != null) {
            PrintUtils.println(Arrays.toString(result.toArray()));
        } else {
            PrintUtils.println("result is null");
        }
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) {
                res.add(i);
            }
        }
        return res;
    }


    /**
     * 我自己的尝试，在大量重复元素的情况下超时
     */
    private static class MyTry {
        private List<Integer> findSubstring(String s, String[] words) {
            if (s == null || s.length() <= 0) {
                return Collections.emptyList();
            }

            if (words == null || words.length <= 0) {
                return Collections.emptyList();
            }
            int wordsLength = words.length;
            List<Integer> resultList = new ArrayList<>();

            List<Integer> alreadyFor;
            String temp;
            for (int index = 0; index < wordsLength; index++) {
                int indexOf = s.indexOf(words[index]);
                while (indexOf != -1) {
                    alreadyFor = new ArrayList<>();
                    alreadyFor.add(index);
                    temp = s.substring(indexOf + words[index].length());
                    boolean result = math(temp, words, alreadyFor);
                    if (result) {
                        if (!resultList.contains(indexOf)) {
                            resultList.add(indexOf);
                        }
                    }
                    indexOf = s.indexOf(words[index], indexOf + 1);
                }
            }

            return resultList;
        }

        private boolean math(String s, String[] words, List<Integer> alreadyFor) {
            boolean result = true;
            if ((s == null || s.length() <= 0) && alreadyFor.size() == words.length) {
                return true;
            }
            if (s == null || s.length() <= 0) {
                return false;
            }
            if (alreadyFor.size() == words.length) {
                return true;
            }
            List<Integer> tempList;
            for (int index = 0; index < words.length; index++) {
                if (alreadyFor.contains(index)) {
                    continue;
                }
                if (s.startsWith(words[index])) {
                    tempList = new ArrayList<>(alreadyFor);
                    tempList.add(index);
                    String temp = s.substring(words[index].length());
                    result = math(temp, words, tempList);
                    if (result) {
                        return true;
                    }
                } else {
                    result = false;
                }
            }
            return result;
        }
    }


}
