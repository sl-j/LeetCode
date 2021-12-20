package search;

import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    //数组方式解题
    public static char firstUniqChar(String s) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
           chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(chars[s.charAt(i)-'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //哈希表方式解题
    public static char firstUniqChar1(String s) {
        HashMap<Character,Boolean> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            hashMap.put(c,!hashMap.containsKey(c));//已经包含这个值，则存入false，不包含则存入true，最终只出现一次的字符，其value为true
        }
        for (char c: chars) {
            if(hashMap.get(c)) return c;//找到第一个为true的值，返回
        }
        return ' ';
    }
}
