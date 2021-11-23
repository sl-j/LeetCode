package Array;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);


    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");//根据空格切割字符串
        StringBuilder sb = new StringBuilder();
        for (String str:s1) {
            String s2 = new StringBuilder(str).reverse() + " ";//将字符串数组中的内容转换为StringBuffer，使用翻转函数
            sb.append(s2);
        }

        return sb.toString().trim();//转换成字符串，再去除头尾的空格
    }
}

