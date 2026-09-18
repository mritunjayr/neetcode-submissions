class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        state = set()
        for n in nums:
            if n in state:
                return True
            state.add(n)
        
        return False

        