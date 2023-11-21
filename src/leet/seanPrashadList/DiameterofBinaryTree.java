package leet.seanPrashadList;

import leet.TreeNode;

public class DiameterofBinaryTree {
    int answer = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        count(root);
        return answer;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        answer = Math.max(answer, left + right + 1);
        return Math.max(left, right) + 1;
    }


}
