package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.bean.TreeNode;

/**
 * 题目标题:
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class _108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _108_ConvertSortedArrayToBinarySearchTree().new Solution();
    }
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return getSortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode getSortedArrayToBST(int[] nums, int startIndex, int endIndex) {
            if (startIndex > endIndex) {
                return null;
            }
            if (startIndex == endIndex) {
                return new TreeNode(nums[startIndex]);
            }
            //[-10,-3,0,5,9]
            int middle = (startIndex + endIndex) / 2;
            TreeNode treeNode = new TreeNode(nums[middle]);
            treeNode.left = getSortedArrayToBST(nums, startIndex, middle - 1);
            treeNode.right = getSortedArrayToBST(nums, middle + 1, endIndex);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}