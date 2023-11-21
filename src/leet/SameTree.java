package leet;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);
        if (p==null && q==null) {
            return true;
        } else if(p==null||q==null){
            return false;
        }

        while (!queueP.isEmpty()||!queueQ.isEmpty()) {
            TreeNode tempP = queueP.poll();
            TreeNode tempQ = queueQ.poll();
            if (tempQ == null|| tempP == null || tempP.val != tempQ.val) {
                return false;
            }
            System.out.println(tempP.val);
            if (tempP.left != null||tempQ.left!=null) {
                if (tempP.left == null||tempQ.left == null || tempP.left.val != tempQ.left.val) {
                    return false;
                }
                queueP.add(tempP.left);
                queueQ.add(tempQ.left);
            }
            if (tempP.right != null||tempQ.right!=null) {
                if (tempP.right==null||tempQ.right == null || tempP.right.val != tempQ.right.val) {
                    return false;
                }
                queueP.add(tempP.right);
                queueQ.add(tempQ.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(
                new TreeNode(1,null,new TreeNode(3)),
                new TreeNode(1, null, new TreeNode(3))
        ));
    }
}
