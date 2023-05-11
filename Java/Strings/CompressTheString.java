package Java.Strings;

public class CompressTheString {
    public static String compress(String str) {
        int n = str.length();
        String out = "";
        int occurance = 1;
        for(int i = 1; i < n; i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                occurance++;
            }
            if(str.charAt(i) != str.charAt(i-1)) {
                out += str.charAt(i-1);
				if(occurance != 1) {
					out += occurance;
				}
                occurance = 1;
            }
            if(i == n-1) {
                out += str.charAt(i);
				if(occurance != 1) {
					out += occurance;
				}
            }
        }

        return out;
    }
}
