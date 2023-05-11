package Java.TwoDimensionalArrays;

public class TotalSumOfBoundaries {
    public static void totalSum(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) {
            System.out.println(0);
            return;
        }
        int cols = mat[0].length;

        int firstRowSum = 0;
        for(int i = 0; i < cols; i++) {
            firstRowSum += mat[0][i];
            mat[0][i] = 0;
        }
        int lastRowSum = 0;
        for(int i = 0; i < cols; i++) {
            lastRowSum += mat[rows-1][i];
            mat[rows-1][i] = 0;
        }

        int firstColSum = 0;
        for(int i = 1; i < rows-1; i++) {
            firstColSum += mat[i][0];
            mat[i][0] = 0;
        }
        int lastColSum = 0;
        for(int i = 1; i < rows-1; i++) {
            firstColSum += mat[i][cols-1];
            mat[i][cols-1] = 0;
        }

        int leftDiagonalSum = 0;
        for(int i = 1; i < rows-1; i++) {
            leftDiagonalSum += mat[i][i];
            mat[i][i] = 0;
        }
        int rightDiagonalSum = 0;
        int i = 0;
        int j = cols-1;
        while(i < rows && j >= 0) {
            rightDiagonalSum += mat[i][j];
            i++;
            j--;
        }

        int sum = firstRowSum+lastRowSum+firstColSum+lastColSum+leftDiagonalSum+rightDiagonalSum;
        System.out.println(sum);
    }
}
