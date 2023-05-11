package Java.TwoDimensionalArrays;

public class Spiral {
    public static void spiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows!=0){
            cols=matrix[0].length;
        }     
        
        int i, k = 0, l = 0;
        
        while (k < rows && l < cols) {
            for (i = l; i < cols; ++i) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
 
            for (i = k; i < rows; ++i) {
                System.out.print(matrix[i][cols - 1] + " ");
            }
            cols--;
 
            if (k < rows) {
                for (i = cols - 1; i >= l; --i) {
                    System.out.print(matrix[rows - 1][i] + " ");
                }
                rows--;
            }
 
            if (l < cols) {
                for (i = rows - 1; i >= k; --i) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }
}
