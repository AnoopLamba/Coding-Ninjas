package HashMaps;

import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> map = new HashMap<>();

        //fill the map
        for(int i : arr) {
            if(map.containsKey(i)) {
                int out = 1 + map.get(i);
                map.put(i, out);
            } else {
                map.put(i, 1);
            }
        }

        //to find number with max frequency
        int maxFreq = -1;
        int ansKey = -1;
        for(Integer i : arr) {
            int value = map.get(i);
            if(value > maxFreq) {
                maxFreq = value;
                ansKey = i;
            }
        }

        return ansKey;
    }

    public static void main(String[] args) {
        int[] arr = {6,0,1};
        System.out.println(maxFrequencyNumber(arr));
    }
}
