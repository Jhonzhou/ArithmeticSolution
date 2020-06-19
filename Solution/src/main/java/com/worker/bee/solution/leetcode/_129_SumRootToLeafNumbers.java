package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目标题:
 * 129. Sum Root to Leaf Numbers
 */
public class _129_SumRootToLeafNumbers {

    public static void main(String[] args) {
        Solution solution = new _129_SumRootToLeafNumbers().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        PrintUtils.println(solution.sumNumbers(root));
    }
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.
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

        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode root, int preResult) {
            if (root == null) {
                return 0;
            }
            preResult = root.val + preResult * 10;
            if (root.left == null && root.right == null) {
                return preResult;
            }
            return helper(root.left, preResult) + helper(root.right, preResult);
        }

        public int sumNumbersQueue(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left == null && poll.right == null) {
                        result += poll.val;
                        continue;
                    }
                    if (poll.left != null) {
                        poll.left.val = poll.val * 10 + poll.left.val;
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        poll.right.val = poll.val * 10 + poll.right.val;
                        queue.offer(poll.right);
                    }
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}