import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        int n = words.length;
        boolean[] visited = new boolean[n];

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(begin, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.word.equals(target)) return cur.depth;

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if (diffOne(cur.word, words[i])) {
                    visited[i] = true;
                    q.offer(new State(words[i], cur.depth + 1));
                }
            }
        }

        return 0;
    }

    private boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    static class State {
        String word;
        int depth;
        State(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}