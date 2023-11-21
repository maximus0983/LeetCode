package leet.seanPrashadList;

import leet.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avrList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                sum += node.val;
            }
            avrList.add(sum / level);
        }
        return avrList;
    }

    public static void main(String[] args) {
        new AverageofLevelsinBinaryTree().averageOfLevels(
            new TreeNode(1,new TreeNode(8),new TreeNode(4))
        );
    }
}
