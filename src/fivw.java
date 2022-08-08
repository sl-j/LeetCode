import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;
import org.junit.Test;

import java.util.*;

public class fivw {

     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//         if(str.length() % 8 == 0) System.out.println(str);
        StringBuilder ans = new StringBuilder();
        int i = 0;

        for(i = 0;i < str.length();i++){
            if(i > 0 && i % 8 == 0)ans.append('\n');
            ans.append(str.charAt(i));
        }


        while(i++ % 8 != 0) ans.append("0");
        System.out.println(ans.toString());
        System.out.println(ans.length());

    }

    public int maxRotateFunction(int[] nums) {
        int ans = 0;
        int sumA = 0;
        int n = nums.length;
        int F = 0;
        for(int i = 0;i < n;i++){
            sumA += nums[i];
            F +=  i * nums[i];
        }
        for(int i = 1;i < n;i++){
            F = sumA - n * nums[n - i] + F;
            ans = Math.max(F,ans);
        }

        return ans;
    }


    @Test
    public void test() {
//        int i = largestInteger(65875);
//        System.out.println(i);
//        String s = num2cn(100005);
//        System.out.println(s);
//        maxRotateFunction(new int[]{4,3,2,6});
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head;

        detectCycle(head);

//        int pwwkew = lengthOfLongestSubstring("dvdf");

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(true){
            if(fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }

        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    List<List<Integer>> edgs;//构建有向图
    int index;
    int[] indeg;//记录每个课程的入度数
    int[] ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edgs = new ArrayList<>();
        indeg = new int[numCourses];
        ans = new int[numCourses];
        //初始化有向图
        for(int i = 0;i < numCourses;i++){
            edgs.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edgs.get(info[0]).add(info[1]);
            indeg[info[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(indeg[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            ans[index++] = course;
            for(int num : edgs.get(course)){
                indeg[num]--;
                if(indeg[num] == 0){
                    queue.offer(num);
                }
            }
        }

        if(index != numCourses) return new int[0];

        return ans;
    }


    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int ans = 0;
        int[] count = new int[128];
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();

        for(;right < s.length();right++){
            while(left < right && count[chars[right]] > 0) {
                count[chars[left]]--;
                left++;
            }
            count[chars[right]]++;
            ans = Math.max(ans,right - left + 1);
            System.out.println(s.substring(left,right + 1));
        }

        return ans;
    }


    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> winer = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        Map<Integer, Integer> loserAll = new HashMap<>();
        for (int[] match : matches) {
            if (!loserAll.containsKey(match[1])) {
                loserAll.put(match[1], 1);
            } else {
                loserAll.put(match[1], loserAll.get(match[1]) + 1);
            }

            winer.add(match[0]);
            if (loserAll.containsKey(match[0]) && winer.contains(Integer.valueOf(match[0]))) {//胜利者和失败者同时兼具
                winer.remove(Integer.valueOf(match[0]));
            }

            if (loserAll.get(match[1]) > 1) {
                loser.remove(Integer.valueOf(match[1]));
            } else {
                loser.add(match[1]);
            }
        }


        Collections.sort(winer, (a, b) -> a - b);
        Collections.sort(loser, (a, b) -> a - b);

        ans.add(winer);
        ans.add(loser);

        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();


        return ans;


    }

    public int largestInteger(int num) {
//        PriorityQueue<Character> queue1 = new PriorityQueue<>((o1,o2) -> o2 - o1);//放奇数位
//        PriorityQueue<Character> queue2 = new PriorityQueue<>((o1,o2) -> o2 - o1);//放偶数位
//        String str = String.valueOf(num);
//        for(int i = 0;i < str.length();i++){
//            char ch = str.charAt(i);
//            int n = (int)(ch - '0');
//            if(n % 2 == 1) queue1.offer(ch);
//            else queue2.offer(ch);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while(!queue1.isEmpty() || !queue2.isEmpty()){
//            if(!queue1.isEmpty()) sb.append(queue1.poll());
//            if(!queue2.isEmpty()) sb.append(queue2.poll());
//        }
//
//        return Integer.parseInt(sb.toString());
        char[] chars = String.valueOf(num).toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            int max = (int) (chars[i] - '0');
            int maxIndex = i;
            for (int j = i + 1; j < chars.length; j++) {
                if ((int) (chars[i] - '0') % 2 == 0 && (int) (chars[j] - '0') % 2 == 0) {
                    if (max < (int) (chars[j] - '0')) {
                        max = (int) (chars[j] - '0');
                        maxIndex = j;
                    }
                }
                if ((int) (chars[i] - '0') % 2 == 1 && (int) (chars[j] - '0') % 2 == 1) {
                    if (max < (int) (chars[j] - '0')) {
                        max = (int) (chars[j] - '0');
                        maxIndex = j;
                    }
                }
            }
            swap(chars, i, maxIndex);
        }

        return Integer.parseInt(String.valueOf(chars));
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }

        while (k > 0) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            if (num1 == num2) {
                k--;
                num1++;
            } else if ((num2 - num1) < k) {
                k -= (num2 - num1);
                num1 += (num2 - num1);
            } else if ((num2 - num1) >= k) {
                num1 += k;
                k = 0;
            }
            queue.offer(num1);
            queue.offer(num2);
        }

        long ans = 1;
        while (!queue.isEmpty()) {
            ans *= ((long) queue.poll() % mod);
        }
        return (int) ans % mod;
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);
                if (valid) return true;
            }
        }
        return false;
    }


