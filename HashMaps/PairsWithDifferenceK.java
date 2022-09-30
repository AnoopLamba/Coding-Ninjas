package HashMaps;

import java.util.HashMap;

public class PairsWithDifferenceK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
		int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            //this is x+k
            if(map.containsKey(i+k)) {
                ans += map.get(i+k);
            }
            //this is x-k
            if(map.containsKey(i-k) && (i+k) != (i-k)) {
                ans += map.get(i-k);
            }

            //now put the array element in array if not available
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }

        return ans;
	}

    public static void main(String[] args) {
        int[] arr = {4,4,4,4};
        System.out.println(getPairsWithDifferenceK(arr, 0));
    }
}
