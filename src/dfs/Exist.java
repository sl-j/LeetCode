package dfs;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,char[] words,int i,int j,int k){
        /**
         * 行和列的长度超出边界或者当前字母不等于word中的字母时，返回false
         */
        if( i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != words[k]){
            return false;
        }
        if(k == words.length - 1) return true;//遍历到字符串结尾还没返回false，证明正确
        board[i][j] = '#';//将访问过的地方设置为#，#不在字母中，不可能会与字母相等
        boolean res = dfs(board, words, i - 1, j, k + 1) ||
                      dfs(board, words, i + 1, j, k + 1) ||
                      dfs(board, words, i, j - 1, k + 1) ||
                      dfs(board, words, i, j + 1, k + 1);
        board[i][j] = words[k];
        return res;
    }

}
