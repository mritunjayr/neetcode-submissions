class Solution {
    public int uniquePaths(int m, int n) {
        int [] prev = new int[n];
        int [] curr = new int[n];

        for( int i = 0; i < m; i++){
            curr[0] = 1;
            for(int j = 1; j < n; j++){
                curr[j] = curr[j - 1] + prev[j];
            }
            prev = curr;
            curr = new int[n];
        }
        return prev[n - 1];
    }
}
