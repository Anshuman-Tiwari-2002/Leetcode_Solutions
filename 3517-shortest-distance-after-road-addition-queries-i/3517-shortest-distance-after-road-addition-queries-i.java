class Solution {
    // Adjacency list to represent the graph
    List<List<Integer>> adj;

    // dp array to store the shortest distance from city 0 to each city
    int[] dp;

    // Total number of cities
    int n;

    /**
     * This method computes the shortest path after each query.
     *
     * @param n The number of cities.
     * @param queries A 2D array representing the queries with new roads to be added.
     * @return An array representing the shortest path after each query.
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the number of cities and the adjacency list
        this.n = n;
        adj = new ArrayList<>();

        // Initialize adjacency list with an empty list for each city
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Initially, there are roads from city i to city i+1
        for (int i = 0; i <= n - 2; i++) {
            adj.get(i).add(i + 1);
        }

        // Array to store the answer for each query
        int[] ans = new int[queries.length];

        // Variable to iterate over the queries
        int i = 0;

        // Initialize the dp array to store shortest distances
        dp = new int[n];

        // Process each query
        for (int[] query : queries) {
            // Add the new road to the graph
            adj.get(query[0]).add(query[1]);

            // Reset the dp array for the new query
            Arrays.fill(dp, -1);

            // Compute the shortest path from city 0 to city n-1 and store it in the answer array
            ans[i++] = sol(0);
        }

        // Return the array with the shortest path lengths for each query
        return ans;
    }

    /**
     * This method computes the shortest path from city u to city n-1 using DFS and memoization.
     *
     * @param u The current city.
     * @return The shortest distance from city u to city n-1.
     */
    private int sol(int u) {
        // If we have reached city n-1, return 0 as the distance is 0 (no more roads to traverse)
        if (u == n - 1) {
            return 0;
        }

        // If the shortest distance from city u has already been computed, return the cached result
        if (dp[u] != -1)
            return dp[u];

        // Initialize the minimum distance to a large number (infinity)
        int min = n + 1;

        // Explore all the neighbors (cities that can be reached from the current city u)
        for (Integer nei : adj.get(u)) {
            // Recursively compute the shortest distance for each neighbor and update the minimum distance
            min = Math.min(min, 1 + sol(nei));
        }

        // Store the computed shortest distance in the dp array for city u and return the result
        return dp[u] = min;
    }
}