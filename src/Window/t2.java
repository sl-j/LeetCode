package Window;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class t2 {

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

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(4);
        pathSum(root, 22);
    }


    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> tmp = new ArrayList<>();

        recur(root,targetSum,tmp);
        return ans;

    }

    public void recur(TreeNode root,int num,List<Integer> tmp){
        if(root == null && num == 0) ans.add(new ArrayList<Integer>(tmp));
        tmp.add(root.val);
        if(root == null || root.val > num) return;

        if(num > root.left.val) recur(root.left,num - root.val,tmp);
        if(num > root.right.val) recur(root.right,num - root.val,tmp);
        tmp.remove(tmp.size() - 1);
    }
}
