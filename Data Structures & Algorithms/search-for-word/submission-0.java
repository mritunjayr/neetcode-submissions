class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i , j, n, m, board, 0, word)) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int r, int c, int n, int m , char[][]board, int i, String word){
        if( i == word.length()) return true;
        if ( r < 0 || r >=n || c < 0 || c >= m){
            return false;
        }
        if( word.charAt(i) == board[r][c]) {
            char temp = board[r][c];
            board[r][c] = '#';
            boolean result = dfs(r, c - 1, n, m, board, i + 1, word)
            || dfs(r, c + 1, n, m, board, i + 1, word)
            || dfs(r + 1, c, n, m, board, i + 1, word)
            || dfs(r - 1, c, n, m, board, i + 1, word);
            if(result) return true;
            board[r][c] = temp;
        }
        return false;
    }

}
