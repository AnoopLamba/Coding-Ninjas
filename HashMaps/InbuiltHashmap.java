package HashMaps;

import java.util.HashMap;
import java.util.Set;

public class InbuiltHashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        //insert into map
        map.put("abc", 1);
        map.put("def", 2);

        //to check if key is present
        if(map.containsKey("abc")) {
            System.out.println("key is present");
        }

        //to get the value
        int a = map.get("abc");
        System.out.println(a);

        //to remove
        map.remove("abc");

        //size of map
        map.size();

        //to iterate using a Set theory
        map.put("abc", 1);
        Set<String> keys = map.keySet();
        for(String s : keys) {
            System.out.println(s);
        }
    }
}
