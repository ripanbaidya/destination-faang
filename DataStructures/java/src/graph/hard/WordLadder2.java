package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 2025-08-23
 *
 * Given two distinct words startWord and targetWord, and a list denoting wordList of
 * unique words of equal lengths. Find all shortest transformation sequence(s)  from
 * startWord to targetWord. You can return them in any order possible.
 * Keep the following conditions in mind:
 *
 * A word can only consist of lowercase characters.
 * Only one letter can be changed in each transformation.
 * Each transformed word must exist in the wordList including the targetWord.
 * startWord may or may not be part of the wordList.
 * Return an empty list if there is no such transformation sequence.
 *
 * Example:
 * Input:
 * startWord = "der", targetWord = "dfs",
 * wordList = {"des","der","dfr","dgt","dfs"}
 * Output:
 * der dfr dfs
 * der des dfs
 * Explanation:
 * The length of the smallest transformation is 3.
 * And the following are the only two ways to get
 * to targetWord:-
 * "der" -> "des" -> "dfs".
 * "der" -> "dfr" -> "dfs".
 */
public class WordLadder2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Put all words into a set for fast lookup
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        if (!wordSet.contains(targetWord)) return result; // quick exit if target not present

        // Queue for BFS - each element is a path (sequence of words)
        Queue<ArrayList<String>> q = new LinkedList<>();

        // Start with the starting word
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(startWord);
        q.offer(startPath);

        // Track used words on the current BFS level
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 1; // track BFS level (start word = level 1)

        while (!q.isEmpty()) {
            ArrayList<String> path = q.poll();

            // If we moved to the next level, remove all used words from previous level
            if (path.size() > level) {
                level++;
                for (String usedWord : usedOnLevel) {
                    wordSet.remove(usedWord);
                }
                usedOnLevel.clear();
            }

            // Last word in the current path
            String word = path.get(path.size() - 1);

            // If we reached the target word
            if (word.equals(targetWord)) {
                if (result.isEmpty()) {
                    result.add(new ArrayList<>(path));
                } else if (result.get(0).size() == path.size()) {
                    result.add(new ArrayList<>(path));
                }
                // Don't return early → we need all sequences of same min length
            }

            // Try changing each character of word
            for (int i = 0; i < word.length(); i++) {
                StringBuilder tempWord = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    tempWord.setCharAt(i, ch);

                    String newWord = tempWord.toString();
                    if (wordSet.contains(newWord)) {
                        path.add(newWord); // add to current path

                        // Add a copy of path to queue
                        q.offer(new ArrayList<>(path));

                        // Mark it used for this level
                        usedOnLevel.add(newWord);

                        // Backtrack → remove last added word
                        path.remove(path.size() - 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var obj = new WordLadder2();

        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des","der","dfr","dgt","dfs"};

        ArrayList<ArrayList<String>> result = obj.findSequences(startWord, targetWord, wordList);
        System.out.println(result);
    }
}
