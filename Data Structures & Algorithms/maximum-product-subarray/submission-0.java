class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int res = nums[0];
        for( int curr: nums){
            int temp = Math.max(curr, currMax * curr);
            temp = Math.max(temp, currMin * curr);

            currMin = Math.min( curr, curr * currMin);
            currMin = Math.min(currMin, currMax * curr);

            currMax = temp;
            res = Math.max(res, currMax);
        }
        return res;
    }
}
