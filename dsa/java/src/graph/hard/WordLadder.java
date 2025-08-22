package graph.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 2025-07-30
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
 * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * 1. Every adjacent pair of words differs by a single letter.
 * 2. Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * 3. sk == endWord
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in
 * the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * Example:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which
 * is 5 words long.
 * <p>
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
        // Set for fast lookup of words and to avoid revisiting
        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord); // No need to process beginWord again

        // Queue for BFS traversal
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1)); // Start with beginWord at step 1

        // BFS
        while (!q.isEmpty()) {
            Pair top = q.poll(); // Get the top element in the queue
            String currWord = top.word;
            int currSteps = top.steps;

            // Try changing each character in the word to every letter from 'a' to 'z'
            // Iterate over each character in the current word
            for (int i = 0; i < currWord.length(); i++) {
                StringBuilder tempWord = new StringBuilder(currWord); // create a copy of the word

                // Iterate over each possible character to replace the current character
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // replace the character at index i with ch
                    tempWord.setCharAt(i, ch);

                    // check if the resulting word is in the dictionary
                    if (wordSet.contains(tempWord.toString())) {
                        // add it to the queue along with the current steps plus one
                        q.offer(new Pair(tempWord.toString(), currSteps + 1));
                        // remove it from the set to avoid revisiting
                        wordSet.remove(tempWord.toString());

                        // check if it's the target word
                        if (tempWord.toString().equals(endWord)) {
                            // return the steps plus one as the length of the ladder
                            return currSteps + 1;
                        }
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
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        int ladderLength = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of ladder: " + ladderLength);
    }
}
