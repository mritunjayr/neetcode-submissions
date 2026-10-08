class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], curr = 0;
        for(int each: nums){
            curr += each;
            if ( each > curr){
                curr = each;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
