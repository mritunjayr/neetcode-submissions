class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chars={}
        for ch in s:
            chars[ch] = chars.get(ch, 0) + 1
        
        for ch in t:
            if chars.get(ch, 0 ) < 1:
                return False
            chars[ch] -= 1
            if chars[ch] == 0:
                del chars[ch]
        
        return len(chars) == 0
        