//    public String num2cn(int n) {
////        if (n == 0)
////            return "零";
////        char[] words = String.valueOf(Math.abs(n)).toCharArray();
////        String[] unitsMap = new String[]{"", "十", "百", "千", "", "万", "亿"};
////        String[] digitsMap = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
////        StringBuilder builder = new StringBuilder();
////        for (int cnt = 0, len = Math.min(words.length, 4); len > 0; len = Math.min(words.length - cnt * 4, 4)) {
////            StringBuilder segBuilder = new StringBuilder();
////            int pos = words.length - 1 - cnt * 4;
////            boolean full0 = true;
////            for (int i = len - 1; i >= 0; i--) {
////                int val = words[pos - i] - '0';
////                if (val != 0) {
////                    full0 = false;
////                    if (words[pos - i] == '0') {
////                        segBuilder.append(digitsMap[0]);
////                    }
////                    segBuilder.append(digitsMap[val]).append(unitsMap[i]);
////                }
////            }
////            if (!full0)
////                segBuilder.append(unitsMap[cnt + 4]);
////            builder.insert(0, segBuilder);
////            cnt++;
////        }
////        String val = builder.toString().replaceAll("^一十","十");
////        return n < 0 ? "负" + val : val;
//
//        if(n == 0) return "零";
//        StringBuilder ans = new StringBuilder();
//        char[] words = String.valueOf(n).toCharArray();
//        String[] digitMap = new String[]{"零","一","二","三","四","五","六","七","八","九"};
//        String[] unitMap = new String[]{"十","百","千","万","亿"};
//        int cnt = 0;//保存计算了几次四位数
//        for(int len = 0;len < words.length;len = Math.min(4, (words.length) - 4 * cnt)){//以千为单位进行计算
//            StringBuilder tmp = new StringBuilder();
//            int pos = words.length - 1 - cnt * 4;//记录哪一个第四位
//            boolean fullZero = true;
//            for(int i = len - 1;i >= cnt * 4;i--){
//                if(words[len - 1] == '0') {
//                    tmp.append(digitMap[0]);//首置位为0
//                    continue;
//                }
//                int val = words[pos - i] - '0';
//                if(val != 0){
//                    tmp.append(digitMap[val + 1]).append(unitMap[i]);
//                }
//            }
//        }
//    }
public String reverseWords(String s) {
    StringBuilder ans = new StringBuilder();
    String[] str = s.split(" ");

    for(String tmp : str){
        char[] chars = tmp.toCharArray();
        reverse(chars);
        ans.append(chars).append(" ");
    }

    return ans.toString().trim();
}



    //字符翻转函数
    public void reverse(char[] chars){
        int left = 0;
        int right = chars.length;
        while(left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
    }

}
