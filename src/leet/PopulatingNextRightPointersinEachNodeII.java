package leet;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }
        queue.add(root);
        root.next = null;
        Node next;
        int levelQuantity = 1;
        int levelQuantityCounter = 0;
        int levelNodePosition = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                levelQuantityCounter++;
            }
            if (node.right != null) {
                queue.add(node.right);
                levelQuantityCounter++;
            }

            if (levelNodePosition++ >= levelQuantity) {
                next = null;
                levelQuantity = levelQuantityCounter;
                levelNodePosition = 1;
                levelQuantityCounter = 0;
            } else {
                next = queue.peek();
            }
            node.next = next;
        }
        return root;
    }

    public static void main(String[] args) {
        Node thirteen = new Node(13);
        Node twelve = new Node(12);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node nine = new Node(9);
        Node eight = new Node(8);
        Node seven = new Node(7);
        Node six = new Node(6);
        Node five = new Node(5, twelve, null);
        Node four = new Node(4, ten, eleven);
        Node three = new Node(3, eight, nine);
        Node two = new Node(2, six, seven);
        Node one = new Node(1, four, five);
        Node zero = new Node(0, two, three);
        Node min = new Node(-1, zero, one);
        new PopulatingNextRightPointersinEachNodeII()
                .connect(min);
//                .connect(
//                new Node(1, new Node(2, new Node(4), new Node(5), null),
//                        new Node(3, new Node(6), new Node(7), null), null)
//        );
    }
}
