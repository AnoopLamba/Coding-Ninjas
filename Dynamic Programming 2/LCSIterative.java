package Dynamic Programming 2;

public class LCSIterative {
    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m+1][n+1];

        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                int ans = 0;
                if(s1.charAt(i) == s2.charAt(j)) {
                    ans = 1+arr[i+1][j+1];
                } else {
                    int out1 = arr[i][j+1];
                    int out2 = arr[i+1][j+1];
                    ans = Math.max(out1, out2);
                }
                arr[i][j] = ans;
            }
        }

        return arr[0][0];
        
    }
}
