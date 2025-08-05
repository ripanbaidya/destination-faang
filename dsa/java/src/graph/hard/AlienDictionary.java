package graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 03-08-2025
 *
 * A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[]
 * from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the
 * language’s rules.
 * Your task is to determine the correct order of letters in this alien language based on the given words. If the order
 * is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's
 * rules. If there are multiple valid orders, return any one of them.
 * However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").
 * A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a
 * appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match
 * the beginning of the longer word, the shorter word is considered smaller.
 * Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows
 * the alien language’s lexicographic rules; otherwise, it will print false.
 *
 * Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
 * Output: true
 * Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
 * The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
 * The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
 * The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
 * The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
 * So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
 */
public class AlienDictionary {
    public String findOrder(String[] words) {
        // Step 1: Build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] seen = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                seen[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    found = true;
                    break;
                }
            }

            // Invalid case: prefix conflict
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        // Step 2: Perform topological sort
        int[] indegree = new int[26];
        for (int u = 0; u < 26; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (seen[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append((char)(u + 'a'));
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Step 3: Check for cycles
        int totalSeen = 0;
        for (boolean b : seen) {
            if (b) totalSeen++;
        }

        return sb.length() == totalSeen ? sb.toString() : "";
    }
}
