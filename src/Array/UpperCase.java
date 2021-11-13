package Array;

import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
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
