package leet;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(queue.poll().val);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().levelOrder(
                new TreeNode(1, new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(5)))
        );
    }
}
