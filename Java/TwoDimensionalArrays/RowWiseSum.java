package Java.TwoDimensionalArrays;

public class RowWiseSum {
    public static void rowWiseSum(int[][] mat) {
        int rows = mat.length;
        for(int i = 0; i < rows; i++) {
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            System.out.print(sum + " ");
        }
    }
}
