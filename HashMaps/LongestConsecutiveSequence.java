package HashMaps;

import java.util.HashMap;
import java.util.ArrayList;

public class LongestConsecutiveSequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer,Boolean> map = new HashMap<>();
        
        for(int val : arr){
            map.put(val,true);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]-1)){
                map.put(arr[i],false);
            }
        }
        
        int start = arr[0]; int mxlen = 1;
        for(int j = 0; j < arr.length; j++){
            
            if(map.get(arr[j]) == true){
                int currStart = arr[j];
                int currLen = 1;
                int i = arr[j];
                
                while(map.containsKey(i+1)){
                    currLen++;
                    i++;
                }
                
                if(currLen > mxlen){
                    mxlen = currLen;
                    start = arr[j];
                }
                
            }
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i]== start){
                
                list.add(arr[i]);
                int j = arr[i];
                while(map.containsKey(j+1)){
                    list.add(j+1);
                    j++;
                }
                
            }
            
        }
        ArrayList<Integer> fin = new ArrayList<>();
        
        int first = list.get(0);
        int last = list.get(list.size()-1);
        fin.add(first);
        fin.add(last);
        
        return fin;
    }

    public static void main(String[] args) {
        int[] arr = {3,7,2,1,9,8,41};
        ArrayList<Integer> list = longestConsecutiveIncreasingSequence(arr);
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
