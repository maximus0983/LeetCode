package leet;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = buildTree(new TreeNode(), nums, 0, nums.length - 1);
        return node;
    }

    private TreeNode buildTree(TreeNode node, int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        node.val = nums[mid];
        node.left = buildTree(new TreeNode(), nums, left, mid-1);
        node.right = buildTree(new TreeNode(), nums, mid+1, right);
        return node;
    }

    public static void main(String[] args) {
        new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(
                new int[]{1, 2, 3, 4}
        );
    }
}
