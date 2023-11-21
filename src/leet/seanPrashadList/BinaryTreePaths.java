package leet.seanPrashadList;

import leet.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> list = new ArrayList<>();
    static String path = "";

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            String prevPath = path;
            path = path + (path.equals("")? "":"->") + root.val;
            list.add(path);
            path = prevPath;
            return list;
        }
        String prev = path;
        path = path + (path.equals("")? "":"->") + root.val;
        if (root.left != null) {
            binaryTreePaths(root.left);
        }
        if (root.right != null) {
            binaryTreePaths(root.right);
        }
        path = prev;
        return list;
    }

    public static void main(String[] args) {
//        List<String> list1 = new BinaryTreePaths().binaryTreePaths(
////                new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))
//            new TreeNode(1,null,new TreeNode(4,new TreeNode(3,new TreeNode(2),null),new TreeNode(5,null,new TreeNode(6))))
//        );
//        list1.forEach(System.out::println);
        path = "1->2->3";
        int cut = path.length() < 1 ? 1 : 3;
        path = path.substring(0, path.length() - cut);
        System.out.println(path);
    }
}
