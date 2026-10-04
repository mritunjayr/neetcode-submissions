class Solution {
    int [][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean [][] atl = new boolean[n][m];
        boolean [][] pac = new boolean[n][m];

        for( int i = 0; i < m; i++){
            dfs(0, i, heights, pac);
            dfs(n - 1, i , heights, atl);
        }
        for( int i = 0; i < n; i++){
            dfs(i, 0, heights, pac);
            dfs(i, m - 1 , heights, atl);
        }
        List<List<Integer>> res = new ArrayList<>();
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(atl[i][j] && pac[i][j]){
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int r, int c, int [][] heights, boolean[][] ocean){
        ocean[r][c] = true;
        for( int [] dir : directions){
            int nr = r + dir[0], nc = c + dir[1];
            if( nr >= 0 && nr < heights.length && nc >= 0 && 
                nc < heights[0].length && !ocean[nr][nc] && heights[r][c] <= heights[nr][nc]){
                    dfs(nr, nc, heights, ocean);
                }
        }
    }
}
