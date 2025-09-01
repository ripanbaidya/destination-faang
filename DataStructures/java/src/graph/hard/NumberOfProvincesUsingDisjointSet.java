package graph.hard;

/**
 * @author Ripan Baidya
 * @date 15-08-2025
 *
 * There are n cities. Some of them are connected, while some are not. If city an  is
 * connected directly with city b, and city b is connected directly with city c, then
 * city an is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities
 * outside the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1,if the ith city
 * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class NumberOfProvincesUsingDisjointSet {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        int components = 0; // number of provinces

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (isConnected[i][j] == 1
                        && dsu.findParent(i) != dsu.findParent(j))
                    dsu.unionBySize(i, j);
            }
        }

        // counting the number of components
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(i) == i) {
                components++;
            }
        }

        return components;
    }

    public static void main(String[] args) {
        NumberOfProvincesUsingDisjointSet obj = new NumberOfProvincesUsingDisjointSet();

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int numberOfProvinces = obj.findCircleNum(isConnected);
        System.out.println("Number of provinces are: " + numberOfProvinces);
    }
}
