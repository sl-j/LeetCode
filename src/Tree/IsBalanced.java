package Tree;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 */
public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 需要判断左子树和右子树的高度差是否在1以内，但是有可能在左右子树中有结点的高度差大于1
     * @param root
     * @return
     */
//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        return Math.abs(Depth(root.left) - Depth(root.right)) >= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int Depth(TreeNode root){
//        if(root == null) return 0;
//        return Math.max(Depth(root.left),Depth(root.right)) + 1;
//    }

    /**
     * 左右根的遍历方式，先遍历左子树，在遍历右子树，得到左右子树的高度，如果左右子树的高度差大于1，直接标记为-1，否则标记为正常高度
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return Depth(root) != -1;
    }
    public int Depth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = Depth(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = Depth(root.right);
        if(rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth,rightDepth) + 1 : -1;
    }

}
