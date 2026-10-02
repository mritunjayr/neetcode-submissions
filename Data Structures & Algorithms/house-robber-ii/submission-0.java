class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    private int rob(int [] nums,int i ,int j){
        if ( j == i) return nums[i];
        int prev = nums[i];
        int curr = Math.max(prev, nums[ i + 1]);
        for( int k = i + 2; k <= j; k++){
            int temp = Math.max(curr, prev + nums[k]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
