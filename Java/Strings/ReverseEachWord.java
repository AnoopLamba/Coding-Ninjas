package Java.Strings;

public class ReverseEachWord {
    private static String reverseTheWord(String input) {
        String output = "";
        for(int i = input.length()-1; i >= 0; i--) {
            output += input.charAt(i);
        }

        return output;
    }

    public static String reverseEachWord(String str) {
        int n = str.length();
        if(n == 0 || n == 1) {
            return str;
        }

        String answer = "";
        int wordStart = 0;
        int wordEnd = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == ' ') {
                wordEnd = i;
                String word = str.substring(wordStart, wordEnd);
                if(answer == "") {
                    answer += reverseTheWord(word);
                } else {
                    answer += " " + reverseTheWord(word);
                }
                wordStart = i+1;
            }
            if(i == n-1) {
				wordEnd = i+1;
				String word = str.substring(wordStart, wordEnd);
                answer += " " + reverseTheWord(word);
			}
        }

        return answer;
    }
}
