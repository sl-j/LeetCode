package one;

import java.util.HashMap;
import java.util.HashSet;

public class CheckValid {

    public static void main(String[] args) {
        System.out.println(checkValid(new int[][]{{1,1,1},{1,2,3},{1,2,3}}));
    }

    public static boolean checkValid(int[][] matrix) {
        HashSet setRow = new HashSet();
        HashSet setClo = new HashSet();
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if( !setRow.add(matrix[i][j]) || matrix[i][j] < 1 || matrix[i][j] > n) return false;
                if( !setClo.add(matrix[j][i]) || matrix[j][i] < 1 || matrix[j][i] > n) return false;
            }
            setRow.clear();
            setClo.clear();
        }
        return true;
    }

}
