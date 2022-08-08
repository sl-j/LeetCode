package one;

import java.io.*;
import java.util.*;

public class Main{
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
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
            if(split[i].equals("#")) list.add(null);
            else{
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                list.add(node);
                if(root == null) root = node;
            }
        }

        for(int i = 0;2 * i + 2 < list.size();i++){
            TreeNode node = list.get(i);
            if(node != null){
                node.left = list.get(2 * i + 1);
                node.right = list.get(2 * i + 2);
            }

        }
        return root;
    }

}


