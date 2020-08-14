package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 20. 有效的括号
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 * Related Topics 栈 字符串
 */
public class _20_BracketIsValid {
    @Test
    public void test() {
//        String s = "([]";
        String s = "([)]";
//        String s = "(]";
//        String s = "(([]){})";
//        String s = "()[]{}";
//        String s = "{[]}";
        PrintUtils.println(isValid(s));
    }

    private boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        if (!isStart(chars[0]) || isStart(chars[chars.length - 1])) {
            return false;
        }
        ArrayList<Character> characters = new ArrayList<>();
        for (int index = 0; index < chars.length; index++) {
            char temp = chars[index];
            if (isStart(temp)) {
                characters.add(temp);
            } else {
                if (characters.size() <= 0) {
                    return false;
                }
                Character pre = characters.remove(characters.size() - 1);
                if (pre == null || !isMatch(pre, temp)) {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    private boolean isStart(char pre) {
        return pre == '(' || pre == '[' || pre == '{';
    }

    private boolean isMatch(char pre, char end) {
        if (pre == '(') {
            return end == ')';
        }
        if (pre == '[') {
            return end == ']';
        }
        if (pre == '{') {
            return end == '}';
        }
        return false;
    }
}
