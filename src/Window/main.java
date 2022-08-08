package Window;
import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class main {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
    }

//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] split = br.readLine().split(",");
//        TreeNode root = build(split);
//        System.out.println();
//    }
//
//    private static TreeNode build(String[] split){
//        List<TreeNode> list = new ArrayList<>();
//        TreeNode root = null;
//        for(int i = 0;i < split.length;i++){
//            TreeNode tmp = null;
//            if(!split[i].equals("null")){
//                tmp = new TreeNode(Integer.parseInt(split[i]));
//            }
//            if(root == null) root = tmp;
//            list.add(tmp);
//        }
//
//        for(int i = 0;2 * i + 2 < list.size();i++){
//            TreeNode tmp = list.get(i);
//            if(tmp != null){
//                tmp.left = list.get(2 * i + 1);
//                tmp.right = list.get(2 * i + 2);
//            }
//        }
//
//        return root;
//    }

    static int res = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(str);
        while(n > 0){
            String[] s = br.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);

            dfs(a,b);
            System.out.println(res);
        }
    }

    private static void dfs(long a,long b){
        if(a <= 0 || b <= 0) return;

        if(a < b){
            a--;
            b -=2;
        }else{
            b--;
            a-=2;
        }
        if(a < 0 || b < 0) return;
        res++;
        dfs(a,b);
    }



//    private static TreeNode build(String[] split){
//        List<TreeNode> list = new ArrayList<>();
//        TreeNode root = null;
//
//        for(int i = 0;i < split.length;i++){
//            TreeNode cur = null;
//            if(!split[i].equals("null")) cur = new TreeNode(Integer.parseInt(split[i]));
//            list.add(i,cur);
//            if(i == 0){
//                root = cur;
//            }
//        }
//
//        for(int i = 0;2 * i + 2 < list.size();i++){
//            TreeNode cur = list.get(i);
//            if(cur != null){
//                cur.left = list.get(2 * i + 1);
//                cur.right = list.get(2 * i + 2);
//            }
//        }
//        return root;
//    }

}
