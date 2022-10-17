package TriesAndHuffmanCoding;

import java.util.ArrayList;

public class PatternMatching {
    static Trie trie = new Trie();

    public static boolean patternMatching(ArrayList<String> input, String pattern) {
        for(String word : input) {
            suffixTrie(word);
            prefixTrie(word);
        }
        
        return trie.search(pattern);
	}
    
    private static void suffixTrie(String word) {
        int n = word.length();
        for(int i = n-1; i >= 0; i--) {
            String newWord = word.substring(i,n);
            trie.add(newWord);
        }
    }
    
    private static void prefixTrie(String word) {
        int n = word.length();
        for(int i = 0; i <= n; i++) {
            String newWord = word.substring(0,i);
            trie.add(newWord);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("hg");
        System.out.println(patternMatching(list, "de"));
    }
}
