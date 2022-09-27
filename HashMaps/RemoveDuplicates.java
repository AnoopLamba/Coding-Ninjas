package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(int[] input) {
        //we will be using ArrayList for the answer, because we dont know
        //the size of output yet

        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])) {
                continue;
            }
            map.put(input[i], true);
            output.add(input[i]);
        }

        return output;
    }
    
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 2, 4, 3, 1, 5, 8, 2};
        ArrayList<Integer> output = removeDuplicates(input);
        System.out.println(output);
    }
}
