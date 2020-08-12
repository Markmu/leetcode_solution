package trie;

class Tire {
    static class TrieNode {
        private TrieNode[] nodes;
        private final int R = 26;
        private boolean isEnd;
        public TrieNode() {
            this.nodes = new TrieNode[this.R];
        }
        public void setEnd() {
            this.isEnd = true;
        }
        public boolean isEnd() {
            return this.isEnd;
        }
        public boolean containsKey(char c) {
            return nodes[c - 'a'] != null;
        }
        public void put(char c)  {
            if (containsKey(c)) {
                return;
            }
            nodes[c - 'a'] = new TrieNode();
        }
        public TrieNode get(char c) {
            return nodes[c - 'a'];
        }
    }
    private TrieNode trieNode;
    /** Initialize your data structure here. */
    public Trie() {
        this.trieNode = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.trieNode;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            cur.put(ch);
            cur = cur.get(ch);
        }
        cur.setEnd();
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode cur = this.trieNode;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!cur.containsKey(ch)) {
                return null;
            }
            cur = cur.get(ch);
        }
        return cur;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tailNode = searchPrefix(word);
        if (tailNode != null && tailNode.isEnd()) {
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}