import java.util.Scanner;

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
class BST{
    TreeNode insertNode(TreeNode root, int val){
        if(root==null)
        return new TreeNode(val);
        if(root.val<=val)
        root.right = insertNode(root.right, val);
        else if(root.val>val)
        root.left = insertNode(root.left, val);
        return root;
    }
    boolean mirror_check(TreeNode root){
        if(root==null)
            return true;
        return (mirror_check(root.left) && mirror_check(root.right) && (root.left.val==root.right.val));
    }
    boolean target_sum_check(TreeNode root,int target_sum){
        if(root==null)
            return false;
        if(root.left == null && root.right == null)
            return target_sum-root.val == 0;
        return target_sum_check(root.left, target_sum-root.val) || target_sum_check(root.right, target_sum-root.val);
    }
    void preorder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
public class target_sum_BST {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BST bt = new BST();
        TreeNode root = null;
        while(true){
            int val = sc.nextInt();
            if(val==-1) break;
            root = bt.insertNode(root,val);
        }
        int target_sum = sc.nextInt();
        System.out.println(bt.target_sum_check(root,target_sum)?"Target sum found":"Target sum not found");
        sc.close();
    }
}
