package StackAndQueue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyRandomList {


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node current = head;
        while (current != null){
            map.put(current,new Node(current.val));//建立当前结点和新结点的映射
            current =current.next;
        }
        current = head;
        while (current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }


    public static void main(String[] args){
        System.out.println("请输入一个整数:");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        int[] a=new int[40000];//定义一个数组
        int c,temp,j,i,digit=1; //c表示进位，temp临时结果，digit表示位数
        a[0]=1;//初始值为1
        for(i=2;i<=number;i++){
            for(c=0,j=1;j<=digit;j++){
                temp=a[j-1]*i+c;
                a[j-1]=temp%10;
                c=temp/10;
            }
            while(c>0){
                digit++;
                a[digit-1]=c%10;
                c=c/10;
            }
        }
        for(int u=digit-1;u>=0;u--){
            System.out.print(a[u]);
        }


    }

    public static double mySqrt(int x) {
        double left = 0,right = x;

        while(left <= right){
            double mid = left + (right - left) / 2;

            if(mid * mid <= x){
                left = mid + 1e-3;
            }else right = mid - 1e-3;
        }

        return right;
    }

    public static void ipToTen(String ip){
        String[] str = ip.split("\\.");
        long ans = Long.parseLong(str[0]);
        for(int i = 1;i < 4;i++){
            ans <<= 8;
            ans += Long.parseLong(str[i]);
        }
        StringBuilder sb = new StringBuilder();


        System.out.println(ans);
    }

    public static void tenToIp(String num){
        long n = Long.parseLong(num);
        String str = Long.toBinaryString(n);
        StringBuilder ans = new StringBuilder();
        if(str.length() < 32){
            for(int i = 0;i < 32 - str.length();i++){
                ans.append('0');
            }
        }
        for(int i = 0;i <str.length();i++){
            ans.append(str.charAt(i));
        }

        for(int i = 0;i < 24; i += 8){
            System.out.print(Integer.parseInt(ans.substring(i,i + 8),2) + ".");
        }

        System.out.println(Integer.parseInt(ans.substring(ans.length() - 8,ans.length()),2));
    }

    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[str.length()];
        recur(chars,0,0,visited,new StringBuilder());
        return ans;
    }

    public void recur(char[] chars,int index,int depth,boolean[] visited,StringBuilder sb){
        if(depth == chars.length){
            ans.add(sb.toString());
            return;
        }

        for(int i = 0;i < chars.length;i++){
            if(visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) continue;

            sb.append(chars[i]);
            visited[i] = true;
            recur(chars,i + 1,depth + 1,visited,sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
