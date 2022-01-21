package hash;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String,List<String>> map = new HashMap<>();
//        for (String str: strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key = new String(chars);
//            /**
//             * 这一步是为了取出key对应的value（有对应的value，直接取出来，没有则取出为空）
//             */
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            /**
//             * 将本次的str加入value中
//             */
//            list.add(str);
//            map.put(key,list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] count = new int[26];
            char[] chars = str.toCharArray();
            for (char c: chars) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if(count[i] > 0){
                    sb.append((char)(i + 'a'));
                    sb.append(count[i]);
                }
            }
            String s = sb.toString();
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            map.put(s,list);
        }
        return new ArrayList<List<String>>(map.values());
    }


}
