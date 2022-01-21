package hash;

import java.util.HashMap;
import java.util.HashSet;

public class IsValidSudiku {

    public static void main(String[] args) {
        isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                  ,{'6','.','.','1','9','5','.','.','.'}
                                  ,{'.','9','8','.','.','.','.','6','.'}
                                  ,{'8','.','.','.','6','.','.','.','3'}
                                  ,{'4','.','.','8','.','3','.','.','1'}
                                  ,{'7','.','.','.','2','.','.','.','6'}
                                  ,{'.','6','.','.','.','.','2','8','.'}
                                  ,{'.','.','.','4','1','9','.','.','5'}
                                  ,{'.','.','.','.','8','.','.','7','9'}});
    }

//    public static boolean isValidSudoku(char[][] board) {
//        HashSet<Character> setRow = new HashSet<>();
//        HashSet<Character> setClo = new HashSet<>();
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(board[i][j] <= '9' && board[i][j] >= '1'){
//                    if(!setRow.add(board[i][j])) return false;
//                }
//                if(board[j][i] <= '9' &&board[j][i] >= '1'){
//                    if(!setClo.add(board[j][i])) return false;
//                }
//            }
//            setRow.clear();
//            setClo.clear();
//        }
//        if(!recur(0,3,0,3,board)) return false;
//        if(!recur(0,3,3,6,board)) return false;
//        if(!recur(0,3,6,9,board)) return false;
//        if(!recur(3,6,0,3,board)) return false;
//        if(!recur(3,6,3,6,board)) return false;
//        if(!recur(3,6,6,9,board)) return false;
//        if(!recur(6,9,0,3,board)) return false;
//        if(!recur(6,9,3,6,board)) return false;
//        if(!recur(6,9,6,9,board)) return false;
//        return true;
//
//
//    }
//
//    public static boolean recur(int rowLeft,int rowRight,int cloLeft,int cloRight,char[][] board){
//        HashSet<Character> set = new HashSet<>();
//        for (int i = rowLeft; i < rowRight; i++) {
//            for (int j = cloLeft; j < cloRight; j++) {
//                if(board[i][j] <= '9' &&board[i][j] >= '1'){
//                    if(!set.add(board[i][j])) return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean  isValidSudoku(char[][] board){
        int[][] row = new int[9][9];
        int[][] clo = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int cur = board[i][j] - '0' - 1;
                    row[i][cur]++;//cur在第i行的位置+1
                    clo[j][cur]++;//cur在第行的位置+1
                    box[i / 3][j / 3][cur]++;////cur在第n个box中的位置+1，box一共九个
                    if(row[i][cur] > 1 || clo[j][cur] > 1 || box[i / 3][j / 3][cur] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
