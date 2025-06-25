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
    TreeNode root=null;
    while(true){
      int val = sc.nextInt();
      if(val==-1) break;
      root = bt.insertNode(root,val);
    }
    bt.preorder(root);
    sc.close();
  }
}