package leet.seanPrashadList;

import leet.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left=Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = minDepth(root.right);}
            return Math.min(left, right);
        }

        public static void main (String[]args){
            new MinimumDepthofBinaryTree().minDepth(
                    new TreeNode(1)
            );
        }
    }
