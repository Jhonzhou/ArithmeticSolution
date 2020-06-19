package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 113. Path Sum II
 */
public class _113_PathSumIi {

    public static void main(String[] args) {
        Solution solution = new _113_PathSumIi().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        PrintUtils.printDoubleList(solution.pathSum(root, 22));
    }
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
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
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            pathSum(root, sum, new ArrayList<Integer>());
            return result;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> currentList) {
            if (root == null) {
                return;
            }
            int lastSum = sum - root.val;
            currentList.add(root.val);

            if (lastSum == 0 &&
                    root.left == null && root.right == null) {
                result.add(new ArrayList<>(currentList));
            }else {
                pathSum(root.left, lastSum, currentList);
                pathSum(root.right, lastSum, currentList);
            }

            currentList.remove(currentList.size()-1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}