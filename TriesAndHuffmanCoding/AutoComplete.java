package TriesAndHuffmanCoding;

import java.util.ArrayList;

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

class Trie{
    private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
    
    public void search(String word) {
        searchHelper(root, word, word);
    }
    
    private void searchHelper(TrieNode root, String word, String key) {
        if(word.length() == 0) {
            if(root.isTerminating) {
                System.out.println(key);
                if(root.childCount != 0) {
                    ArrayList<String> list = new ArrayList<>();
                    ArrayList<String> outputList = allWords(root, list, "");
                    for(String s : outputList) {
                        if(s != "") {
                            System.out.println(key + s);
                        }
                    }
                }
            }
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return;
        }
        
        searchHelper(child, word.substring(1), key);
    }
	
	
	public void autoComplete(ArrayList<String> input, String key) {
        //setup the trie
        for(String s : input) {
            add(s);
        }
        
        //find if key is present and print all auto complete suggestions
        search(key);
    }
    
    private ArrayList<String> allWords(TrieNode root, ArrayList<String> list, String parentString) {
        if(root.childCount == 0) {
            return list;
        }
        
        for(int i = 0; i < 26; i++) {
            TrieNode child = root.children[i];
            if(child != null) {
                if(child.isTerminating) {
                    list.add(parentString + child.data);
                    allWords(child, list, parentString + child.data);
                } else {
                    allWords(child, list, parentString+ child.data);
                }
            }
        }

        return list;
    }  
}
