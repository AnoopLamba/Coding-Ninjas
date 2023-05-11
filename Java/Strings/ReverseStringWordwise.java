package Java.Strings;

public class ReverseStringWordwise {
    public static String reverse(String str) {
        int n = str.length();
        String out = "";

        int wordStart = 0;
        int wordEnd = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == ' ') {
                wordEnd = i;
                out = str.substring(wordStart, wordEnd) + " " + out;
                wordStart = i+1;
            }
            if(i == n-1) {
				wordEnd = i+1;
				out = str.substring(wordStart, wordEnd) + " " + out;
			}
        }

        return out;
    }
}
