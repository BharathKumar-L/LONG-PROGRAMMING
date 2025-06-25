import java.util.*;

class TreeNode {
    int val;
    TreeNode left;  
    TreeNode right; 

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class bt_insertion {
    static TreeNode root;
    public static void insert(int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            }

            queue.offer(current.left);

            TreeNode sibling = current.left.right;
            if (sibling == null) {
                current.left.right = newNode;
                return;
            }

            queue.offer(sibling);
        }
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;

        int childHeight = height(node.left);
        int siblingHeight = height(node.right);

        return Math.max(childHeight + 1, siblingHeight);
    }

    public void printLCRS(TreeNode node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.val);
        printLCRS(node.left, indent + "  ");
        printLCRS(node.right, indent);
    }

    public static void main(String[] args) {
        
        bt_insertion bInsertion =  new bt_insertion();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            bt_insertion.insert(sc.nextInt());
        System.out.println("Tree Structure:");
        bInsertion.printLCRS(bt_insertion.root, "");

        System.out.println("Height of the tree: " + bInsertion.height(bt_insertion.root));
        sc.close();
    }
}
