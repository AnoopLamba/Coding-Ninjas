package Java.Strings;

public class HighestOccuringCharacter {
    public static char highestOccuring(String str) {
        int n = str.length();
        int maxFrequency = 0;
        char answerChar = ' ';
        int[] arr = new int[256];

        for(int i = 0; i < n; i++) {
            arr[str.charAt(i)]++;
        }

        for(int i = 0; i < n; i++) {
            if(arr[str.charAt(i)] > maxFrequency) {
                maxFrequency = arr[str.charAt(i)];
                answerChar = str.charAt(i);
            }
        }

        return answerChar;
    }
}
