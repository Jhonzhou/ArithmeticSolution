package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.Stack;

/**
 * 题目标题:
 * 100. Same Tree
 */
public class _100_SameTree {

    public static void main(String[] args) {
        Solution solution = new _100_SameTree().new Solution();
        TreeNode p = new TreeNode(2);
        p.right = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(3);
        q.right = new TreeNode(4);
        PrintUtils.println(solution.isSameTree(p, q));
    }
//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p==null&&q==null){
                return true;
            }
            if (p==null||q==null){
                return false;
            }
            if (p.val!=q.val){
                return false;
            }
            return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}