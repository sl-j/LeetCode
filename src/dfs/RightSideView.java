package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode() {
          }

          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }


          /**
           * 广度优先遍历，将这一层的最后一个值加入结果集中就可以
           * @param root
           * @return
           */
//          public List<Integer> rightSideView(TreeNode root) {
//              if (root == null) return new ArrayList<>();
//
//              List<Integer> ans = new ArrayList<>();
//              Queue<TreeNode> queue = new LinkedList<>();
//              queue.offer(root);
//              while (!queue.isEmpty()) {
//                  int size = queue.size();
//                  for (int i = 0; i < size; i++) {
//                      TreeNode tmp = queue.poll();
//                      if (tmp.left != null) queue.offer(tmp.left);
//                      if (tmp.right != null) queue.offer(tmp.right);
//                      if (i == size - 1) ans.add(tmp.val);
//                  }
//              }
//              return ans;
//          }

          public List<Integer> rightSideView(TreeNode root) {
              if(root == null) return new ArrayList<>();

              List<Integer> ans = new ArrayList<>();
              Queue<TreeNode> queue = new LinkedList<>();
              queue.offer(root);
              while(!queue.isEmpty()){
                  int size = queue.size();
                  for(int i = 0;i < size;i++){
                      TreeNode tmp = queue.poll();
                      if(tmp.left != null) queue.offer(tmp.left);
                      if(tmp.right != null) queue.offer(tmp.right);
                      if(i == size - 1) ans.add(tmp.val);
                  }
              }

              return ans;

          }
      }
}
