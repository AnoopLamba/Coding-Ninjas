package DynamicProgramming2;

public class LCSMemoization {
    public static int lcs(String s1, String s2) {
		int[][] arr = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -1;
            }
        }

        return helper(s1, s2, 0, 0, arr);
    }

    public static int helper(String s1, String s2, int i, int j, int[][] arr) {
        //base case
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        //minimum work to do
        if(s1.charAt(0) == s2.charAt(0)) {
            int ans;
            if(arr[i+1][j+1] == -1) {
                ans = helper(s1, s2, i+1, j+1, arr);
                arr[i+1][j+1] = ans;
            } else {
                ans = arr[i+1][j+1];
            }
            return ans+1;
        } else {
            int out1,out2;
            if(arr[i][j+1] == -1) {
                out1 = helper(s1, s2, i, j+1, arr);
                arr[i][j+1] = out1;
            } else {
                out1 = arr[i][j+1];
            }

            if(arr[i+1][j] == -1) {
                out2 = helper(s1, s2, i+1, j, arr);
                arr[i+1][j] = out2;
            } else {
                out2 = arr[i+1][j];
            }

            return Math.max(out1, out2);
        }
    }
}
