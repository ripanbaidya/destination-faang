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
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * time: O(word.lenght * 26 * N * log n)
 * space: O(N)
 */
class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        queue<pair<string, int>> q; // {word, steps}
        q.push({beginWord, 1});
        set<string> st(wordList.begin(), wordList.end());

        while (!q.empty())
        {
            string word = q.front().first;
            int steps = q.front().second;
            q.pop();

            // found
            if (word == endWord)
                return steps;

            for (int i = 0; i < word.size(); i++)
            {
                char originalChar = word[i]; // store original character

                for (char ch = 'a'; ch <= 'z'; ch++)
                {
                    word[i] = ch; // change the characte

                    if (st.find(word) != st.end())
                    {
                        q.push({word, steps + 1});
                        st.erase(word);
                    }
                }
                // update tor original word
                word[i] = originalChar;
            }
        }

        return 0; // not found
    }
};