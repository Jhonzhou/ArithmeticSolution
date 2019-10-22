package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 21. 合并两个有序链表
 * 题目描述：
 * <p>
 * &emsp;&emsp;给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * "()"   "()()","(())"
 */
public class BracketCreate {
    @Test
    public void test() {
        int n = 4;
        PrintUtils.println(Arrays.toString(generateParenthesis(n).toArray()));
    }

    private List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n <= 0) {
            return resultList;
        }
        int index = 1;
        Set<String> hashSet = new HashSet<>();
        while (index <= n) {
            hashSet = createBracket(index, hashSet);
            index++;
        }
        resultList.addAll(hashSet);
        return resultList;
    }

    private Set<String> createBracket(int n, Set<String> stringList) {
        Set<String> resultList = new HashSet<>();
        if (n == 1) {
            resultList.add("()");
            return resultList;
        }
        for (String current : stringList) {
            int length = current.length();
            for (int x = 0; x < length; x++) {
                if (current.indexOf(x) == ')') {
                    continue;
                }
                int matchEnd = findMatchEnd(current, x);
                if (matchEnd != -1) {
                    StringBuilder builder = new StringBuilder(current);
                    builder.insert(x, '(').insert(matchEnd + 1, ')');
                    resultList.add(builder.toString());

                    builder = new StringBuilder(current);
                    builder.insert(x, "()");
                    resultList.add(builder.toString());

                    builder = new StringBuilder(current);
                    builder.insert(matchEnd + 1, "()");
                    resultList.add(builder.toString());
                }
            }
        }

        return resultList;
    }

    public int findMatchEnd(String string, int start) {
        if (string == null || string.length() < start) {
            return -1;
        }
        char[] chars = string.toCharArray();
        int pre = 0;
        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                pre++;
            } else {
                if (pre == 0) {
                    return i;
                }
                pre--;
            }
        }
        return -1;
    }


    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    public static class My {
        private List<String> generateParenthesis(int n) {
            List<String> resultList = new ArrayList<>();
            if (n <= 0) {
                return resultList;
            }
            int index = 1;
            Set<String> hashSet = new HashSet<>();
            while (index <= n) {
                hashSet = createBracket(index, hashSet);
                index++;
            }
            resultList.addAll(hashSet);
            return resultList;
        }

        private Set<String> createBracket(int n, Set<String> stringList) {
            Set<String> resultList = new HashSet<>();
            if (n == 1) {
                resultList.add("()");
                return resultList;
            }
            for (String current : stringList) {
                StringBuilder builder = new StringBuilder(current);
                int length = current.length();
                for (int x = 0; x < length; x++) {
                    builder.insert(x, '(');
                    for (int y = x + 1; y < length + 2; y++) {
                        String string = builder.insert(y, ')').toString();
                        if (valid(string.toCharArray())) {
                            resultList.add(string);
                        }
                        builder.deleteCharAt(y);
                    }
                    builder.deleteCharAt(x);
                }
            }

            return resultList;
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);
        }
    }

    public static class Server {
        public List<String> generateParenthesis11(int n) {
            List<String> combinations = new ArrayList();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current))
                    result.add(new String(current));
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }


        public List<String> generateParenthesis22(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left : generateParenthesis22(c))
                        for (String right : generateParenthesis22(n - 1 - c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }
    }
}
