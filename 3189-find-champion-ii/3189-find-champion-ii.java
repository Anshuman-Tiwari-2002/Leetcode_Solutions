class Solution {
    public int findChampion(int n, int[][] edges) {
        // Initialize an array to keep track of in-degrees for each node.
        int[] inDegree = new int[n];
        
        // Iterate through the edges to calculate in-degrees.
        // For each edge [u, v], increment the in-degree of node v.
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        // Variables to store the potential champion node (ans)
        // and a counter to track the number of nodes with in-degree 0.
        int ans = -1, counter = 0;

        // Traverse all nodes to find nodes with in-degree 0.
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {  // Node with in-degree 0 found.
                ans = i;            // Update potential champion.
                counter++;          // Increment the counter.
            }
        }

        // If exactly one node has in-degree 0, return it as the champion.
        if (counter == 1) return ans;

        // Otherwise, return -1 (no valid champion exists).
        return -1;
    }
}