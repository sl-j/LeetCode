package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("237"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length()==0){//没有数字则返回空
            return res;
        }
        Map<Character,String> map = new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(map,res,digits,0,new StringBuilder());
        return res;

    }
    static void backtrack(Map<Character,String> map,List<String> res,String digits,int index,StringBuilder path){//回溯算法，map为映射，res为结果集，digits为输入，index为下标，控制走到下一个结点，path为路径
        if(index == digits.length()){ //index为下标，当index等于字符串的长度时，证明对树的其中一条路径遍历完成
            res.add(path.toString()); //将此次遍历的结果放入结果集中
        }else {
            char digit = digits.charAt(index);//返回索引处的字符，即数字
            String str = map.get(digit);//根据key值获取对应字符串
            for(int i = 0;i < str.length();i++){
                path.append(str.charAt(i));//将str[i]的值存入路径中。
                backtrack(map,res,digits,index+1,path);//这是一个递归的过程，在前面str[i]的值确定下来的情况下，根据index+1找接下来的节点
                path.deleteCharAt(index);//回溯，根据下标删除路径中的值，最后会删除到path为空
            }

        }
    }
}
