import java.util.*;
import java.io.*;

class Main{
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        TreeNode root = build(split);
        System.out.println();
    }


    private static TreeNode build(String[] split){
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = null;

        for(int i = 0;i < split.length;i++){
            TreeNode cur = null;
            if(!split[i].equals("null")){
                cur = new TreeNode(Integer.parseInt(split[i]));
            }
            if(root == null) root = cur;
            list.add(i,cur);
        }

        for(int i = 0;2 * i + 2 < list.size();i++){
            if(list.get(i) != null){
                list.get(i).left = list.get(2 * i + 1);
                list.get(i).right = list.get(2 * i + 2);
            }
        }

        return root;
    }

}