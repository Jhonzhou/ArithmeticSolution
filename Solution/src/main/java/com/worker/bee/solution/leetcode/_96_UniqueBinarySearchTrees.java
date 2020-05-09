package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

/**
 * 题目标题:
 * 96. Unique Binary Search Trees
 */
public class _96_UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new _96_UniqueBinarySearchTrees().new Solution();
        PrintUtils.println(solution.numTrees(4));
    }
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            /**
             * 解决方法
             * 1、类比96那样，找出所有二叉搜索树集合
             * 2、利用数据算法找出结果
             */

            int[] tempArray = new int[n + 1];
            tempArray[0] = 1;
            tempArray[1] = 1;
            //G(n)=G(0)*G(1)+G(1)*G(2)+G(2)*G(3)+G(3)*G(4)....G(n-2)*G(n-1)
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    tempArray[i] += tempArray[j - 1] * tempArray[i - j];
                }
            }
            return tempArray[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}