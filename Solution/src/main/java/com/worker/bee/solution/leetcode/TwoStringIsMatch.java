package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

/**
 * 10. 正则表达式匹配
 * <p>
 * 题目描述：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class TwoStringIsMatch {
    @Test
    public void test() {
//        String s = "aab";
//        String p = "c*a*b";
        String s = "mississippi";
        String p = "mis*is*ip*.";
//        String s = "aaa";
//        String p = "aaaa";
//        String s = "aaa";
//        String p = ".*";
        PrintUtils.println(isMath(s, p));
    }

    //error
    private boolean isMath(String s, String p) {
//        if (s == null || s.length() == 0) {
//            return false;
//        }
//        if (p == null || p.length() == 0) {
//            return false;
//        }
//        int sSize = s.length();
//        int pSize = p.length();
//        int sIndex = 0;
//        int pIndex = 0;
//        char[] sChars = s.toCharArray();
//        char[] pChars = p.toCharArray();
//        char sTemp,  pTemp, pNextTemp;
//        while (sIndex < sSize) {
//            if (pIndex >= pSize) {
//                return false;
//            }
//            pTemp = pChars[pIndex];
//            sTemp = sChars[sIndex];
//            if (pIndex + 1 < pSize) {
//                pNextTemp = pChars[pIndex + 1];
//                if (pNextTemp == '*') {
//                    if (!(pTemp == '.' || pTemp == sTemp)) {
//                        pIndex++;
//                        pIndex++;
//                    } else {
//                        while (sIndex < sSize) {
//                            sTemp = sChars[sIndex];
//                            if (!(pTemp == '.' || pTemp == sTemp)) {
//                                pIndex++;
//                                pIndex++;
//                                break;
//                            } else {
//                                sIndex++;
//                            }
//                        }
//                    }
//                } else {
//                    if (!(pTemp == '.' || pTemp == sTemp)) {
//                        return false;
//                    }
//                    pIndex++;
//                    sIndex++;
//                }
//            } else {
//                //p的最后一位和s的对应位置相同，如果s不是最后以为则认为不匹配
//                if ((pTemp == '.' || pTemp == sTemp) && sIndex + 1 == sSize) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
//        while (pIndex < pSize) {
//            if (pIndex + 1 < pSize) {
//                pNextTemp = pChars[pIndex + 1];
//                if (pNextTemp == '*') {
//                    pIndex++;
//                    pIndex++;
//                } else {
//                    return false;
//                }
//            } else {
//                if (pChars[pIndex] != sChars[sSize - 1] && pChars[pIndex] != '.') {
//                    return false;
//                } else {
//                    if (pIndex + 1 == pSize) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
        return true;
    }
}
