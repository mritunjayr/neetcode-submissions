class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int res = 0;
        for(int i= 0; i< n ; i++){
            for( int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j] ){
                    res++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int r, int c, boolean [][] visited){
        if( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)return;
        if(grid[r][c] != '1' || visited[r][c]) return;
        visited[r][c]= true;

        dfs(grid, r , c + 1, visited);
        dfs(grid, r , c - 1, visited);
        dfs(grid, r  - 1 , c, visited);
        dfs(grid, r + 1 , c, visited);
    }
}
