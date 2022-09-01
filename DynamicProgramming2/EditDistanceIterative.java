package DynamicProgramming2;

public class EditDistanceIterative {
    public static int editDistance(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int arr[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            arr[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            arr[0][i]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(m-i)==s2.charAt(n-j)){
                    arr[i][j]=arr[i-1][j-1];
                }
                else{
                    arr[i][j]=1+Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1]));
                }
            }
        }
        return arr[m][n];
    }
}
