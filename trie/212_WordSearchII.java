package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return new ArrayList<>();
        this.node = new TrieNode();
        TrieNode cur = this.node;
        for (String word: words) {
            addWord(word);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                backtrace(board, i, j, cur, res);
            }
        }
        return new ArrayList<>(res);

    }

    private int[] dx = new int[] {0, 1, 0, -1};
    private int[] dy = new int[] {-1, 0, 1, 0};

    private void backtrace(char[][] board, int i, int j, TrieNode node, Set<String> res) {
        char ch = board[i][j];
        if (ch == '#' || !node.containsKey(ch)) {
            return;
        }
        board[i][j] = '#';
        node = node.get(ch);
        if (node.isEnd() && node.word != null) {
            res.add(node.word);
        }
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k]; int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                backtrace(board, x, y, node, res);
            }
        }
        board[i][j] = ch;
    }
    
    private TrieNode node;

    public void addWord(String word) {
        TrieNode cur = this.node;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            cur.put(ch);
            cur = cur.get(ch);
        }
        cur.setEnd();
        cur.word = word;
    }

    static class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public String word;

        public TrieNode() {
            this.links = new TrieNode[this.R];
            this.isEnd = false;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public boolean containsKey(char c) {
            return this.links[c - 'a'] != null;
        }

        public void put(char c) {
            if (!containsKey(c)) {
                this.links[c - 'a'] = new TrieNode();
            }            
        }

        public TrieNode get(char c) {
            return this.links[c - 'a'];
        }
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
        char[][] board = new char[][] {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea","eat", "rain"};
        System.out.println(ws.findWords(board, words));

    }
}