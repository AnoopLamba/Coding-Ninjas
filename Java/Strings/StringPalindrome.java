package Java.Strings;

public class StringPalindrome {
    public static boolean isPalindrome(String str) {
        int n = str.length();
        if(n == 1) {
            return true;
        } else if(n == 0) {
            return false;
        }

        int i = 0, j = n-1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
