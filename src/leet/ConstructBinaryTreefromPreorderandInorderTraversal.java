package leet;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        preIndex = 0;
        TreeNode node = buildRecursive(preorder, 0, preorder.length - 1);
        return node;
    }

    private TreeNode buildRecursive(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = postorder[preIndex++];
        TreeNode node = new TreeNode(rootValue);
        node.left = buildRecursive(postorder, left,map.get(rootValue) -1);
        node.right = buildRecursive(postorder, map.get(rootValue) + 1, right);
        return node;
    }

    public static void main(String[] args) {
        new ConstructBinaryTreefromInorderandPostorderTraversal()
                .buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
