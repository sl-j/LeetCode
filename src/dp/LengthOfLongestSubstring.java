package dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(new String("abcabcbb")));
    }
    //将hashmap改为数组，时间复杂度会下降许多
    public static int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0,res = 0;
//        HashMap<Character,Integer> lastOccur = new HashMap<>();
        int[] lastOccur = new int[128];
        Arrays.fill(lastOccur,-1);//为-1是因为此处记录的是下标值，字符串的下标是从0开始
        for (; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (lastOccur[curr] > -1){//》-1证明此个字符出现过
                left = Math.max(left,lastOccur[curr] + 1);//此处用最大值是因为，left不能往回退（如abba，回退left会导致中间出现重复字符）
            }
            lastOccur[curr] = right;//无论有没有包含right指向的字符，都要更新
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
