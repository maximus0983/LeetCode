package leet.seanPrashadList;

import leet.TreeNode;

import java.util.*;

public class main {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
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
                sum = sum + node.val;
            }
            res.add(sum / level);
        }
        return res;
    }

    int count = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode no = qu.poll();
                if (no.left == null && no.right == null) return depth;
                if (no.left != null) qu.add(no.left);
                if (no.right != null) qu.add(no.right);
            }
            depth = depth + 1;
        }
        return depth;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum == targetSum;
        }
        return helper(root.left, targetSum, root.val + sum) || helper(root.right, targetSum, root.val + sum);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = root.left != null && root.right != null ? 1 : 0;
        int left = diameterOfBinaryTree(root.left) + i;
        int right = diameterOfBinaryTree(root.right) + i;
        return Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helpLowest(root, p, q);
        return res;
    }

    private boolean helpLowest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean l = helpLowest(root.left, p, q) || root == p;
        boolean r = helpLowest(root.right, p, q) || root == q;
        if (l && r) {
            res = root;
        }
        return l || r;
    }

    boolean resul;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            resul = isSameTree(root, subRoot);
            return resul;
        }
        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }

    public boolean backspaceCompare(String s, String t) {
        return modifyString(s).equals(modifyString(t));
    }

    private String modifyString(String t) {
        StringBuilder sb = new StringBuilder(t);
        int counrResh = 0;
        for (int i = t.length() - 1; i > -1; i--) {
            char c = t.charAt(i);
            if (c == '#') {
                counrResh++;
                sb.deleteCharAt(i);
            } else if (counrResh > 0) {
                counrResh--;
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    private int houseRobber(int[] num, int first, int[] dp) {
        if (first > num.length - 1) {
            return 0;
        }
        if (dp[first] > 0) {
            return dp[first];
        }
        dp[first] = Math.max(num[first] + houseRobber(num, first + 2, dp), houseRobber(num, first + 1, dp));
        return dp[first];
    }

    public static void generatePrefixes(int[] arr, int start, String prefix) {
        if (start == arr.length) { // если дошли до конца массива, выводим текущий префикс и выходим из рекурсии
            System.out.print(prefix + " ");
            return;
        }
        generatePrefixes(arr, start + 1, prefix + arr[start]); // добавляем текущий элемент и переходим к следующему
        generatePrefixes(arr, start + 1, prefix); // не добавляем текущий элемент и переходим к следующему
    }

    public static void generateSubarrays(int[] nums, int start, List<Integer> subarray, List<List<Integer>> result) {
        if (start > nums.length-1) { // если начальный индекс больше конечного, выходим из рекурсии
            return;
        }
        if (!subarray.isEmpty()) { // если построенный подмассив не является пустым, добавляем его в результат
            result.add(new ArrayList<>(subarray));
        }
        generateSubarrays(nums, start + 1, subarray, result); // не добавляем текущий элемент и переходим к следующему
        subarray.add(nums[start]); // добавляем текущий элемент и рекурсивно генерируем следующий подмассив с текущим элементом
        generateSubarrays(nums, start + 1, subarray, result);
        subarray.remove(subarray.size() - 1); // удаляем текущий элемент перед выходом из рекурсии
    }

    List<List<Integer>> fff(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcd";
        s.toLowerCase();
        System.out.println(s.indexOf("abw"));
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i)-'a');
//        }
//        int[] dp = new int[]{-1, -1, -1, -1, -1, -1, -1};
//        Arrays.fill(dp, -1);
//        System.out.println(new main()
////                .minDepth(
////                new TreeNode(1, new TreeNode(8), new TreeNode(4)))
////                        .isSubtree(new TreeNode(3,new TreeNode(4, new TreeNode(1),new TreeNode(2)),new TreeNode(5)),
////                                                      new TreeNode(4, new TreeNode(1),new TreeNode(2)))
////                        .backspaceCompare("xywrrmp","xywrrmu#p")
////                .houseRobber(new int[]{1, 1, 9, 10, 9, 1, 1}, 0, dp)
////                        .fff(new int[]{1,2,3})
//                );
////        generatePrefixes(new int[]{1, 2, 3}, 0, "");
//        generateSubarrays(new int[]{1,2,3},0,new ArrayList<>(), new ArrayList<>());
    }
}
