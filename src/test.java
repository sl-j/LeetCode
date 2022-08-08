import org.junit.Test;

import java.util.*;

public class test {

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  @Test
  public void test(){
//      int[] ints = maxSlidingWindow(new int[]{7, 2, 4}, 2);
      isInterleave("aabcc","dbbca","aadbbcbcac");
  }

//    public List<Integer> ans = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//          if(root == null) return new ArrayList<>();
//          recur(root);
//          return ans;
//    }
//
//    public void recur(TreeNode root){
//        if(root == null) return;
//        recur(root.left);
//        ans.add(root.val);
//        recur(root.right);
//    }

    public String reverseWords(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left <= right && s.charAt(left) == ' ') left++;
        while(left <= right && s.charAt(right) == ' ') right--;

        s = s.substring(left,right + 1);
        char[] chars = s.toCharArray();

        reverser(chars,0,chars.length - 1);

        reverseWord(chars);

        StringBuilder sb =cleanSpace(chars,0,chars.length);

        return sb.toString();
    }


    //反转字符数组
    public void reverser(char[] chars,int left,int right){
        while(left < right){
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    //反转单个单词
    public void reverseWord(char[] chars){
        int start = 0;
        int end = 0;
        while(end < chars.length){
            start = end;
            while(end < chars.length && chars[end] != ' '){
                end++;
            }
            reverser(chars,start,end - 1);
            end++;
        }
    }

    //去除中间的空格
    public StringBuilder cleanSpace(char[] chars,int left,int right){
        StringBuilder sb = new StringBuilder();
        while(left < right){
            char c = chars[left];
            if(c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != ' '){//如果当前为空格，前一个字符不是空格也可以加入，加入后最后一位为空格，再有空格,不可加入
                sb.append(c);
            }
            left++;
        }

        return sb;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,0,inorder.length - 1,map);
    }

    public TreeNode build(int[] preorder,int preRoot,int inLeft,int inRight,Map<Integer,Integer> map){
        if(inLeft > inRight) return null;
        int rootIndex = map.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);

        root.left = build(preorder,preRoot + 1,inLeft,rootIndex - 1,map);

        root.right = build(preorder,rootIndex + 1,rootIndex + 1,inRight,map);

        return root;
    }

    public String longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                if(text1.charAt(i - 1) == text2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j -1] + 1;
                    sb.append(text2.charAt(j -1));
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return sb.toString();

    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        int[] plates = new int[len];
        int leftStart = -1;
        int rightStart = -1;
        int platesStart = 0;
        for(int i = 0,j = len - 1;i < len;i++,j--){
            if(s.charAt(i) == '|') {
                leftStart = i;
            }
            if(s.charAt(j) == '|') rightStart = j;
            if(s.charAt(i) == '*') platesStart++;
            left[i] = leftStart;
            right[j] = rightStart;
            plates[i] = platesStart;
        }

        int[] ans = new int[queries.length];
        for(int i = 0;i < ans.length;i++){
            int l = right[queries[i][0]];
            int r = left[queries[i][1]];
            if(l > r){
                ans[i] = plates[r] - plates[l];
            }
        }

        return ans;
    }


    public String minWindow(String s, String t) {
     List<Integer> list = new ArrayList<>();



        int sLen = s.length();
        int tLen = t.length();

        if(sLen == 0 || tLen == 0 || sLen < tLen) return "";

        char[] charArrayS = s.toCharArray();//记录窗口内出现字符的频数
        char[] charArrayT = t.toCharArray();//记录t子串中各个字符的频数

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for(char c : charArrayT){
            tFreq[c]++;
        }

        int distance = 0;//记录窗口的大小
        int minLen = sLen + 1;//记录最小长度
        int begin = 0;//记录最小子串的起始位置

        int left = 0;
        int right = 0;//窗口的左右边界

        while(right < sLen){//窗口的右边界到达边界时停止
            if(tFreq[charArrayS[right]] == 0){//如果右边界的字符没有出现在t中，继续右移
                right++;
                continue;
            }

            if(winFreq[charArrayS[right]] < tFreq[charArrayS[right]]){//右边界的字符，均在s和t中出现，但是还小于t的频数时，窗口大小++
                distance++;
            }

            winFreq[charArrayS[right]]++;//出现在右边界的字符，都要在这个窗口中加一
            right++;//保持右边界不断移动

            while(distance == tLen){//当t的字符全部出现在s中时，要开始收缩左边界
                if(right - left < minLen){//更新最小长度的下标
                    minLen = right - left;
                    begin = left;
                }
                if(tFreq[charArrayS[left]] == 0){//左边界的字符不在t中时，直接向左移动边界
                    left++;
                    continue;
                }

                if(winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){//此时窗口内已经包含所有的t字符（即win和t中字符的频数是相等的），所以当左边界遇到t中的字符时，频数一定相等，此时将窗口大小减一
                    distance--;
                }
                winFreq[charArrayS[left]]--;//将出现在左边界的字符移除窗口
                left++;
            }

        }

        if(minLen == sLen + 1) return "";
        else return s.substring(begin,minLen + 1);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k ==1) return nums;
        List<Integer> list = new ArrayList<>();

        int start = 1;
        int end = 0;
        int max = nums[end];
        while(end < k){
            max = Math.max(max,nums[end++]);
        }
        list.add(max);
        while(end < nums.length){
            if(nums[end] <= max && nums[start] <= max){
                list.add(max);
            }else {
                max = Math.max(nums[start],nums[end]);
                list.add(max);
            }
            end++;
            start++;
        }

        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }

        return ans;

    }

    @Test
    public void stack(){
         Deque<Integer> stack = new LinkedList<>();
         stack.push(3);
         stack.push(2);
         stack.push(1);
         recur(stack);
         while(!stack.isEmpty()){
             System.out.println(stack.pop());
        }
    }

    public void recur(Deque<Integer> stack){
     if(stack.isEmpty()){
         return;
     }else{
         int last = fun(stack);
         recur(stack);
         stack.push(last);
     }
    }

    public int fun(Deque<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = fun(stack);
            stack.push(result);
            return last;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(s1 + s2 != s3){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 0;i <= len1;i++){
            for(int j = 0;j <= len2;j++){
                if(i > 0 && s1.charAt(i - 1) == s3.charAt(i+j-1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if(j > 0 && s2.charAt(j - 1) == s3.charAt(i+j-1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[len1][len2];
    }





}
