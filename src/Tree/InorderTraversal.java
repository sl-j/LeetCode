package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }


     public static void main(String[] args) {

      }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res,root);
        return res;
    }
    static void inorder(List<Integer> res,TreeNode root){
          if(root == null) return;
          inorder(res,root.left);
          res.add(root.val);
          inorder(res, root.right);
      }
}
}
