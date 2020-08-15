package trie;

import java.util.ArrayList;
import java.util.List;

class WordDictionary {

    static class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
            this.isEnd = false;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c) {
            if (!containsKey(c)) {
                this.links[c - 'a'] = new TrieNode();
            }
        }

        public TrieNode get(char c) {
            return this.links[c - 'a'];
        }

        public List<TrieNode> getAll() {
            List<TrieNode> nodeList = new ArrayList<>();
            for (int i = 0; i < R; ++i) {
                if (this.links[i] != null) {
                    nodeList.add(this.links[i]);
                }
            }
            return nodeList;
        }
    }

    private TrieNode node;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.node = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = this.node;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            cur.put(ch);
            cur = cur.get(ch);
        }
        cur.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, this.node, 0);
    }

    private boolean search(String word, TrieNode node, int start) {
        if (start == word.length()) return node.isEnd();
        char ch = word.charAt(start);
        if (ch == '.') {
            for (TrieNode tNode: node.getAll()) {
                if (search(word, tNode, start + 1)) {
                    return true;
                }
            }
            return false;
        } else if (node.containsKey(ch)) {
            return search(word, node.get(ch), start + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean search1 = wordDictionary.search("pad");// -> false
        System.out.println(search1);
        boolean search2 = wordDictionary.search("bad"); // -> true
        System.out.println(search2);
        boolean search3 = wordDictionary.search(".ad"); // -> true
        System.out.println(search3);
        boolean search4 = wordDictionary.search("b.."); //-> true
        System.out.println(search4);

    }
}

