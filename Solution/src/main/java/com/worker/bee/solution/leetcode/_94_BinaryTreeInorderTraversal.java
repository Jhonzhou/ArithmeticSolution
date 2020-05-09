package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * 题目标题:
 * 94. Binary Tree Inorder Traversal
 */
public class _94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        Solution solution = new _94_BinaryTreeInorderTraversal().new Solution();
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        first.right = second;
        second.left = third;
        PrintUtils.printList(solution.inorderTraversal(first));
    }
//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 递归方式
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> resultList = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            TreeNode current = root;
            while (current != null || !tempStack.empty()) {
                while (current != null) {
                    tempStack.push(current);
                    current = current.left;
                }
                current = tempStack.pop();
                resultList.add(current.val);
                current = current.right;
            }

            return resultList;
        }

        public List<Integer> inorderTraversalOld(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> resultList = new ArrayList<>();
            printLeft(root, resultList);
            return resultList;
        }

        /**
         * 递归输出 二叉树的中序遍历
         */
        private void printLeft(TreeNode root, List<Integer> resultList) {
            if (resultList == null) {
                resultList = new ArrayList<>();
            }
            if (root == null) {
                return;
            }
            if (root.left != null) {
                printLeft(root.left, resultList);
            }
            resultList.add(root.val);
            if (root.right != null) {
                printLeft(root.right, resultList);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}