class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(prev, nums[1]);
        for( int i = 2; i < nums.length; i ++){
            int temp = Math.max( prev + nums[i], curr );
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
