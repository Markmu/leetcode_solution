package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
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