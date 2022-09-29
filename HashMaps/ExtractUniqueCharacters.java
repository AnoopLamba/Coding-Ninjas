package HashMaps;

import java.util.HashMap;

public class ExtractUniqueCharacters {
    public static String uniqueChar(String str){
		String ans = "";
        HashMap<Character, Boolean> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), true);
                ans += str.charAt(i);
            }
        }

        return ans;
	}
}
