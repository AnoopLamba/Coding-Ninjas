package HashMaps;

import java.util.HashMap;

public class PairSumToZero {
    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        //scanning and filling the map
        for(Integer i : input) {
            if(map.containsKey(-i)) {
                ans += map.get(-i);
            }
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }

        return ans;
	}

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0};
        System.out.println(PairSum(arr, arr.length));
    }
}
