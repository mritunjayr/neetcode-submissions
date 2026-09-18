class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        String res = "";
        for(int col = 0; col < strs[0].length();  col++){
            for(int row = 1; row < n; row++){
                if(strs[row].length() <= col || strs[row].charAt(col) != strs[row - 1].charAt(col)){
                    return res;
                }
            }
            res += strs[0].charAt(col);
        }
        return res;
    }
}