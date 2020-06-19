package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.Arrays;

/**
 * 题目标题:
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] preOrder = new int[]{9,3,15,20,7};
        int[] inOrder = {9,15,7,20,3};
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        PrintUtils.printList(TreeNode.beforePrintTreeNode(treeNode));
    }
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length==0||postorder.length==0){
                return null;
            }

            int currentIndex = 0;
            while (currentIndex < inorder.length) {
                if (inorder[currentIndex] == postorder[postorder.length - 1]) {
                    break;
                }
                currentIndex++;
            }

            TreeNode treeNode = new TreeNode(inorder[currentIndex]);
            treeNode.left = buildTree(Arrays.copyOfRange(inorder, 0, currentIndex), Arrays.copyOfRange(postorder, 0, currentIndex));
            treeNode.right = buildTree(Arrays.copyOfRange(inorder, currentIndex + 1, inorder.length), Arrays.copyOfRange(postorder, currentIndex, postorder.length - 1));
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}