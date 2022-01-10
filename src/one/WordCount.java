package one;

import org.w3c.dom.css.CSSStyleRule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordCount {

    public static void main(String[] args) {
        System.out.println(wordCount(new String[]{"g", "vf", "ylpuk", "nyf", "gdj", "j", "fyqzg", "sizec"}, new String[]{"r", "am", "jg", "umhjo", "fov", "lujy", "b", "uz", "y"}));
    }

    public static int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        HashSet<Integer> set = new HashSet();
        for (String str : startWords) {
            int cur = 0;
            for (int i = 0; i < str.length(); i++) {
                cur += 1 << (str.charAt(i) - 'a');
            }
            set.add(cur);
        }

        for (String str : targetWords) {
            int cur = 0;
            for (int i = 0; i < str.length(); i++) {
                cur += 1 << (str.charAt(i) - 'a');
            }
            for (int i = 0; i < str.length(); i++) {
                int y = cur - (1 << (str.charAt(i) - 'a'));
                if (set.contains(y)) {
                    res++;
                    break;
                }
            }
//        int res = 0;
//        HashSet<String> set = new HashSet();
//        for (String str:startWords) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String s = new String(chars);
//            set.add(s);
//        }
//        for (String str: targetWords) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String word = new String(chars);
//            for (int i = 0; i < word.length(); i++) {
//                String subStr = word.substring(0,i) + word.substring(i+1,word.length());
//                if(set.contains(subStr)){
//                    res++;
//                    break;
//                }
//            }
//
//        }
//        return res;
        }
        return res;
    }
}