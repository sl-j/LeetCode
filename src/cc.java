import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class cc {

    //遇到的问题，数组越界，输入格式不正确，应都为String输入；
//int型溢出，要换为long型
//        public static void main(String[] args)
//        {
//            double sqrt = Sqrt(5);
//            System.out.println(sqrt);
////           validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
//        }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] st = str.split(" ");
        int[] nums = new int[st.length];
        for(int i = 0;i < st.length;i++){
            nums[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            ans += Math.abs(nums[i] - (i + 1));
        }

        System.out.println(ans);
    }

    public static int help(int[] scores,int x,int y){
        Arrays.sort(scores);
        for(int i = x - 1;i < scores.length;i++){
            if((i + 1) <= y && (i + 1) >= x && (scores.length - i + 1) >= x && (scores.length - i + 1) <= y) return scores[i];
        }


        return -1;
    }

        private static void TentoIp(String p) {

            long temp=Long.parseLong(p);
            String ip=Long.toBinaryString(temp);

            StringBuilder sb=new StringBuilder();
            if(ip.length()<32){
                for(int i=0;i<(32-ip.length());i++){
                    sb.append(0);
                }
                sb.append(ip);
            }else if(ip.length()==32){
                sb.append(ip);
            }

            for(int i=0;i<sb.length()-8;i=i+8){

                System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
            }




            System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));

        }

        private static long IptoTen(String ip) {

            Map<Integer,Integer> map = new HashMap<>();

            List<Integer> list = new LinkedList<>();

            String[] arr=ip.split("\\.");
            long n=Long.parseLong(arr[0]);

            for(int i=1;i<arr.length;i++){
                n=n<<8;
                n=n+Long.parseLong(arr[i]);
            }

            return n;
        }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        String[] split = version1.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.max(len1,len2);

        for(int i = 0;i < len;i++){
            int x = 0;
            int y = 0;
            if(i == len1) x = 0;
            if(i == len2) x = 0;

            x = Integer.parseInt(v1[i]);
            y = Integer.parseInt(v2[i]);
            StringBuilder tmp = new StringBuilder();
            tmp.reverse();
            String s1;

            if( x > y) return 1;
            else if(y > x) return -1;
        }

        return 0;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        int max = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        int[] ans = new int[k];
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        for(int i = 0;i < k;i++){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i < num.length;i++){
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }

            int left = i - size + 1;

            while(!queue.isEmpty() && queue.peekFirst() < left){
                queue.pollFirst();
            }

            if(left >= 0){
                ans.add(num[queue.peekFirst()]);
            }
        }

        return ans;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;

        while(i < pushed.length){
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            stack.push(pushed[i++]);
        }


        return j == popped.length;
    }


    public static double Sqrt(int num){
        //使用二分法进行检测
        double low=0,high=num,accury=1e-5;
        double middle = 0;
        while (Math.abs(middle*middle-num)>accury){
            middle = low + (high - low + 1) / 2;
            if(middle*middle>num){
                high=middle - 1;
            }else {
                low=middle;
            }
        }
        return low;
    }




}
