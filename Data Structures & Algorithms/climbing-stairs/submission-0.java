class Solution {
    public int climbStairs(int n) {
        if( n < 2) return 1;
        int prev = 1;
        int curr = prev;
        for( int i = 1; i<= n; i++){
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return prev; 
    }
}
