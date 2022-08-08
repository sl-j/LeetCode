import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class three {


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    
    
    @Test
    public void test(){
//        List<Integer> kDistantIndices = findKDistantIndices(new int[]{1,2,3,4,5,6,7,8,9,10}, 2, 10);
//        System.out.println(kDistantIndices);

//        digArtifacts(2,new int[][]{{0,2,0,5},{0,1,1,1},{3,0,3,3},{4,4,4,4},{2,1,2,4}},new int[][]{{0,2},{0,3},{0,4},{2,0},{2,1},
//                {2,2},{2,5},{3,0},{3,1},{3,3},{3,4},{4,0},{4,3},{4,5},{5,0},{5,1},{5,2},{5,4},{5,5}});

//        searchRange(new int[]{1},1);
        LIS(new int[]{1,2,8,6,4});
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];
        int p = -5;
        int q = -5;
        for(int i = 0,j = len - 1;i <len;i++,j--){
            if(nums[i] == key){
                p = i;
            }
            if(nums[j] == key){
                q = j;
            }
            left[i] = p;
            right[j] = q;
        }

        if(p == -5) return ans;
        for(int i = 0;i < len;i++){
            if(left[i] >= 0 && Math.abs(i - left[i]) <= k && nums[left[i]] == key){
                ans.add(i);
                continue;
            }

            if(right[i] >=0 &&Math.abs(i - right[i]) <= k && nums[right[i]] == key){
                ans.add(i);
                continue;
            }
        }

        return ans;
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        Set<String> set = new HashSet<>();
        int ans = 0;
        ReentrantLock lock = new ReentrantLock();


        for(int[] num: dig){
            StringBuilder sb = new StringBuilder();

            sb.append(num[0]);
            sb.append(num[1]);
            set.add(sb.toString());

        }

        for(int[] artifact : artifacts){
            if(verity(artifact[0],artifact[2],artifact[1],artifact[3],set)){
                ans++;
            }
        }
        return ans;

    }

    public boolean verity(int topLeft,int topRight,int bootomLeft,int bootomRight,Set<String> set){
        String s = "";
        for(int i = topLeft; i <= topRight;i++){
            for(int j = bootomLeft;j <= bootomRight;j++){
                s = "" + i + j;
                if(!set.contains(s)) return false;
            }
            s = "";
        }

        return true;
    }


    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num: nums ){
            if(map.get(num) > nums.length / 2) return num;
            if(!map.containsKey(num)){
                map.put(num,0);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        return 0;

    }

    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target && (mid - 1 == -1 || nums[mid] != nums[mid - 1])) ans[0] = mid;
            if(nums[mid] == target && (mid + 1 == nums.length || nums[mid] != nums[mid + 1])) ans[1] = mid;

            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return ans;

    }

    public String validIPAddress(String queryIP) {
        String[] strs;

        if(queryIP.chars().filter(ch -> ch == '.').count() == 3){
            return validIPV4(queryIP);
        }else if(queryIP.chars().filter(ch -> ch == '.').count() == 7){
            return validIPV6(queryIP);
        }else return "Neither";
    }

    public String validIPV4(String IP){
        String[] str = IP.split("\\.",-1);

        for(String s : str){
            if(s.length() == 0 || s.length() > 3) return "Neither";

            if(s.charAt(0) == '0' && s.length() > 1) return "Neither";

            for(char c : s.toCharArray()){
                if(Character.isDigit(c)) return "Neither";
            }

            if(Integer.valueOf(s) > 255) return "Neither";
        }

        return "IPv4";
    }

    public String validIPV6(String IP){
        String[] str = IP.split(":",-1);
        String valid = "0123456789abcdefABCDEF";

        for(String s : str){

            if(s.length() > 4) return "Neither";
            for(char c : s.toCharArray()){
                if(valid.indexOf(c) == -1) return "Neither";
            }
        }

        return "IPv6";
    }


    public String largestNumber(int[] nums) {

        StringBuilder ans = new StringBuilder();
        String[] str = new String[nums.length];
        for(int i= 0;i < nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str,(o1,o2) ->{
            return o2.compareTo(o1);
        });

        for(String s : str){
            ans.append(s);
        }

        return ans.toString();

    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataList = data.split(",");

        return rehelp(new ArrayList<String>(Arrays.asList(dataList)));
    }

    public StringBuilder help(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("None,");
            return sb;
        }
        sb.append(root.val + ",");
        sb = help(root.left,sb);
        sb = help(root.right,sb);
        return sb;
    }

    public TreeNode rehelp(List<String> dataList){
        if(dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rehelp(dataList);
        root.right = rehelp(dataList);

        return root;
    }


    public void solve(char[][] board) {
        int row = board.length;
        int clo =  board[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < clo;j++){
                if(board[i][j] == 'o'){
                    boolean flag = dfs(board,i,j);
                }
            }
        }
    }

    public boolean dfs(char[][] board,int i,int j){
        if(board[i][j] == 'x'){
            return false;
        }
        if(i == board.length || i == 0 ||j == 0 || j == board[0].length){
            return true;
        }
        ConcurrentHashMap map = new ConcurrentHashMap();


        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if(board[i][j] == 'o'){
            board[i][j] = 'x';
            up = dfs(board, i - 1,j);
            down = dfs(board,i + 1,j);
            left = dfs(board,i,j - 1);
            right = dfs(board,i,j + 1);
        }

        if(up || down || left || right) board[i][j] = 'o';
        return up || down || left ||right;
    }

    public int[] LIS (int[] nums) {
        // write code here
        int[] dp = new int[nums.length];
        int[] end = new int[nums.length];
        int len = 0;

        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            int left = 0,right = len;
            int mid = 0;

            while(left < right){
                mid = left + (right - left) / 2;
                if(dp[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            dp[left] = num;
            if(left == len) len++;
            end[i] = left;
        }
        int[] ans = new int[len];
        len = len - 1;
        for(int i = nums.length - 1;i >= 0;i--){
            if(end[i] == len){
                ans[len--] = nums[i];
            }
        }

        return ans;
    }


}
