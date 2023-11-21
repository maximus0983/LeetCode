package leet.seanPrashadList;

import leet.TreeNode;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isTheSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isTheSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else if (root.val != subRoot.val) {
            return false;
        }
        return isTheSame(root.left, subRoot.left) && isTheSame(root.right, subRoot.right);
    }


}
