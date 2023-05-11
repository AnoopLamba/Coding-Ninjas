package Java.Strings;

public class CountTheWords {
    public static int count(String str) {
        int n = str.length();
        if(n == 0) {
            return 0;
        }
        int spaces = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == ' ') {
                spaces++;
            }
        }

        return spaces+1;
    }
}
