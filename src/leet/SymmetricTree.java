package leet;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queueL = new LinkedList<>();
        Queue<TreeNode> queueR = new LinkedList<>();
        queueL.add(root.left);
        queueR.add(root.right);
        if (root.left == null && root.right == null) {
            return true;
        }
        while (!queueL.isEmpty()) {
            TreeNode node = queueL.poll();
            TreeNode node1 = queueR.poll();
            if (node != null && node1 != null && node.val == node1.val) {
                if (node.left != null && node1.right != null) {
                    if (node.left.val != node1.right.val) {
                        return false;
                    }
                    queueL.add(node.left);
                    queueR.add(node1.right);
                }
                if (node.right != null && node1.left != null) {
                    if (node.right.val != node1.left.val) {
                        return false;
                    }
                    queueR.add(node1.left);
                    queueL.add(node.right);
                }
                if (node.left == null && node1.right != null ||
                        node.right == null && node1.left != null ||
                        node.left != null && node1.right == null ||
                        node.right != null && node1.left == null) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new SymmetricTree().isSymmetric(
//                new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null))
//        ));
//        System.out.println(new SymmetricTree().isSymmetric(
//                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(3)), new TreeNode(2, new TreeNode(3), new TreeNode(4)))
//        ));
//        System.out.println(new SymmetricTree().isSymmetric(
//                new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))
//        ));
        System.out.println(new SymmetricTree().isSymmetric(
                new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(4), new TreeNode(5)))
        ));
    }
}
