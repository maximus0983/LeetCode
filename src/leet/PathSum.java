package leet;

public class PathSum {
    boolean res;
    int sum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            if (targetSum == sum) {
                res = true;
            }
            return false;
        }


        sum = sum + root.val;
        hasPathSum(root.left, targetSum);
        hasPathSum(root.right, targetSum);
        sum = sum - root.val;
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new PathSum().hasPathSum(
//                new TreeNode(5,
//                        new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
//                        new TreeNode(8, new TreeNode(13), new TreeNode(4))), 22
//        ));
        System.out.println(new PathSum().hasPathSum(
                        new TreeNode(1, new TreeNode(2), null)
                , 1
        ));
    }
}
