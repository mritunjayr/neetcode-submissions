class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        if (!dfs(0, -1, adj, vis)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                return false;
        }
        return true;
    }
    boolean dfs(int curr, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[curr] = true;
        boolean res = true;
        for (int nei : adj.get(curr)) {
            if (vis[nei] && nei != parent)
                return false;
            if (nei == parent)
                continue;
            res = res && dfs(nei, curr, adj, vis);
        }
        return res;
    }
}
