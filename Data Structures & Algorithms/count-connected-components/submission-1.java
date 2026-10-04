class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int [] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.comp;
    }
    class UnionFind{
        int comp;
        int [] parent, size;
        public UnionFind(int n ){
            comp = n;
            parent = new int[n];
            size = new int[n];
            for( int i = 0; i< n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int node){
            if( parent[node] == node) 
                return node;
            return parent[node] = find(parent[node]);
        }
        void union(int u, int v){
            int pu = find(u), pv = find(v);
            if( pu == pv) return;
            if( size[pu] > size[pv]){
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            parent[pv] = pu;
            size[pu] += size[pv];
            comp--;
        }
    }
}
