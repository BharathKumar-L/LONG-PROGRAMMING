import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BT {
    TreeNode root;
    void insert(int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }
    void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    public static void main(String[] args) {
        BT bt = new BT();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++)
            bt.insert(sc.nextInt());
        System.out.print("In-order Traversal: ");
        bt.inOrder(bt.root);
        sc.close();
    }
}
