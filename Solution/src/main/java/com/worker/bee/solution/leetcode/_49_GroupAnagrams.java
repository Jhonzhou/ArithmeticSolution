package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 题目标题:
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * <p>
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * Related Topics 哈希表 字符串
 */
public class _49_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        List<List<String>> temp = Server.groupAnagrams(strs);
        printResult(lists);
        printResult(temp);
    }

    private static void printResult(List<List<String>> lists) {
        if (lists == null || lists.isEmpty()) {
            PrintUtils.println("result is null");
            return;
        }
        for (List<String> list : lists) {
            PrintUtils.println(Arrays.toString(list.toArray()));

        }
    }

    /**
     * 将字符串各个字符按照字母顺序排序后，则含有相同字符的一致
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String result = String.valueOf(chars);
            List<String> stringList;
            if (tempMap.containsKey(result)) {
                stringList = tempMap.get(result);
            } else {
                stringList = new ArrayList<>();
                tempMap.put(result, stringList);
            }
            stringList.add(str);
        }

        return new ArrayList<>(tempMap.values());
    }

    static class Server {
        public static List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> tempMap = new HashMap<>();
            int[] ints = new int[26];
            for (String str : strs) {
                Arrays.fill(ints, 0);
                char[] chars = str.toCharArray();
                for (char aChar : chars) {
                    ints[aChar - 'a'] = ints[aChar - 'a'] + 1;
                }
                StringBuilder builder = new StringBuilder();
                for (int anInt : ints) {
                    builder.append(anInt).append("#");
                }
                String temp = builder.toString();
                List<String> strings;

                if (tempMap.containsKey(temp)) {
                    strings = tempMap.get(temp);
                } else {
                    strings = new ArrayList<>();
                    tempMap.put(temp, strings);
                }
                strings.add(str);
            }
            return new ArrayList<>(tempMap.values());
        }
    }

}