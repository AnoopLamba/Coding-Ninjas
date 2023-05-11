package Java.Strings;

public class CheckPermutation {
    public static boolean isPermutation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if(m != n) {
            return false;
        }

        int[] arr = new int[256];
        for(int i = 0; i < m; i++) {
            arr[str1.charAt(i)] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(arr[str2.charAt(i)] == 0) {
                return false;
            }
        }

        return true;
    }
}
