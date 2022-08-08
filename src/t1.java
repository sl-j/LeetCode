import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class t1 {
    public static class TreeNode {
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


      @Test
      public void test(){


//              firstMissingPositive(new int[]{3, 4, -1, 1});

      }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            boolean validBST = isValidBST(root);
        }



          public int firstMissingPositive(int[] nums) {
//        int min;
//        for(int i = 0;i < nums.length; i++){
//            if(nums[i] > 0 && nums[i] <= nums.length &&  nums[nums[i] - 1] != nums[i]) swap(nums,nums[i] - 1,i);
//        }
//
//        int ans = 0;
//        while(ans < nums.length && nums[ans] == ans + 1){
//            ans++;
//        }
//
//        return ans + 1;

              int n = nums.length;
              for (int i = 0; i < n; ++i) {
                  while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                      int temp = nums[nums[i] - 1];
                      nums[nums[i] - 1] = nums[i];
                      nums[i] = temp;
                  }
              }
              for (int i = 0; i < n; ++i) {
                  if (nums[i] != i + 1) {
                      return i + 1;
                  }
              }
              return n + 1;

          }


          public void swap(int[] nums, int i, int j) {
              int tmp = nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
          }

    public static int sumNumbers(TreeNode root) {
              if (root == null) return 0;
              Deque<TreeNode> nodeQeque = new LinkedList<TreeNode>();

              Deque<Integer> numQeque = new LinkedList<Integer>();

              nodeQeque.offer(root);
              numQeque.offer(root.val);
              int ans = 0;
              while (!nodeQeque.isEmpty()) {
                  int size = nodeQeque.size();
                  for (int i = 0; i < size; i++) {
                      TreeNode node = nodeQeque.poll();
                      TreeNode left = node.left;
                      TreeNode right = node.right;
                      int num = numQeque.poll();
                      if (left == null && right == null) {
                          ans += num;
                      } else if (left != null) {
                          numQeque.offer(num * 10 + left.val);
                          nodeQeque.offer(left);
                      } else if (right != null) {
                          numQeque.offer(num * 10 + right.val);
                          nodeQeque.offer(right);
                      }
                  }
              }

              return ans;

          }

    public static boolean isValidBST(TreeNode root) {
            Deque<TreeNode> qeque = new LinkedList<>();

            qeque.push(root);
            long pre = Long.MIN_VALUE;
            while(!qeque.isEmpty() || root != null){
                while(root.left != null){
                    root = root.left;
                    qeque.push(root);
                }
                root = qeque.pop();

                if(root.val <= pre ) return false;

                pre = root.val;
                root = root.right;
            }

            return true;
        }



    }


}

