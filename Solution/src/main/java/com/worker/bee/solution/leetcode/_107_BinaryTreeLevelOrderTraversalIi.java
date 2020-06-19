package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 107. Binary Tree Level Order Traversal II
 */
public class _107_BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
        Solution solution = new _107_BinaryTreeLevelOrderTraversalIi().new Solution();
    }
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> resultList = new ArrayList<>();

            return resultList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}