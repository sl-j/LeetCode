package Array;

import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
        /**
         * 我们定义，在以下情况时，单词的大写用法是正确的：
         *
         * 全部字母都是大写，比如 "USA" 。
         * 单词中所有字母都不是大写，比如 "leetcode" 。
         * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
         * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/detect-capital
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("word = ");
        String word;
        word = sc.next();
        int index = 0;
        int upper = 0;//最后一个大写下标
        int lower = 0;//最后一个小写下标
        char word1[];
        word1 = word.toCharArray();
        for (int i = 0; i < word1.length; i++) {
            if(word1[i]>='a'){ //小写ascii的值大于大写ascii的值
                lower = index;
            }else {
                upper = index;
            }
            index++;
        }
        if(lower>=1&&upper>=1){//全大写则直接true，全小写也是直接true，但是存在小写，并且大写下标大于等于1返回false（即第二位到最后一位出现大小写混杂）
            System.out.println("false");
        }

        System.out.println("true");
    }
}
