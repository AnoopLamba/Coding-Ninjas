package Dynamic Programming 2;

public class LCSRecursive {
    public static int lcs(String s1, String s2) {
		//base case
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        //minimum work to do
        if(s1.charAt(0) == s2.charAt(0)) {
            return 1 + lcs(s1.substring(1), s2.substring(1));
        } else {
            int out1 = lcs(s1, s2.substring(1));
            int out2 = lcs(s1.substring(1), s2);
            return Math.max(out1, out2);
        }
    }
}
