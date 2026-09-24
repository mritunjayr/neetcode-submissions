class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>());
        return res;
    }
    void backtrack(int[] nums,int idx, int target, List<Integer> path){
        if (target < 0) return;
        if( target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i, target - nums[i], path);
            path.removeLast();
        }
    }
}
