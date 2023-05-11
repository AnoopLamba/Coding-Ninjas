package Java.Strings;

public class RemoveConsecutiveDuplicates {
    public static String removeDuplicates(String str) {
        int n = str.length();
        if(n == 0 || n==1) {
            return str;
        }

        String output = "";
        output += str.charAt(0);
        for(int i = 1; i < n; i++) {
            if(str.charAt(i) != str.charAt(i-1)) {
                output += str.charAt(i);
            }
        }

        return output;
    }
}
