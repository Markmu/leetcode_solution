package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList); 
        if (!wordSet.contains(endWord)) return result;
        LinkedList<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        visited.add(beginWord);
        ArrayList<String> solution = new ArrayList<>();
        solution.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Set<String> subSet = new HashSet<>();
            while (len-- > 0) {
                List<String> curPath = queue.poll();
                String cur = curPath.get(curPath.size() - 1);
                List<String> neighbors = getNeighbors(cur, wordSet);
                for (String str: neighbors) {
                    if (!visited.contains(str)) {
                        if (str.equals(endWord)) {
                            found = true;
                            curPath.add(str);
                            result.add(new ArrayList<>(curPath));
                            curPath.remove(curPath.size() - 1);
                            break;
                        }
                        curPath.add(str);
                        queue.offer(new ArrayList<>(curPath));
                        curPath.remove(curPath.size() - 1);
                        subSet.add(str);                      
                    }
                }
            }
            if (found) break;
            visited.addAll(subSet);
        }
        return result;
    }

    private List<String> getNeighbors(String cur, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] curChars = cur.toCharArray();
        for (int i = 0; i < curChars.length; ++i) {
            char old = curChars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                curChars[i] = c;
                String next = new String(curChars);
                if (wordSet.contains(next)) {
                    neighbors.add(next);
                }
            }
            curChars[i] = old;
        }
        return neighbors;
    }
}