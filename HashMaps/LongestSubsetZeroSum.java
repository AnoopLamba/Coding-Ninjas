package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubsetZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int tempLength = 0;
            sum += arr[i];

            //check the sum
            if(sum == 0) {
                maxLength = i+1;
            }
            if(map.containsKey(sum)) {
                tempLength = i-map.get(sum);
            } else {
                map.put(sum, i);
            }

            //compare the length
            if(tempLength > maxLength) {
                maxLength = tempLength;
            }
        }

        return maxLength;
	}
}
