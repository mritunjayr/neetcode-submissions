class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, w});
        }

        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        boolean [] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{ 0, src});
        dist[src] = 0;

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int w = curr[0], u = curr[1];
            if(visited[u]) continue;
            visited[u] = true;
            for(int [] nxt: adj.getOrDefault(u, new ArrayList<>())){
                int nxt_w = nxt[1], v = nxt[0];
                if(!visited[v]){
                    pq.add(new int []{ w + nxt_w, v});
                    dist[v] = Math.min(dist[v],  w + nxt_w);
                }
            }
        }
        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i< n; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
            res.put(i, dist[i]);
        }
        return res;
    }  
}
