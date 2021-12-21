package search;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class LevelOrder3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//先将root入队
//        int c = 0;
        while (queue.size() != 0){
//            c++;
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size();i > 0;i--) {//不可以用i++，因为size会随着出队不断变化，需要开始就将长度存储在变量中
               TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){queue.offer(node.left);};
                if(node.right != null){queue.offer(node.right);};//左右结点入队，但是队列长度存储在变量中，所以跳出for循环
            }
//            if(c%2 == 0){//此题为交替打印，第二层为右左，第三层为左右，交替进行，可得偶数层为右左，奇数层为左右
//                Collections.reverse(tmp); //偶数层，反转
//            }
            /**
             * 利用res的大小确定层数，从第0层开始
             */
            if(res.size()%2 == 1){//此题为交替打印，第二层为右左，第三层为左右，交替进行，可得偶数层为右左，奇数层为左右
                Collections.reverse(tmp); //偶数层，反转
            }
            res.add(tmp);
        }
        return res;

    }
}
