package Java.TwoDimensionalArrays;

public class PrintLikeAWave {
    public static void printInWave(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) {
            return;
        }

        int cols = mat[0].length;
        int j = 0;
        for(int i = 0; i < cols; i++) {
            if(j == 0) {
                while(j < rows) {
                    System.out.print(mat[j][i] + " ");
                    j++;
                }
                j--;
            } else {
                while(j >= 0) {
                    System.out.print(mat[j][i] + " ");
                    j--;
                }
                j++;
            }
            
        }
    }
}
