package leet.seanPrashadList;

import leet.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 != null && root1 != root2) {
            root1.val = root1.val + root2.val;
        } else if (root1 == null) {
            root1 = root2;
        }
        root1.left = mergeTrees(root1.left, root2 != null ? root2.left : null);
        root1.right = mergeTrees(root1.right, root2 != null ? root2.right : null);
        return root1;
    }
}