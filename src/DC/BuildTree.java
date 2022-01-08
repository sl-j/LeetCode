package DC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class BuildTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(true);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return recur(preorder,0,0, inorder.length - 1,hashMap);

    }

    /**
     *
     * @param preorder 前序遍历
     * @param preRoot  前序遍历中根节点的位置
     * @param inLeft   中序遍历中的左边界
     * @param inRight  中序遍历中的右边界
     * @param map      记录中序每个数值位置的哈希表
     * @return
     */
    public static TreeNode recur(int[] preorder,int preRoot,int inLeft,int inRight,HashMap<Integer,Integer> map){
       if(inLeft > inRight) return null;
       int rootIndex = map.get(preorder[preRoot]);
       TreeNode root = new TreeNode(preorder[preRoot]);//构建根节点
        /**
         * 前序中根节点的位置 = 前序根节点的位置+1（和前面说的方法雷同）
         * 在构建左子树的过程中，左边界是不变的
         * 右边界 = 中序中根节点的位置-1
         */
       root.left = recur(preorder,preRoot + 1,inLeft,rootIndex - 1,map);
        /**
         * 前序中根根节点的位置 = 前序根节点的位置 + 左子树长度 + 1
         * 左子树的长度 = 根节点位置 - 中序左边界位置
         * 左边界 = 中序根节点位置 + 1
         * 在构建右子树的过程中，右边界不变
         */
       root.right = recur(preorder,preRoot + (rootIndex - inLeft) + 1,rootIndex + 1,inRight,map);
       return root;
    }

//    public static int findIndex(int rootValue, int[] inorder){
//        for (int i = 0; i < inorder.length; i++) {
//            if(inorder[i] == rootValue) return i;
//        }
//        return 0;
//    }

}
