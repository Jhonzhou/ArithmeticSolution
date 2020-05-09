package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.reflect.generics.tree.Tree;

/**
 * 题目标题:
 * 102. Binary Tree Level Order Traversal
 */
public class _102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new _102_BinaryTreeLevelOrderTraversal().new Solution();
    }
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> resultList = new ArrayList<>();
            List<TreeNode> tempNode = new ArrayList<>();
            tempNode.add(root);
            add(tempNode, resultList);
            return resultList;
        }

        public void add(List<TreeNode> nodeList, List<List<Integer>> resultList) {
            if (nodeList == null || nodeList.isEmpty()) {
                return;
            }
            ArrayList<Integer> tempList = new ArrayList<>();
            ArrayList<TreeNode> tempNodeList = new ArrayList<>();
            for (TreeNode treeNode : nodeList) {
                tempList.add(treeNode.val);
                if (treeNode.left != null) {
                    tempNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempNodeList.add(treeNode.right);
                }
            }
            resultList.add(tempList);
            add(tempNodeList, resultList);
        }
    }

    /**
     * 递归方法
     */
    class SolutionServer {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        public void helper(TreeNode node, int level) {
            // start the current level
            if (levels.size() == level)
                levels.add(new ArrayList<Integer>());

            // fulfil the current level
            levels.get(level).add(node.val);

            // process child nodes for the next level
            if (node.left != null)
                helper(node.left, level + 1);
            if (node.right != null)
                helper(node.right, level + 1);
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return levels;
            helper(root, 0);
            return levels;
        }
    }

    /**
     * 迭代方法
     */
    class SolutionServer1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null) return levels;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                // start the current level
                levels.add(new ArrayList<Integer>());

                // number of elements in the current level
                int level_length = queue.size();
                for (int i = 0; i < level_length; ++i) {
                    TreeNode node = queue.remove();

                    // fulfill the current level
                    levels.get(level).add(node.val);

                    // add child nodes of the current level
                    // in the queue for the next level
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                // go to next level
                level++;
            }
            return levels;
        }
    }


}