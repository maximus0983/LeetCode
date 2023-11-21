package leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));
        serTree(root, list);
        int lastNullIndex = list.size() - 1;
        while (list.get(lastNullIndex) == null) {
            lastNullIndex--;

        }
        return list.subList(0,lastNullIndex+1).toString();
    }

    private TreeNode serTree(TreeNode root, List<String> list) {
        if (root == null) {
            return null;
        }
        list.add(root.left == null ? null : String.valueOf(root.left.val));
        list.add(root.right == null ? null : String.valueOf(root.right.val));
        serTree(root.left, list);
        serTree(root.right, list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String substring = data.substring(1, data.length() - 1);
        String[] split = substring.split(", ");
        Queue<TreeNode> queue = Stream.of(split).map(s -> s.equals("null") ? null : new TreeNode(Integer.parseInt(s))).collect(Collectors.toCollection(LinkedList::new));
        TreeNode root = queue.poll();

        buildTree(root, queue);

        return root;
    }

    private TreeNode buildTree(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return null;
        }
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();
        root.left = left;
        root.right = right;
        buildTree(left, queue);
        buildTree(right, queue);
        return root;
    }

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree ser = new SerializeandDeserializeBinaryTree();
        String serialize = ser.serialize(
                null
//                new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))
//                new TreeNode(1, null, new TreeNode(2))
        );
        System.out.println(serialize);
        TreeNode deserialize = ser.deserialize(serialize);
    }
}
