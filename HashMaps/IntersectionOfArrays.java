package HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfArrays {
    public static void intersection(int[] arr1, int[] arr2) {
        //sort only second array to reduce the time taken
        Arrays.sort(arr2);

        //build the map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr1) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        //now print the solution
        for(Integer i : arr2) {
            if(map.containsKey(i)) {
                System.out.print(i + " ");
                map.put(i, map.get(i)-1);
                if(map.get(i) <= 0) {
                    map.remove(i);
                }
            }
        }
        System.out.println();
	}
}
