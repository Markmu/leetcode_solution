package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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