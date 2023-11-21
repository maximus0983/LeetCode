package leet;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        TreeNode node = buildRecursive(postorder, 0, postorder.length - 1);
        return node;
    }

    private TreeNode buildRecursive(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = postorder[postIndex--];
        TreeNode node = new TreeNode(rootValue);
        node.right = buildRecursive(postorder, map.get(rootValue) + 1, right);
        node.left = buildRecursive(postorder, left,map.get(rootValue) -1);
        return node;
    }

    public static void main(String[] args) {
        new ConstructBinaryTreefromInorderandPostorderTraversal()
                .buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
