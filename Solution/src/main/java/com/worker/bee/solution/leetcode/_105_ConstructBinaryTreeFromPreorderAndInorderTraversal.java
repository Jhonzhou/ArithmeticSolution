package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.Arrays;

/**
 * 题目标题:
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        SolutionServer solution = new _105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new SolutionServer();
        int[] preOrder = new int[]{1, 2};
        int[] inOrder = {2, 1};
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        PrintUtils.println(TreeNode.beforePrintTreeNode(treeNode));
    }
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length <= 0) {
                return null;
            }
            if (preorder.length != inorder.length) {
                return null;
            }
            TreeNode treeNode = new TreeNode(preorder[0]);

            int endIndex = 0;
            for (int inIndex = 0; inIndex < inorder.length; inIndex++) {
                if (inorder[inIndex] == treeNode.val) {
                    endIndex = inIndex;
                    break;
                }
            }
            treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, endIndex + 1), Arrays.copyOfRange(inorder, 0, endIndex));
            treeNode.right = buildTree(Arrays.copyOfRange(preorder, endIndex + 1, preorder.length), Arrays.copyOfRange(inorder, endIndex + 1, inorder.length));
            return treeNode;
        }
    }
    class SolutionServer extends Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }
            return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
            //递归的第一步：递归终止条件，避免死循环
            if (pStart > pEnd || iStart > iEnd) {
                return null;
            }
            //重建根节点
            TreeNode treeNode = new TreeNode(preorder[pStart]);
            int index = 0;  //index找到根节点在中序遍历的位置
            while (inorder[iStart + index] != preorder[pStart]) {
                index++;
            }
            //重建左子树
            treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
            //重建右子树
            treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
            return treeNode;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}