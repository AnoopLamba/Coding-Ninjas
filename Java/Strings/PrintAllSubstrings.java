package Java.Strings;

public class PrintAllSubstrings {
    public static void allSubstrings(String str) {
        int n = str.length();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
}
