package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目标题:
 * 98. Validate Binary Search Tree
 */
public class _98_ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _98_ValidateBinarySearchTree().new Solution();
//        [3,1,5,0,2,4,6,null,null,null,3]


        //[10,5,15,null,null,6,20]
//    10
//   / \
//  5   15
// / \   / \
//      6  20
//        TreeNode root =
//        eeNode(20);

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

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        PrintUtils.println(solution.isValidBST(root));
    }
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public boolean isValidBST(TreeNode root) {
           return helper(root,null,null);
        }

        public boolean helper(TreeNode root, Integer higher, Integer lower) {
            if (root == null) {
                return true;
            }
            if (higher != null && root.val >= higher) {
                return false;
            }
            if (lower != null && root.val <= lower) {
                return false;
            }

            if (!helper(root.left, root.val, lower)) {
                return false;
            }
            if (!helper(root.right, higher, root.val)) {
                return false;
            }
            return true;
        }
    }

    class SolutionMiddle {
        /**
         * 二叉搜索树在中序遍历情况下结果为升序
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<Integer> result = new Stack<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while (root != null || !tempStack.isEmpty()) {
                while (root != null) {
                    tempStack.push(root);
                    root = root.left;
                }
                root = tempStack.pop();
                if (!result.isEmpty() && root.val <= result.peek()) {
                    return false;
                }
                result.push(root.val);
                root = root.right;
            }
            return true;
        }


    }

    class SolutionPerfect {
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 访问左子树
            if (!isValidBST(root.left)) {
                return false;
            }
            // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            // 访问右子树
            return isValidBST(root.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}