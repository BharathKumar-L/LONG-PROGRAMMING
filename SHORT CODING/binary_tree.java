import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    static boolean mirror_check(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return (root1.val==root2.val) && mirror_check(root1.left,root2.left) && mirror_check(root1.right,root2.right);
    }
    static void preorder(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(TreeNode root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }
    static void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }
}
class buildTree{
    static Scanner sc = new Scanner(System.in);
    TreeNode build(){
        int val = sc.nextInt();
        if(val == -1)
            return null;
        TreeNode node = new TreeNode(val);
        
        System.out.println("Enter left child of "+val);
        node.left = build();
        System.out.println("Enter right child of "+val);
        node.right = build();

        return node;
    }
}
public class binary_tree {
    public static void main(String args[]){
        buildTree bt = new buildTree();
        TreeNode root = bt.build();
        System.out.println(BinaryTree.mirror_check(root,root));
    }
}
