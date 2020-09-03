package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {

    /**
     * 双向 BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        beginQueue.add(beginWord);
        endQueue.add(endWord);
        Set<String> visited = new HashSet<>();
        int len = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() < endQueue.size()) {
                Queue<String> tmp = beginQueue;
                beginQueue = endQueue;
                endQueue = tmp;
            }
            int size = beginQueue.size();
            Queue<String> nextQueue = new LinkedList<>();
            while (size-- > 0) {
                String cur = beginQueue.poll();
                char[] chs = cur.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String newWord = new String(chs);
                        if (newWord.equals(endWord)) {
                            return len + 1;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextQueue.offer(newWord);
                            wordSet.remove(newWord);
                            visited.add(newWord);
                        }
                    }
                    chs[i] = old;
                }
            }
            len++;
            beginQueue = nextQueue;
        }
        return 0;
    }

    /**
     * 简单 BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int times = 1;
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                String cur = queue.poll();
                char[] curChars = cur.toCharArray();
                for (int i = 0; i < curChars.length; ++i) {
                    char old = curChars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        curChars[i] = c;
                        String str = new String(curChars);
                        if (str.equals(endWord)) {
                            return times;
                        }
                        if (!visited.contains(str) && wordSet.contains(str)) {
                            queue.offer(str);
                            visited.add(str);
                        }
                    }
                    curChars[i] = old;
                }
            }
            times++;
        }
        return 0;
    }
}