package TriesAndHuffmanCoding;

import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode[] children;
    int childCount;
    boolean isPalin;

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
        this.isPalin = false;
    }
}

class Trie {
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
    }

    public int countWords() {
		return numWords;
	}

    public void add(String word) {
        if(addHelper(root, word)) {
            numWords++;
        }
    }

    private boolean addHelper(TrieNode root, String word) {
        //if empty word is passed
        if(word.length() == 0) {
            if(root.isTerminal) {
                return false;
            } else {
                root.isTerminal = true;
                return true;
            }
        }
        if(word.length() == 1) {
            root.isPalin = true;
        }

        //find the child, if present or not
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        root.isPalin = isPalindrome(word);

        //if child is already present
        return addHelper(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word) {
        //check if it is a terminal or not
        if(word.length() == 0) {
            return root.isTerminal;
        }

        //finding the child
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }

        //if child is present then recursive call
        return searchHelper(child, word.substring(1));
    }

    public void remove(String word) {
        if(removeHelper(root, word)) {
            numWords--;
        }
    }

    private boolean removeHelper(TrieNode root, String word) {
        if(word.length() == 0) {
            if(root.isTerminal) {
                root.isTerminal = false;
                return true;
            } else {
                return false;
            }
        }

        //if child not present
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }

        //if it is present
        boolean out = removeHelper(child, word.substring(1));

        //now we have to completely remove it only when they follow these conditions
        if(!child.isTerminal && (child.childCount == 0)) {
            root.children[childIndex] = null;
            root.childCount--;
        }

        return out;
    }

    public boolean isPalindromePair(ArrayList<String> input) {
        for(String s : input) {
            add(reverse(s));
        }
        
        for(String s : input) {
            if(palinInTrie(root, s)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean palinInTrie(TrieNode root, String word) {
        if(word.length() == 0) {
            if(root.isTerminal) {
                return true;
            }

            if(root.isTerminal == false) {
                if(root.isPalin == true) {
                    return true;
                } else {
                    return false;
                }
            } 
        }
        if((word.length() != 0) && (root.isTerminal == true)) {
            return isPalindrome(word);
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }

        return palinInTrie(child, word.substring(1));
    }

    private boolean isPalindrome(String word) {
        String ans = "";
        int n = word.length();
        for(int i = n-1; i >= 0; i--) {
            ans += word.charAt(i);
        }

        return ans.equals(word);
    }

    private String reverse(String word) {
        String ans = "";
        int n = word.length();
        for(int i = n-1; i >= 0; i--) {
            ans += word.charAt(i);
        }

        return ans;
    }
}
