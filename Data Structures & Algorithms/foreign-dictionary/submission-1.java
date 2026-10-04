class Solution {
    List<Character> result;
    public String foreignDictionary(String[] words) {
        String prev = "";
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> vis = new HashMap<>();
        result = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (dfs(c, adj, vis)) {
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }
        return sb.toString();
    }
    private boolean dfs(char ch, Map<Character, Set<Character>> adj, Map<Character, Boolean> vis) {
        if (vis.containsKey(ch)) {
            return vis.get(ch);
        }
        vis.put(ch, true);
        for (char next : adj.getOrDefault(ch, new HashSet<>())) {
            if (dfs(next, adj, vis)) {
                return true;
            }
        }
        vis.put(ch, false);
        result.add(ch);
        return false;
    }
}
