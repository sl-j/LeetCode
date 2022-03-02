import org.junit.Test;

import java.util.*;

public class test {

      public class TreeNode {
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
  }

//    public List<Integer> ans = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//          if(root == null) return new ArrayList<>();
//          recur(root);
//          return ans;
//    }
//
//    public void recur(TreeNode root){
//        if(root == null) return;
//        recur(root.left);
//        ans.add(root.val);
//        recur(root.right);
//    }

        public List<Integer> inorderTraversal(TreeNode root) {
          if(root == null) return new ArrayList<>();
          List<Integer> ans = new ArrayList<>();
          Deque<TreeNode> stack = new LinkedList<>();

          while (root != null || !stack.isEmpty()){
              while (root != null){
                  stack.push(root);
                  root = root.left;
              }

              root = stack.pop();
              ans.add(root.val);
              root = root.right;
          }
          return ans;
    }

}
