package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

/**
 * 题目标题:
 * 104. Maximum Depth of Binary Tree
 */
public class _104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new _104_MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode secondLeft = new TreeNode(1);
        secondLeft.left = new TreeNode(0);
        secondLeft.right = new TreeNode(2);
        secondLeft.right.right = new TreeNode(3);
        root.left = secondLeft;
        TreeNode secondRight = new TreeNode(5);
        root.right = secondRight;
        secondRight.left = new TreeNode(4);
        secondRight.right = new TreeNode(6);
        PrintUtils.println(solution.maxDepth(root));
    }
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索


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
        public int maxDepth(TreeNode root) {
            return helper(root, 1);
        }

        public int helper(TreeNode root, int currentLevel) {
            if (root == null) {
                return currentLevel - 1;
            }
            int left = helper(root.left, currentLevel + 1);
            int right = helper(root.right, currentLevel + 1);
            return Math.max(right, left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}