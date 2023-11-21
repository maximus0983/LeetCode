package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
    List<Levelnode> nodeList = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Levelnode> levelnodes = addToList(root,0);
        levelnodes.forEach(l -> System.out.println(l.node.val + " " + l.level));
        int pIndex = indexOf(levelnodes, p);
        int qIndex = indexOf(levelnodes, q);
        if (pIndex > qIndex) {
            int x = pIndex;
            pIndex = qIndex;
            qIndex = x;
        }
        List<Levelnode> levelnodes1 = levelnodes.subList(pIndex, qIndex);
        return searchMin(levelnodes1);
    }

    private TreeNode searchMin(List<Levelnode> levelnodes) {
        return levelnodes.stream()
                .min(Comparator.comparingInt(o -> o.level)).get().getNode();
    }

    private List<Levelnode> addToList(TreeNode node, int level) {
        if (node == null) {
            return Collections.emptyList();
        }
        ++level;
        nodeList.add(new Levelnode(node, level));
        List<Levelnode> left = addToList(node.left, level);
        if (!left.isEmpty()) {
            nodeList.add(new Levelnode(node, level));
        }
        List<Levelnode> right = addToList(node.right, level);
        if (!right.isEmpty()) {
            nodeList.add(new Levelnode(node, level));
        }
        return nodeList;
    }

    int indexOf(List<Levelnode> levelnodes, TreeNode node) {
        for (int i = 0; i < levelnodes.size(); i++) {
            if (levelnodes.get(i).node.val == node.val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode node = new LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(
                new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2,new TreeNode(7),new TreeNode(4))), new TreeNode(1,new TreeNode(0),new TreeNode(8))),
                new TreeNode(5), new TreeNode(4)
        );
        System.out.println(node.val);
    }
}

class Levelnode {
    TreeNode node;
    int level;

    public Levelnode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
