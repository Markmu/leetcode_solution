package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class MinimumGeneticMutation {




    /**
     * 双向BFS
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null || bank.length == 0) return -1;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        beginQueue.offer(start);
        endQueue.offer(end);
        char[] mutations = new char[] { 'T', 'A', 'C', 'G' };
        int times = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() < endQueue.size()) {
                Queue<String> tmp = beginQueue;
                beginQueue = endQueue;
                endQueue = tmp;
            }
            Queue<String> next = new LinkedList<>();
            int len = beginQueue.size();
            while (len-- > 0) {
                String cur = beginQueue.poll();
                char[] gChars = cur.toCharArray();
                for (int i = 0; i < gChars.length; ++i) {
                    char old = gChars[i];
                    for (int k = 0; k < mutations.length; ++k) {
                        gChars[i] = mutations[k];
                        String newSequence = new String(gChars);
                        if (newSequence.equals(end)) {
                            return times + 1;
                        }
                        if (bankSet.contains(newSequence) && !visited.contains(newSequence)) {
                            next.offer(newSequence);
                            bankSet.remove(newSequence);
                            visited.add(newSequence);
                        }
                    }
                    gChars[i] = old;
                }
            }
            times++;
            beginQueue = next;
        }
        return -1;
    }


    /**
     * BFS
     */
    public int minMutation1(String start, String end, String[] bank) {
        Set<String> bankset = new HashSet<>(Arrays.asList(bank));
        if (!bankset.contains(end)) return -1;
        if (start.equals(end)) return 0;
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        char[] mutations = new char[] {'A', 'C', 'G', 'T'};
        int times = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                String gSequence = queue.poll();
                if (end.equals(gSequence)) {
                    return times;
                }
                char[] gChars = gSequence.toCharArray();
                for (int i = 0; i < gChars.length; ++i) {
                    char old = gChars[i];
                    for (char m: mutations) {
                        gChars[i] = m;
                        String nextSequence = new String(gChars);
                        if (!visited.contains(nextSequence) && bankset.contains(nextSequence)) {
                            visited.add(nextSequence);
                            queue.offer(nextSequence);
                        }
                    }
                    gChars[i] = old;
                }
            }
            times++;
        }
        return -1;
    }
}