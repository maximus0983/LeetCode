package leet;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrderTraverse(root);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST(root.left);
        list.add(root.val);
        isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinarySearchTree().isValidBST(
                new TreeNode(1, new TreeNode(1), new TreeNode(1))
        ));
    }
}
