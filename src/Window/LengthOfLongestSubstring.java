package Window;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution(2);
        solution.set(1,1);
        solution.set(2,2);
        solution.get(1);
        solution.set(3,3);
        solution.get(2);
        solution.set(4,4);
        solution.get(1);
        solution.get(3);
        solution.get(4);
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0,res = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (right<s.length()){
            char c = s.charAt(right++);
            while (set.contains(c)){//右指针指向的字符在左边出现时，不断删除左边的字符，同时左指针右移，直至删除到右指针指向的重复字符
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, set.size());


        }
        return res;

    }
}
