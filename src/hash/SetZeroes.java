package hash;

public class SetZeroes {

    public static void main(String[] args) {

    }

    /**
     * 开辟两个空间，一个记录哪一行有0，一个记录哪一列有0，需要两次遍历矩阵，空间复杂度为m+n
     * @param matrix
     */
//    public static void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        boolean[] row = new boolean[m];
//        boolean[] clo = new boolean[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(matrix[i][j] == 0){//如果该矩阵的某一位置为0.标记其这一行和这一列都为0
//                    row[i] = true;
//                    clo[j] = true;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(row[i] || clo[j]){
//                    matrix[i][j] = 0;
//                }
//            }
//        }

    /**
     * 用矩阵的第一行和第一列记录某行某列是否为0,但是需要额外判断第一行和第一列
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean clo = false;
        for (int i = 0; i < matrix.length; i++) {//第一行一旦有0，则直接记为TRUE
            if(matrix[i][0] == 0) row = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {//第一列一旦有0，则直接记为TRUE
            if(matrix[0][i] == 0) clo = true;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){//如果矩阵中某一个值为0，记录其在第一行第一列的位置为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row == true){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(clo == true){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

    }

}
