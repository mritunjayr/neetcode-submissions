class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String s: strs){
            res += s.length() +"#"+ s;
        }
        return res;
    }

    public List<String> decode(String str) {
        int start = 0;
        List<String> res  = new ArrayList<>();
        while(start < str.length()){
            String len = "";
            while(str.charAt(start) != '#'){
                len += str.charAt(start);
                start++;
            }
            start++;
            int l = Integer.parseInt(len);
            res.add(str.substring(start, start + l));
            start += l;
        }
        return res;
    }
}
