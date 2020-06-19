package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目标题:
 * 95. Unique Binary Search Trees II
 * 二叉查找树（Binary Search Tree），
 * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树
 * ： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 */
public class _95_UniqueBinarySearchTreesIi {

    public static void main(String[] args) {
        Solution solution = new _95_UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        PrintUtils.println("*******************result size ：" + treeNodes.size());
        for (TreeNode treeNode : treeNodes) {
            PrintUtils.printList(TreeNode.beforePrintTreeNode(treeNode));
        }
        SolutionServer solutionServer = new _95_UniqueBinarySearchTreesIi().new SolutionServer();
       treeNodes = solutionServer.generateTrees(3);
        PrintUtils.println("*******************result size ：" + treeNodes.size());
        for (TreeNode treeNode : treeNodes) {
            PrintUtils.printList(TreeNode.beforePrintTreeNode(treeNode));
        }
    }
//二叉查找树（Binary Search Tree），
// （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树
// ： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
// 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
// 示例:
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
// Related Topics 树 动态规划


    class Solution {
        public LinkedList<TreeNode> generate_trees(int start, int end) {
            LinkedList<TreeNode> resultList = new LinkedList<TreeNode>();
            if (start > end) {
                resultList.add(null);
                return resultList;
            }
            for (int index = start; index <= end; index++) {
                LinkedList<TreeNode> leftNodes = generate_trees(start, index - 1);
                LinkedList<TreeNode> rightNodes = generate_trees(index+1, end);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode listNode = new TreeNode(index);
                        listNode.left = leftNode;
                        listNode.right = rightNode;
                        resultList.add(listNode);
                    }
                }


            }
            return resultList;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<>();
            }
            return generate_trees(1, n);
        }
    }

    class SolutionServer {
        public LinkedList<TreeNode> generate_trees(int start, int end) {
            LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
            if (start > end) {
                all_trees.add(null);
                return all_trees;
            }

            // pick up a root
            for (int i = start; i <= end; i++) {
                // all possible left subtrees if i is choosen to be a root
                LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

                // all possible right subtrees if i is choosen to be a root
                LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

                // connect left and right trees to the root i
                for (TreeNode l : left_trees) {
                    for (TreeNode r : right_trees) {
                        TreeNode current_tree = new TreeNode(i);
                        current_tree.left = l;
                        current_tree.right = r;
                        all_trees.add(current_tree);
                    }
                }
            }
            return all_trees;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generate_trees(1, n);
        }
    }


}