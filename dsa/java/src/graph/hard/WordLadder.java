package graph.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 2025-07-30
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
 * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * 1. Every adjacent pair of words differs by a single letter.
 * 2. Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * 3. sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in
 * the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Example:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which
 * is 5 words long.
 *
 * time: O(word.length * 26 * N * log n)
 * space: O(N)
 */
public class WordLadder {
    // Custom Pair class to hold the current word and the number of steps taken to reach it
    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Queue for BFS traversal
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1)); // Start with beginWord at step 1

        // Set for fast lookup of words and to avoid revisiting
        HashSet<String> st = new HashSet(wordList);
        st.remove(beginWord); // No need to process beginWord again

        // BFS
        while (!q.isEmpty()) {
            Pair pair = q.poll(); // Get the front element in the queue
            String word = pair.word;
            int steps = pair.steps;

            // If we've reached the endWord, return the number of steps taken
            if (word.equals(endWord)) return steps;

            // Try changing each character in the word to every letter from 'a' to 'z'
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // Create a new word by replacing one character
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // If the new word is in the set, add it to the queue for further exploration
                    if (st.contains(replacedWord)) {
                        q.offer(new Pair(replacedWord, steps + 1));
                        st.remove(replacedWord); // Remove to prevent revisiting
                    }
                }
            }
        }

        // If endWord was never reached
        return 0;
    }

    public static void main(String[] args) {
        var obj = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        int ladderLength = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of ladder: " + ladderLength);
    }
}
