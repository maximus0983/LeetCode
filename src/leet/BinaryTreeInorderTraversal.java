package leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                if (!stack.empty()) {
                    node = stack.pop();
                    result.add(node.val);
                    stack.push(node.right);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal1(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))
        ));
    }
}

