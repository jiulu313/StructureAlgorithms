package com.zh.sf;


import com.zh.bean.TreeNode;

public class LeetCode {

    //二叉树最小的深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            int leftH = 1 + minDepth(root.left);
            min = leftH < min ? leftH : min;
        }

        if (root.right != null) {
            int rightH = 1 + minDepth(root.right);
            min = rightH < min ? rightH : min;
        }

        return min;
    }

    //将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        return createNode(nums, i, j);
    }

    private static TreeNode createNode(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createNode(nums, i, mid - 1);
        root.right = createNode(nums, mid + 1, j);

        return root;
    }

}
