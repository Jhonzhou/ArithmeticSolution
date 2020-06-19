package com.worker.bee.solution.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: JhonZhou
 * @date: 2020/4/27
 * @Description:
 */
public class TreeNode {

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    @Override
    public TreeNode clone() {
        TreeNode current = new TreeNode(val);
        if (left != null) {
            current.left = left.clone();
        }
        if (right != null) {
            current.right = right.clone();
        }
        return current;
    }

    public static List<String> beforePrintTreeNode(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        beforeRecursive(root, resultList);
        return resultList;
    }

    private static void beforeRecursive(TreeNode root, List<String> resultList) {
        if (root==null){
            return;
        }
        resultList.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            beforeRecursive(root.left, resultList);
        } else {
            resultList.add("null");
        }
        if (root.right != null) {
            beforeRecursive(root.right, resultList);
        } else {
            resultList.add("null");
        }
    }
}
