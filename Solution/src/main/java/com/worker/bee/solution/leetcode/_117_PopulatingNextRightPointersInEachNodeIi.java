package com.worker.bee.solution.leetcode;

/**
 * 题目标题:
 * 117. Populating Next Right Pointers in Each Node II
 */
public class _117_PopulatingNextRightPointersInEachNodeIi {

    public static void main(String[] args) {
        Solution solution = new _117_PopulatingNextRightPointersInEachNodeIi().new Solution();
    }
//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索


    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    class Solution {
        public Node connect(Node root) {
            Node current=root;
            while (root != null) {
                Node temp = new Node();
                Node end = temp;
                while (root != null) {
                    if (root.left != null) {
                        end.next = root.left;
                        end = end.next;
                    }
                    if (root.right != null) {
                        end.next = root.right;
                        end = end.next;
                    }
                    root = root.next;
                }
                root = temp.next;
            }
            return current;
        }
    }

    class SolutionSelf {
        public Node connect(Node root) {
            helper(root, null, null);
            return root;
        }

        public void helper(Node root, Node pre, Node nextStart) {
            if (root == null) {
                if (nextStart != null) {
                    helper(nextStart, null, null);
                }
                return;
            }
            if (root.left != null && root.right != null) {
                if (pre != null) {
                    pre.next = root.left;
                } else {
                    nextStart = root.left;
                }
                root.left.next = root.right;
                pre = root.right;
            } else if (root.left != null) {
                if (pre != null) {
                    pre.next = root.left;
                } else {
                    nextStart = root.left;
                }
                pre = root.left;
            } else if (root.right != null) {
                if (pre != null) {
                    pre.next = root.right;
                } else {
                    nextStart = root.right;
                }
                pre = root.right;
            }
            helper(root.next, pre, nextStart);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}