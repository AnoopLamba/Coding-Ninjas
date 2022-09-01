package DynamicProgramming2;
import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] arr = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++) {
            Arrays.fill(arr[i], -1);
        }

        return helper(s, t, m, n, arr);
    }

    public static int helper(String s, String t, int m, int n, int[][] arr) {
        //base case
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }

        //minimum work to do
        if(arr[m][n] != -1) {
            return arr[m][n];
        } else {
            if(s.charAt(m-1) == t.charAt(n-1)) {
                return arr[m][n] = helper(s, t, m-1, n-1, arr);
            } else {
                int insert = helper(s, t, m, n-1, arr);
                int delete = helper(s, t, m-1, n, arr);
                int replace = helper(s, t, m-1, n-1, arr);
                return arr[m][n] = 1+Math.min(insert, Math.min(delete, replace));
            }
        }
    }

    public static void main(String[] args) {
        String s = "whgtdwhgtdg";
        String t = "aswcfg";
        System.out.println(editDistance(s, t));
    }
}