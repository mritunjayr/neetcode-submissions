class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] pre: prerequisites){
            int a = pre[0], b = pre[1];
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(b).add(a);
            indegree[a]++;
        }
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if( indegree[i] == 0) {
                q.add(i);
                vis.add(i);
            }
        }
        while(! q.isEmpty()){
            int curr = q.poll();
            for(int nei : adj.getOrDefault(curr, new ArrayList<>())){
                indegree[nei]--;
                if(indegree[nei] == 0 && !vis.contains(nei)){
                    q.add(nei);
                    vis.add(nei);
                }
            }
        }
        return vis.size() == numCourses;
    }
}
