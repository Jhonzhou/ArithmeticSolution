package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 93. Restore IP Addresses
 */
public class _93_RestoreIpAddresses {

    public static void main(String[] args) {
        Solution solution = new _93_RestoreIpAddresses().new Solution();
        String input = "25525511135";
        PrintUtils.printList(solution.restoreIpAddresses(input));
        SolutionServer solutionServer = new _93_RestoreIpAddresses().new SolutionServer();
        PrintUtils.printList(solutionServer.restoreIpAddresses(input));
    }
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 示例:
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
// Related Topics 字符串 回溯算法


    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() <= 0 || s.length() > 12) {
                return Collections.emptyList();
            }
            List<String> resultList = new ArrayList<>();
            back(s, 0, new ArrayList<String>(), resultList);

            return resultList;
        }

        private void back(String s, int position, ArrayList<String> tempList, List<String> resultList) {
            if (tempList == null) {
                tempList = new ArrayList<>();
            }
            if (tempList.size() == 4 && position == s.length()) {
                resultList.add(String.join(".", tempList));
//                StringBuilder result = new StringBuilder();
//                for (int index = 0; index < tempList.size(); index++) {
//                    result.append(tempList.get(index));
//                    if (index != 3) {
//                        result.append(".");
//                    }
//                }
//                resultList.add(result.toString());
                return;
            }
            //每个分解数组最大255 共三位
            for (int index = 1; index <= 3; index++) {
                if (position + index > s.length()) {
                    return;
                }
                String substring = s.substring(position, position + index);
                if (substring.startsWith("0")
                        && substring.length() > 1
                        || (index == 3 && Integer.parseInt(substring) > 255)) {
                    continue;
                }
                tempList.add(substring);
                back(s, position + index, tempList, resultList);
                tempList.remove(tempList.size() - 1);

            }
        }


    }

    class SolutionServer {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return ans;
            }
            // 回溯
            back(s, 0, new ArrayList<String>(), ans);
            return ans;
        }

        // 中间两个参数解释：pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
        private void back(String s, int pos, List<String> cur, List<String> ans) {
            if (cur.size() == 4) {
                // 如果此时 pos 也刚好遍历完整个 s
                if (pos == s.length()) {
                    // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
                    ans.add(String.join(".", cur));
                }
                return;
            }

            // ip 地址每段最多有三个数字
            for (int i = 1; i <= 3; i++) {
                // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
                if (pos + i > s.length()) {
                    break;
                }
                // 将 s 的子串开始分段
                String segment = s.substring(pos, pos + i);
                // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
                if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                    continue;
                }
                // 符合要求就加入到 cur 数组中
                cur.add(segment);
                // 继续递归遍历下一个位置
                back(s, pos + i, cur, ans);
                // 回退到上一个元素，即回溯
                cur.remove(cur.size() - 1);
            }
        }

    }
}