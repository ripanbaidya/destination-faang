package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 15-08-2025
 *
 * Given a list of accounts of size n where each element accounts [ i ] is a list of strings,
 * where the first element account [i][0] is a name, and the rest of the elements are emails
 * representing emails of the account. Geek wants you to merge these accounts. Two accounts
 * belong to the same person if there is some common email to both accounts. Note that even
 * if two accounts have the same name, they may belong to different people as  people could
 * have the same name. A person can have any number of accounts initially, but all of their
 * accounts have the same name.
 * After merging the accounts, return the accounts in the following format: The first element
 * of each account is the name, and the rest of the elements are emails in sorted order.
 *
 * Note: Accounts themselves can be returned in any order.
 *
 * Input:
 * n = 4, accounts [ ] = [
 *      ["John","johnsmith@mail.com","john_newyork@mail.com"],
 *      ["John","johnsmith@mail.com","john00@mail.com"],
 *      ["Mary","mary@mail.com"],
 *      ["John","johnnybravo@mail.com"]
 * ]
 * Output:
 * [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],
 * ["Mary","mary@mail.com"],
 * ["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other
 * accounts.We could return these arrays in any order,
 * for example, the answer [
 *      ['Mary', 'mary@mail.com'],
 *      ['John', 'johnnybravo@mail.com'],
 *      ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']
 * ] would still be accepted.
 */
public class AccountMerge {
    public ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Step 1: Union accounts with same email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail)) {
                    dsu.unionBySize(i, mapMailNode.get(mail));
                } else {
                    mapMailNode.put(mail, i);
                }
            }
        }

        // Step 2: Group emails by their parent node
        List<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int parentNode = dsu.findParent(entry.getValue());
            mergedMail[parentNode].add(mail);
        }

        // Step 3: Build final answer
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // name
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }

        return ans;
    }
}
