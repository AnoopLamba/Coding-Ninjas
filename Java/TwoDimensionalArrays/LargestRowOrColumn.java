package Java.TwoDimensionalArrays;

public class LargestRowOrColumn {
    public static void largestRowOrColumn(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) {
            System.out.println("row 0 -2147483648");
            return;
        }

        int colms = mat[0].length;
        int rowIndex = 0;
        int colIndex = 0;
        int maxRowSum = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++) {
            int sum = 0;
            for(int j = 0; j < colms; j++) {
                sum += mat[i][j];
            }
            if(sum > maxRowSum) {
                maxRowSum = sum;
                rowIndex = i;
            }
        }

        int maxColSum = Integer.MIN_VALUE;
        for(int j = 0; j < colms; j++) {
            int sum = 0;
            for(int i = 0; i < rows; i++) {
                sum += mat[i][j];
            }
            if(sum > maxColSum) {
                maxColSum = sum;
                colIndex = j;
            }
        }

        if(maxRowSum >= maxColSum) {
            System.out.println("rows " + rowIndex + " " + maxRowSum);
        } else {
            System.out.println("column " + colIndex + " " + maxColSum);
        }
    }
}
