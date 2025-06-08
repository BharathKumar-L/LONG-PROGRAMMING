import java.util.*;
class TreeNode {
  int val;
  TreeNode left,right;
  TreeNode(int val){
    this.val = val;
    this.right = null;
    this.left = null;
  }
}
class BinaryST{
  TreeNode root;
  TreeNode insertNode(TreeNode root, int val){
    if(root==null)
      return new TreeNode(val);
    if(root.val<=val)
      root.right = insertNode(root.right, val);
    else if(root.val>val)
      root.left = insertNode(root.left, val);
    return root;
  }
  void preorder(TreeNode root){
    if(root==null)
      return ;
    System.out.print(root.val+" ");
    preorder(root.left);
    preorder(root.right);
  }

}
class BST{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    BinaryST bt = new BinaryST();
    while(true){
      int val = sc.nextInt();
      if(val==-1) break;
      bt.root = bt.insertNode(bt.root,val);
    }
    bt.preorder(bt.root);
    sc.close();
  }
}