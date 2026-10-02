class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        int n = s.length();
        for(int i = 0; i< n; i++){
            int odd = longest(s, i , i);
            if ( odd > maxLen){
                start = i - odd / 2;
                maxLen = odd;
            }
            int even = longest(s, i , i + 1);
            if (even > maxLen){
                start = i - even / 2 + 1;
                maxLen = even;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int longest(String s, int i, int j){
        while(i >= 0 && j < s.length() 
        && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }
}
