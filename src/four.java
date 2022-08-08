import org.junit.Test;

import java.util.*;

public class four {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

//    @Test
//    public void test() {
//        Node root = new Node(1);
////        root.left = new Node(2);
////        root.left.left = new Node(1);
////        root.left.right = new Node(3);
////        root.right = new Node(5);
//        treeToDoublyList(root);
//
//
//    }

    public Node treeToDoublyList(Node root) {

        if(root == null) return null;


        List<Node> tmp = new ArrayList<>();
        recur(root,tmp);

        if(tmp.size() == 1) return tmp.get(0);

        Node pre = tmp.get(0);
        Node tail = tmp.get(tmp.size() - 1);
        pre.left = tail;
        tail.right = pre;
        int i = 1;
        for(i = 0;i < tmp.size() - 1;i++){
            if(i != 0){
                tmp.get(i).left = tmp.get(i - 1);
            }
            tmp.get(i).right = tmp.get(i + 1);
        }
        tail.left = tmp.get(i - 1);

        return pre;

    }

    public void recur(Node root,List<Node> tmp){
        if(root == null) return;
        recur(root.left,tmp);
        tmp.add(root);
        recur(root.right,tmp);
    }


    @Test
    public void test(){

        System.out.println(reverse(1463847412));
        System.out.println(Integer.MAX_VALUE);
    }
    public int calculate(String s) {



        Deque<Integer> stack = new LinkedList<Integer>();

        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public String removeKdigits(String num, int k) {
        String str = String.valueOf(k);

        Deque<Character> stack = new LinkedList<>();

        for(char c : num.toCharArray()) {
            if (stack.isEmpty() || c > stack.peek() || k == 0) {
                stack.push(c);
            }
            while (k > 0 && c < stack.peek()) {
                k--;
                stack.pop();
                stack.push(c);
            }

        }

        boolean isZero = true;
        StringBuilder ans = new StringBuilder();
        while(stack.isEmpty()){
            char c = stack.pollLast();
            if(isZero && c == '0'){
                continue;
            }
            isZero = false;
            ans.append(c);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        int flag = 1;
        int start = 0;

        if(str.charAt(0) == '-'){
            flag = -1;
            start = 1;
        }
        int ans = 0;

        for(int i = str.length() - 1;i >= start;i--){
            if(ans > Integer.MAX_VALUE / 10 - ((str.charAt(i) - '0')) ){
                return 0;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
        }

        return ans * flag;


    }

    public int calPoints(String[] ops) {

        Deque<Integer> stack = new LinkedList<>();

        for(String c : ops){
            if(c == "C"){
                stack.pop();
            }else if(c == "D"){
                int tmpD = stack.peek();
                stack.push(tmpD * 2);
            }else if(c == "+"){
                int tmp1 = stack.pop();
                int tmp2 = stack.peek();
                stack.push(tmp1);
                stack.push(tmp1 + tmp2);
            }else{
//                stack.push(Integer.parseInt(c));
                int tmp = 0;
                for(char ch : c.toCharArray()){
                    tmp = tmp * 10 + (ch - '0');
                }
                stack.push(tmp);
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) ans += stack.pop();

        return ans;

    }
    @Test
    public void test1(){
        isPalindrome(121);

        System.out.println(addStrings("1b","2x"));
    }

    public String addStrings(String num1, String num2){
        int flag = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 -1;
        int j = len2 - 1;
        int x = 0;
        int y = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0){
            if(i >= 0){
                if(Character.isDigit(num1.charAt(i))){
                    x = num1.charAt(i) - '0';
                }else{
                    x = num1.charAt(i) - 'a' + 10;
                }
            }else{
                x = 0;
            }

            if(j >= 0){
                if(Character.isDigit(num2.charAt(j))){
                    y = num2.charAt(j) - '0';
                }else{
                    y = num2.charAt(j) - 'a' + 10;
                }
            }else{
                x = 0;
            }
            int tmp = x + y + flag;
            ans.append(tmp % 36);
            flag = tmp / 36;
            i--;
            j--;
        }
        if(flag > 0) ans.append(flag);

        return ans.reverse().toString();

    }


    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(x);
        sb.append(str);
        String tmp = sb.reverse().toString();

        boolean flag =  str.equals(tmp);

        return flag;

    }


    public int lastRemaining(int n, int m) {
        Deque<Integer> qeque1 = new LinkedList<>();


        List<Integer> list = new ArrayList<>();

        for(int i = 0;i < n;i++){
            list.add(i);
        }

        while(list.size() != 1){
            list.remove((m % list.size()) - 1);
        }

        return list.get(0);

    }



}
