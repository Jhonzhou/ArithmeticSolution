package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目标题:
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new _103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 迭代
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> resultList = new ArrayList<>();
            Queue<TreeNode> tempNodeQueue = new LinkedList<>();
            tempNodeQueue.add(root);
            while (!tempNodeQueue.isEmpty()) {
                int length = tempNodeQueue.size();
                ArrayList<Integer> tempList = new ArrayList<>();
                resultList.add(tempList);
                int currentLevel = resultList.size();
                for (int i = 0; i < length; i++) {
                    TreeNode remove = tempNodeQueue.remove();
                    if (currentLevel % 2 == 0) {
                        tempList.add(0, remove.val);
                    } else {
                        tempList.add(remove.val);
                    }
                    if (remove.left != null) {
                        tempNodeQueue.add(remove.left);
                    }
                    if (remove.right != null) {
                        tempNodeQueue.add(remove.right);
                    }
                }
            }
            return resultList;
        }
    }

    /**
     * 递归
     */
    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> resultList = new ArrayList<>();
            help(root, 0, resultList);
            return resultList;
        }

        public void help(TreeNode root, int level, List<List<Integer>> resultList) {
            if (root == null) {
                return;
            }
            if (resultList.size() == level) {
                resultList.add(new ArrayList<Integer>());
            }
            if (level % 2 == 1) {
                resultList.get(level).add(root.val);
            } else {
                resultList.get(level).add(0, root.val);
            }
            help(root.right, level + 1, resultList);
            help(root.left, level + 1, resultList);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}