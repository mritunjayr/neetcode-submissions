class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] < nums[n - 1]) return nums[0];
        return search(nums, 0 , n - 1);
    }
    int search(int [] nums, int i, int j){
        while( i < j){
            int mid = i + (j - i) / 2;
            if( nums[mid] < nums[j]){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
