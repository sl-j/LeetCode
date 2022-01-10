package DC;

public class VerifyPostorder {

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{5,4,3,2,1}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length - 1);
    }

    public static boolean recur(int[] postorder,int left,int right){//right就是根节点
        if(left >= right) return true;
        int p = left;
        while (postorder[p] < postorder[right]) p++;//从左往右寻找小于根节点的值
        int q = p;
        while (postorder[p] > postorder[right]) p++;//小节点结束后，指向的当前节点一定是大于根节点的值（符合题目要求的话）
        if(p != right) return false;//如果符合题目要求的话，遍历到最后，一定是达到根节点
        return recur(postorder,left,q - 1) && recur(postorder,q, right - 1);

    }
}
